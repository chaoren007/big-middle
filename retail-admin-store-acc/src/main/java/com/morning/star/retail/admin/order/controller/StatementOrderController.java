package com.morning.star.retail.admin.order.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.base.poi.PoiUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.facade.StatementOrderServiceFacade;
import com.morning.star.retail.order.facade.dto.ExportSellerSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.ExportSellerSummaryVO;
import com.morning.star.retail.order.facade.dto.ExportStatementSummaryDTO;
import com.morning.star.retail.order.facade.dto.ExportStatementSummaryOrderDTO;
import com.morning.star.retail.order.facade.dto.ExportStoreSummaryDTO;
import com.morning.star.retail.order.facade.dto.FinanceSearchDTO;
import com.morning.star.retail.order.facade.dto.SellerOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.SellerSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.SellerSummaryVO;
import com.morning.star.retail.order.facade.dto.StatementOrderDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSettingDTO;
import com.morning.star.retail.order.facade.dto.StatementSummaryInfo;
import com.morning.star.retail.order.facade.dto.StatementSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSummaryVO;
import com.morning.star.retail.order.facade.dto.StatementWaterDTO;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.utils.page.PageBean;

@Controller
@RequestMapping(value = "/api/statement/")
public class StatementOrderController extends AdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StatementOrderController.class);

	@Autowired
	private StatementOrderServiceFacade statementServiceFacade;

	/**
	 * 导出Excel标题
	 */
	private static final String TITLE = "对账明细数据";
	
	private static final String TITLE2 = "运费数据";
	/**
	 * 导出Excel文件全名
	 */
	private static final String FILE_NAME = "对账明细数据.xlsx";
	/**
	 * 导出Excel表头
	 */
	private static final String[] HEADERS = { "支付/退款日期", "订单号", "退款单号","支付方式", "商品名称", "商品编码", "UPC", "一级类别","二级类别","三级类别",
			"规格1","规格2","规格3", "类型","优惠前价格", "优惠后价格", "数量", "优惠前金额", "优惠后金额", "优惠金额", "门店信息","供应商编码","供应商名称", "结算对象" };
    
	private static final String[] HEADERS2 = { "支付日期", "订单号", "支付方式","类型","运费", "门店"};
	
	@RequestMapping(value = "getOrders")
	@ResponseBody
	public WebJsonBean queryStatementOrder(Integer status, Integer pageNo, Integer pageSize) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		if (StringUtils.isBlank(storeCode)) {
			throw new IllegalArgumentException("参数异常");
		}
		StatementOrderSearchDTO search = new StatementOrderSearchDTO();
		search.setStoreCode(storeCode);
		search.setStatus(status);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);
		// LOGGER.info("账期列表查询{}", storeCode);
		PageBean<StatementOrderDTO> orderDTO = statementServiceFacade.queryStatementOrder(search);
		return success(orderDTO);
	}

	@RequestMapping(value = "submitOrder", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean submitOrder(@RequestBody StatementWaterDTO statementWaterDTO) {
		AdminLoginContent login = getLoginAdmin();
		Long operatorId = login.getId();
		String operatorName = login.getName();
		if (operatorId <= 0 || StringUtils.isBlank(operatorName)) {
			throw new IllegalArgumentException("参数异常");
		}
		statementServiceFacade.submitOrder(statementWaterDTO);
		return success();
	}

	@RequestMapping(value = "getSaleOrders", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean queryDealSaleOrder(Date beginTime, Date endTime, Integer pageNo, Integer pageSize) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		if (StringUtils.isBlank(storeCode)) {
			throw new IllegalArgumentException("参数异常");
		}
		Object result = statementServiceFacade.queryDealSaleOrder(storeCode, beginTime, endTime,
				pageNo == null ? 1 : pageNo, pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);
		return success(result);
	}

	@RequestMapping(value = "getStatementWater", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean queryStatementWater(String statementCode) {
		if (StringUtils.isBlank(statementCode)) {
			throw new IllegalArgumentException("参数异常");
		}
		return success(statementServiceFacade.queryStatementWater(statementCode));
	}

	@RequestMapping(value = "getStatementDetail", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean queryStatementDetail(String statementCode) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		if (StringUtils.isBlank(storeCode) || StringUtils.isBlank(statementCode)) {
			throw new IllegalArgumentException("参数异常");
		}
		Object result = statementServiceFacade.queryStatementDetail(storeCode, statementCode);
		return success(result);
	}

	@RequestMapping(value = "generateStatement", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean generateStatementOrder() throws ParseException {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		return success(statementServiceFacade.generateStatementOrder(storeCode));
	}

	@RequestMapping(value = "saveOrUpdateSetting", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean saveOrUpdateSetting(@RequestBody StatementSettingDTO statementSettingDTO) {
		AdminLoginContent login = getLoginAdmin();
		Long operatorId = login.getId();
		String operatorName = login.getName();
		if (operatorId <= 0 || StringUtils.isBlank(operatorName)) {
			throw new IllegalArgumentException("参数异常");
		}
		int result = statementServiceFacade.saveOrUpdateSetting(statementSettingDTO);
		return success(result);
	}

	@RequestMapping(value = "getStatementSetting")
	@ResponseBody
	public WebJsonBean getStatementSetting() {
		//AdminLoginContent login = getLoginAdmin();

		return success(statementServiceFacade.getStatementSetting());
	}

	@RequestMapping(value = "queryDetail", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean queryDetail(@RequestBody StatementOrderSearchDTO search) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);
		//PageBean<StatementOrderVO> result = getDetail(search);

		//TODO 刘越群
		List list1 = new ArrayList();
		PageBean<StatementOrderVO> result = new PageBean<>(1, list1, search.getPageNo(), search.getPageSize(), 1);//statementServiceFacade.queryDetail(search);
		List<StatementOrderVO> list = result.getRecord();
		
		/*for (StatementOrderVO vo : list) {
			vo.setDiscountAmount(BigDecimal.ZERO);
			String goodsSpecInfo = "";
			if(StringUtils.isBlank(vo.getSpecValue2())){
				goodsSpecInfo=vo.getSpecValue1();
			}else if(StringUtils.isBlank(vo.getSpecValue3())){
				goodsSpecInfo=String.format("%s,%s",vo.getSpecValue1(),vo.getSpecValue2());
			}else{
				goodsSpecInfo=String.format("%s,%s,%s",vo.getSpecValue1(),vo.getSpecValue2(),vo.getSpecValue3());
			}
			vo.setGoodsSpecInfo(goodsSpecInfo);
			
			String categoryName = "";
			if (StringUtils.isBlank(vo.getCategoryName1())) {
				categoryName = "";
			} else if (StringUtils.isBlank(vo.getCategoryName2())) {
				categoryName = vo.getCategoryName1();
			} else if (StringUtils.isBlank(vo.getCategoryName3())) {
				categoryName = String.format("%s/%s", vo.getCategoryName1(), vo.getCategoryName2());
			} else {
				categoryName = String.format("%s/%s/%s", vo.getCategoryName1(), vo.getCategoryName2(),
						vo.getCategoryName3());
			}
            
			vo.setCategory(categoryName);
			
		   if(vo.getPayChannel() != null) {
	            vo.setPayChannelDesc(PayChannel.getName(vo.getPayChannel()));
	        }
		}*/
		return success(result);
	}

	
	@RequestMapping(value = "exportStatement")
	public void exportStatement(HttpServletResponse response,StatementOrderSearchDTO search) {
		LOGGER.info("------------ exportStatement ------------ start");
		
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();

		Integer pageSize=Integer.MAX_VALUE;
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(1);
		search.setPageSize(pageSize);
		
		// List<StatementOrderVO> orderList=this.getDetail(search).getRecord();
		PageBean<StatementOrderVO> orders = statementServiceFacade.queryDetail(search);
		Long totalNum=orders.getTotalNum();
		PageBean<StatementOrderVO> deliveryOrders=statementServiceFacade.queryDeliveryFee(search);
		
		LOGGER.info("------------ exportStatement ------------ totalNum:{},deliveryOrders{}", totalNum,deliveryOrders.getTotalNum());
		
	    List<StatementOrderVO> orderList=orders.getRecord();
         
		List<List<Object>> list = this.getExportData(orderList);
		if (CollectionUtils.isEmpty(list)) {
			throw new IllegalArgumentException("结算单不存在");
		}
		List<List<Object>> deliveryList = this.getDeliveryExportData(deliveryOrders.getRecord());
		
		LOGGER.info("------------ exportStatement ------------ rows:{}", orderList.size());
	
		try {
			//PoiUtil.exportExcel(TITLE, HEADERS, list, FILE_NAME, response);
			//明细数据sheet
			Workbook workbook =PoiUtil.createWorkbook(TITLE, HEADERS, list, FILE_NAME);
			//运费数据sheet
			workbook =PoiUtil.createWorkbook(workbook,TITLE2, HEADERS2, deliveryList, FILE_NAME);
			
			PoiUtil.exportExcel(workbook, FILE_NAME, response);
		} catch (Exception e) {
			LOGGER.info("------------ exportStatement ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportStatement ------------ end");

	}

	public List<List<Object>> getExportData(List<StatementOrderVO> orderList) {
		List<List<Object>> list = new ArrayList<List<Object>>();

		for (StatementOrderVO order : orderList) {
			List<Object> rowList = new ArrayList<>();
//			String strPayTime = "";
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			strPayTime = formatter.format(order.getPayTime());
			rowList.add(order.getPayTime()==null?"":DateUtil.toString(order.getPayTime()));
			rowList.add(order.getOrderCode());
			rowList.add(order.getRefundCode());
			rowList.add(order.getPayChannel() == null?"":PayChannel.getName(order.getPayChannel()));
			rowList.add(order.getGoodsName());
			rowList.add(order.getGoodsCode());
			rowList.add(order.getUpc()== null ? "" :order.getUpc());
			rowList.add(order.getCategoryName1()== null ? "" :order.getCategoryName1());
			rowList.add(order.getCategoryName2()== null ? "" :order.getCategoryName2());
			rowList.add(order.getCategoryName3()== null ? "" :order.getCategoryName3());
			rowList.add(order.getSpecValue1()== null ? "" :order.getSpecValue1());
			rowList.add(order.getSpecValue2()== null ? "" :order.getSpecValue2());
			rowList.add(order.getSpecValue3()== null ? "" :order.getSpecValue3());
			rowList.add(order.getType());
			rowList.add(order.getOriginalPrice() == null ? "" : order.getOriginalPrice());
			rowList.add(order.getSalePrice() == null ? "" : order.getSalePrice());
			rowList.add(order.getNum());
			rowList.add(order.getAmount() == null ? "" : order.getAmount());
			rowList.add(order.getRealAmount() == null ? "" : order.getRealAmount());
			rowList.add(order.getDiscountAmount() == null ? "" : order.getDiscountAmount());
			rowList.add(order.getStoreName() == null ? "" : order.getStoreName());
			rowList.add(order.getSupplierCode() == null ? "" : order.getSupplierCode());
			rowList.add(order.getSupplierName() == null ? "" : order.getSupplierName());
			rowList.add(order.getCompanyName());
			
			list.add(rowList);
		}
		return list;
	}

	public List<List<Object>> getDeliveryExportData(List<StatementOrderVO> orderList) {
		List<List<Object>> list = new ArrayList<List<Object>>();

		for (StatementOrderVO order : orderList) {
			List<Object> rowList = new ArrayList<>();

			rowList.add(order.getPayTime()==null?"":DateUtil.toString(order.getPayTime()));
			rowList.add(order.getOrderCode());
			rowList.add(order.getPayChannel() == null?"":PayChannel.getName(order.getPayChannel()));
			rowList.add(order.getType());
			rowList.add(order.getDeliveryFee()== null ? "" : order.getDeliveryFee());
			rowList.add(order.getStoreName() == null ? "" : order.getStoreName());
			
			list.add(rowList);
		}
		return list;
	}


	@RequestMapping(value = "sellerSummary", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean sellerSummary(@RequestBody SellerOrderSearchDTO search) {
		LOGGER.info("------------ sellerSummary ------------ start");
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);

		PageBean<SellerSummaryVO> result = statementServiceFacade.sellerSummary(search);

		return success(result);
	}

	@RequestMapping(value = "sellerOrderList", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean sellerOrderList(@RequestBody SellerOrderSearchDTO search) {
		LOGGER.info("------------ sellerOrderList ------------ start");
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);

		PageBean<SellerSummaryOrderVO> result = statementServiceFacade.sellerOrderList(search);

		return success(result);
	}

	@RequestMapping("exportSellerSummary")
	@ResponseBody
	public WebJsonBean exportSellerSummary(SellerOrderSearchDTO search, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();;
		String storeCode = login.getStoreCode();
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(1);
		search.setPageSize(Integer.MAX_VALUE);
		PageBean<SellerSummaryVO> result = statementServiceFacade.sellerSummary(search);
		LOGGER.info("------------ exportSellerSummary ------------ rows:{}", result.getTotalNum());
		List<SellerSummaryVO> list = result.getRecord();
		List<ExportSellerSummaryVO> summaryList = new ArrayList<>();
		list.stream().forEach(e -> {
			ExportSellerSummaryVO summaryVO = ObjectCopier.copyObject(ExportSellerSummaryVO.class, e);

		//	summaryVO.se(e.getPayTime() == null ? "" : DateUtil.toString(e.getPayTime()));
			summaryList.add(summaryVO);
		});
		LOGGER.info("------------ exportSellerSummary ------------ rows:{}", list.size());

		try {
			new ExcelUtil<>(ExportSellerSummaryVO.class).writeToHttpResponse(summaryList, "促销员结算汇总.xls", "结算汇总", response);
		} catch (Exception e) {
			LOGGER.info("------------ exportSellerSummary ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportSellerSummary ------------ end");
		return success();
	}

	@RequestMapping("exportSellerOrder")
	@ResponseBody
	public WebJsonBean exportSellerOrder(SellerOrderSearchDTO search, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(1);
		search.setPageSize(Integer.MAX_VALUE);
		PageBean<SellerSummaryOrderVO> result = statementServiceFacade.sellerOrderList(search);
		LOGGER.info("------------ exportSellerOrder ------------ rows:{}", result.getTotalNum());
		List<SellerSummaryOrderVO> list = result.getRecord();
		List<ExportSellerSummaryOrderVO> summaryList = new ArrayList<>();
		list.stream().forEach(e -> {
			ExportSellerSummaryOrderVO summaryVO = ObjectCopier.copyObject(ExportSellerSummaryOrderVO.class, e);

			summaryVO.setPayTime(e.getPayTime() == null ? "" : DateUtil.toString(e.getPayTime()));
			summaryList.add(summaryVO);
		});
		LOGGER.info("------------ exportSellerOrder ------------ rows:{}", list.size());

		try {
			new ExcelUtil<>(ExportSellerSummaryOrderVO.class).writeToHttpResponse(summaryList, "促销员订单明细.xls", "订单明细", response);
		} catch (Exception e) {
			LOGGER.info("------------ exportSellerOrder ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportSellerOrder ------------ end");
		return success();
	}

	@RequestMapping(value = "tohomeList", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean orderList(@RequestBody FinanceSearchDTO search) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);

		//TODO 刘越群
		List list = new ArrayList();
		PageBean<StatementSummaryOrderVO> result =
				new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);//statementServiceFacade.orderList(search);
		for(StatementSummaryOrderVO vo:result.getRecord() ){
			vo.setPayChannelDesc(PayChannel.getName(vo.getPayChannel()));
		}
		return success(result);
	}

	@RequestMapping(value = "storeSummary", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean storeSummary(@RequestBody FinanceSearchDTO search) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);

		//TODO 刘越群
		List list = new ArrayList();
		PageBean<StatementSummaryVO> result = new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);//statementServiceFacade.storeSummary(search);
		return success(result);
	}

	@RequestMapping(value = "tradeChannelSummary", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean tradeChannelSummary(@RequestBody FinanceSearchDTO search) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		Integer pageNo = search.getPageNo();
		Integer pageSize = search.getPageSize();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(pageNo == null ? 1 : pageNo);
		search.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);

		//TODO LIUYUEQUN
		Object result = null;//statementServiceFacade.tradeChannelSummary(search);
		return success(result);
	}

	@RequestMapping("exportStatementSummary")
	@ResponseBody
	public WebJsonBean exportStatementSummary(FinanceSearchDTO search, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		StatementSummaryInfo result = statementServiceFacade.tradeChannelSummary(search);
		List<StatementSummaryVO> list = result.getTradeChannelDetail();
		List<ExportStatementSummaryDTO> detailDTOList = new ArrayList<>();
		list.stream().forEach(e -> {
			ExportStatementSummaryDTO detailDTO = ObjectCopier.copyObject(ExportStatementSummaryDTO.class, e);
			detailDTOList.add(detailDTO);
		});
		LOGGER.info("------------ exportStatementSummary ------------ rows:{}", list.size());
		try {
			new ExcelUtil<>(ExportStatementSummaryDTO.class).writeToHttpResponse(detailDTOList, "财务汇总表.xls", "汇总表", response);
		} catch (Exception e) {
			LOGGER.info("------------ exportStatementSummary ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportStatementSummary ------------ end");
		return success();
	}

	@RequestMapping("exportStoreSummary")
	@ResponseBody
	public WebJsonBean exportStoreSummary(FinanceSearchDTO search, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(1);
		search.setPageSize(Integer.MAX_VALUE);
		PageBean<StatementSummaryVO> result = statementServiceFacade.storeSummary(search);
		List<StatementSummaryVO> list = result.getRecord();
		List<ExportStoreSummaryDTO> detailDTOList = new ArrayList<>();
		list.stream().forEach(e -> {
			e.setStoreName(e.getStoreName() + "(" + e.getStoreCode() + ")");
			ExportStoreSummaryDTO detailDTO = ObjectCopier.copyObject(ExportStoreSummaryDTO.class, e);
			detailDTOList.add(detailDTO);
		});
		//LOGGER.info("------------ exportStoreSummary ------------ detailDTOList:{}", GSON.toJson(detailDTOList));
		try {
			new ExcelUtil<>(ExportStoreSummaryDTO.class).writeToHttpResponse(detailDTOList, "门店汇总列表.xls", "门店列表", response);
		} catch (Exception e) {
			LOGGER.info("------------ exportStoreSummary ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportStoreSummary ------------ end");
		return success();
	}

	@RequestMapping("exportToHomeOrder")
	@ResponseBody
	public WebJsonBean exportToHomeOrder(FinanceSearchDTO search, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		String storeCode = login.getStoreCode();
		//添加集团编码 20180309
		search.setGroupCode(login.getGroupCode());
		search.setStoreCode(storeCode);
		search.setPageNo(1);
		search.setPageSize(Integer.MAX_VALUE);
		PageBean<StatementSummaryOrderVO> result = statementServiceFacade.orderList(search);
		LOGGER.info("------------ exportToHomeOrder ------------ rows:{}", result.getTotalNum());
		List<StatementSummaryOrderVO> list = result.getRecord();
		List<ExportStatementSummaryOrderDTO> detailDTOList = new ArrayList<>();
		list.stream().forEach(e -> {
			ExportStatementSummaryOrderDTO detailDTO = ObjectCopier.copyObject(ExportStatementSummaryOrderDTO.class, e);

			if(e.getPayChannel()!=null) {
				detailDTO.setPayChannelDesc(PayChannel.getName(e.getPayChannel()));
			}
			detailDTO.setCreateTime(e.getPayTime() == null ? "" : DateUtil.toString(e.getPayTime()));
			detailDTOList.add(detailDTO);
		});
		LOGGER.info("------------ exportToHomeOrder ------------ rows:{}", list.size());
//		String fileName = "到家订单列表.xls";
//		if (search.getOrderType() == 2) {
//			fileName = "扫码购订单.xls";
//		}
		try {
			new ExcelUtil<>(ExportStatementSummaryOrderDTO.class).writeToHttpResponse(detailDTOList, "订单列表.xls", "订单列表", response);
		} catch (Exception e) {
			LOGGER.info("------------ exportToHomeOrder ------------ Exception：{}", e.toString());
			throw new IllegalArgumentException("导出账期数据错误");
		}
		LOGGER.info("------------ exportToHomeOrder ------------ end");
		return success();
	}


}
