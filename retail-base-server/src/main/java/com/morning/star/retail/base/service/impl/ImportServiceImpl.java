package com.morning.star.retail.base.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.base.service.ImportService;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.ImportBaseModel;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.exception.RetailErrorCode;

/**
 * 公用导入
 * @author zhouwen
 */
public abstract class ImportServiceImpl  implements ImportService{
	private static final Gson GSON = new Gson();
	private static final Logger LOGGER = LoggerFactory.getLogger(ImportServiceImpl.class);



	/**
	 * 各个key与字段的对应关系
	 */
	protected List<ImportBaseModel> modeList = null;
	
	/**
	 * 收件人列表 如果有特殊需求可以使用此作为批量邮件发送
	 */
	protected List<String> emailList = null;
	
	/**
	 * 文件类型
	 */
	protected OriginalType fileType=null;
	
	/**
	 * 主数据Id
	 */
	protected String masterId= null;
	
	protected String emailTile="【批量导入提醒】";
	
	public ImportServiceImpl(){
		
	}
	
	/*public ImportServiceImpl(ImportDTO dto){
		
	   
		this.emailList=dto.getEmailList();
 		this.fileType=dto.getFileType();
	}
	*/
	
	
	
	/**
	 * 检查文件key-value对应关系是否配置
	 */
	protected void checkInitValueMap(){
		if(modeList==null || modeList.isEmpty()){
			throw RetailErrorCode.UPLOAD_FILE_VALUEMAP_EMPTY.build();
		}
	}
	
	/**
	 * 批量导入文件，每次处理一条不考虑事物一致性
	 * @param file	导入的文件
	 */
	public void importDataForOnce(MultipartFile file,AdminLoginContent userInfo){
		//检查初始化数据
		checkInitValueMap();
		//检查文件头部
		checkInputFileType(file);
		//检查文件头部内容葛是是否一致
		List<Map<String,Object>> list =readInputData(file);
		//将companyCode以及operator写入默认参数
		for(Map<String,Object> map:list){
			map.put("groupCode",userInfo.getGroupCode());
			map.put("storeCode", userInfo.getStoreCode());
			map.put("operatorName",userInfo.getName());
			map.put("operatorId",userInfo.getId());
			map.put("operator",userInfo.getId()+":"+userInfo.getName());
		}
		
		//执行导入并发送邮件
		excuteAndSendEmail(list,userInfo.getEmail());
	
	}


	/**
	 * 批量导入文件，每次处理一条不考虑事物一致性
	 * @param file
	 */
	public void importDataForBatch(MultipartFile file,AdminLoginContent userInfo){
		
	}
	
	/**
	 * 检查文件格式 以及文件头
	 */
	protected void checkInputFileType(MultipartFile importFile){
	
		if (importFile==null || importFile.isEmpty()) {
			throw RetailErrorCode.UPLOAD_FILE_FAIL.build();
		}
		String originalFilename = importFile.getOriginalFilename();
		//检查文件格式
		//文件格式检查
		boolean orgCheck=false;
		if(fileType.equals(OriginalType.XLS) || fileType.equals(OriginalType.XLSX)){
			orgCheck =checkOriginalName(originalFilename,OriginalType.XLS);
			if(orgCheck){
				orgCheck = checkOriginalName(originalFilename,OriginalType.XLSX);	
			}
		}else{
			orgCheck =checkOriginalName(originalFilename,fileType);
		}
		
		
		//如果检查失败
		if(orgCheck){
			throw RetailErrorCode.UPLOAD_FILE_FORMAT_ERROR.build();
		}
	}
	
	/**
	 * 校验头部
	 * @param importFile	导入的文件
	 */
	protected List<Map<String,Object>> readInputData(MultipartFile importFile){
		
		//目前仅支持
		if(fileType.equals(OriginalType.XLS)||fileType.equals(OriginalType.XLSX)){
			try {
				
				// 取第一个sheet
				Sheet sheet = getSheet(importFile);
				int rowSum = sheet.getLastRowNum();
				int colSum = sheet.getRow(0).getPhysicalNumberOfCells();
				//检查头部信息
				checkXLSDataHead(sheet,rowSum,colSum);
				//获取内容值
				List<Map<String,Object>> valueList = readXLSData(sheet,rowSum,colSum);
				
				
				return valueList;
	
			} catch (Exception e) {
				throw RetailErrorCode.UPLOAD_FILE_FAIL.build(e);
			}
		}
		return null;
	}
	
	/**
	 * 根据读取的内容执行导入并邮件发送结果
	 * @param valueList	文件内容
	 */
	@SuppressWarnings("unused")
	protected void excuteAndSendEmail(List<Map<String,Object>> valueList,String email){
		if(valueList==null){
			return;
		}
		LOGGER.info("-------- 执行导入操作出现异常 -------- record:{}, email:{}", GSON.toJson(valueList), email);
		//执行结果详情
		Map<String,String> resultMap = new HashMap<String,String>();
		//循环执行导入
		for(Map<String,Object> map :valueList){
			String msg ="成功";
			//通过逗号隔开
			String[] masterIds=this.masterId.split(",");
			String masterContent ="";
			for(String master:masterIds){
				Object masterId = map.get(this.masterId);
				if(masterId ==null){
					throw RetailErrorCode.UPLOAD_FILE_MASTERID_ERROR.build();
				}
				if(masterContent.equals("")){
					masterContent=masterId.toString();
				}
				masterContent+=":"+masterId.toString();
			}
			
			try{
				excuteImport(map);
				
			}catch(Exception ex){
				msg = ex.getMessage();
			}
			//限制备注长度
			if(msg.length()>200){
				msg = msg.substring(0, 200);
			}
			
			resultMap.put(masterContent, msg);	
			
		}
		//生成邮件内容
		String emailContent = gernateEmail(resultMap);
		emailList = new ArrayList<>();
		this.emailList.add(email);
		
		//发送邮件
		//TODO 暂时干掉
		//noticeForEmail(emailTile, emailContent, this.emailList);
	}

	
	/**
	 * 检查XLS的头部数据是否一致
	 * @param sheet		xls sheet对象
	 * @param rowSum	总行数
	 * @param colSum	总列数
	 */
	protected void checkXLSDataHead(Sheet sheet,int rowSum,int colSum){
		// 判断是否存在导入商品
		if (rowSum < 1) {
			throw RetailErrorCode.UPLOAD_FILE_CONTENT_EMPTY.build(
					);
		}
		//文件头部长度不一致
		if(colSum != modeList.size()){
			throw RetailErrorCode.UPLOAD_FILE_HEADSIZE_ERROR.build("!");
		}

		// 设置每个单元格为纯文本格式
		for (int j = 0; j < rowSum; j++) {
		    Row row = sheet.getRow(j);
		    if(row == null) {
		        break;
		    }
			for (int x = 0; x < colSum; x++) {
				Cell cell = row.getCell(x);
				String cellValue = "";
				if (cell != null){
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cellValue=cell.getStringCellValue();
				}
				//如果为第一行解析并校验数据
				if(j==0){
					//对比该列的名称与实际是否一致
					String value = modeList.get(x).getTags();
					if(!value.equals(cellValue)){
						throw RetailErrorCode.UPLOAD_FILE_HEAD_ERROR.build(value, cellValue);
					}
				}
			}
		}
		
	}
	
	/**
	 * 根据执行结果生成邮件
	 * @param map
	 * @return
	 */
	protected String gernateEmail(Map<String,String> map){
		//邮件头部
	  	String firstContent = "<html><body><table border=1><tr><td>数据</td><td>执行结果</td></tr>";
	  	String content ="";
	  	for(String key:map.keySet()){
	  		String tempContent = "<tr><td>"+key+"</td><td>"+map.get(key)+"</td></tr>";
	  		content+=tempContent;
	  	}
	  	
	  	//邮件尾部
    	String lastContent = "</table></body></html>";
    	
    	
    	String emialContent = firstContent +content +lastContent;
		return emialContent;
	}
	
	/**
	 * 检查XLS的头部数据是否一致
	 * @param sheet		xls sheet对象
	 * @param rowSum	总行数
	 * @param colSum	总列数
	 * @return List<Map> 综合数据的集合
	 */
	protected List<Map<String,Object>> readXLSData(Sheet sheet,int rowSum,int colSum){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		for (int j = 1; j <= rowSum; j++) {
		    Row row = sheet.getRow(j);
            if(row == null) {
                break;
            }
			Map<String,Object> map = new HashMap<String,Object>();
			for (int x = 0; x < colSum; x++) {
				Cell cell = row.getCell(x);
				String cellValue = "";
				if (cell != null){
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cellValue=cell.getStringCellValue();
				}
				//获取列对应的key
				String key = modeList.get(x).getKey();
				//转换index 和key的关系
				if(StringUtils.isNotBlank(cellValue)) {
					map.put(key, cellValue.trim());
				}
			}
			if(map.isEmpty()) {
				continue;
			}
			list.add(map);
		}
		return list;
	}
	
	
	/**
	 * 抽象实现类
	 */
	public abstract void excuteImport(Map<String,Object> map);
	
	
	
	/**
	 * 获取XLS sheet数据集
	 * @param importFile 导入的文件流
	 * @return sheet  XLS sheet对象
	 * @throws IOException
	 */
	protected Sheet getSheet(MultipartFile importFile) throws IOException{
		ExcelUtil excelUtil = new ExcelUtil();
		return excelUtil.getSheet(importFile, this.fileType);
	}
	
	
	
	/**
	 * 校验文件格式后缀
	 * @param originalFilename
	 */
	private boolean checkOriginalName(String originalFilename,OriginalType oType){
		String temp[] = originalFilename.split("\\.");
		String suffixStr = temp[1];
		if (!suffixStr.equals(oType.getValue())) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 将map转换成需要导入的对象
	 * @param clazz
	 * @param map
	 * @return 生成之后的对象
	 */
	protected <T> T convertToBean(Class<T> clazz,Map<String,Object> map){
		
		T object=null;
		try {
			object = clazz.newInstance();
			BeanUtils.populate(object, map);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return object;
	}
	
	
	
}
