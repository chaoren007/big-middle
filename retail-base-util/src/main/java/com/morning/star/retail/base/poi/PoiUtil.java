package com.morning.star.retail.base.poi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * POI导入导出EXCEL文档
 * 
 * @author jiangyf
 */
public class PoiUtil {

	/**
	 * 表格默认列宽度
	 */
	private static final int DEFAULT_COLUMN_WIDTH = 20;
	/**
	 * 内存中保留 n 条数据，以免内存溢出，其余写入硬盘
	 */
	private static final int ROW_ACCESS_WINDOW_SIZE = 1000;

	/**
	 * 根据传进来的文件后缀名创建不同版本的Excel Workbook
	 * 
	 * @param title
	 *            标题
	 * @param headers
	 *            表头
	 * @param list
	 *            数据集
	 */
	public static Workbook createWorkbook(String title, String[] headers, List<List<Object>> list,
			String fileName) {
		// 判断是03之前还是03之后的版本创建不同的工作簿
		Workbook workbook = null;
		if (fileName.endsWith(".xls")) {
			workbook = new HSSFWorkbook();
		} else if (fileName.endsWith(".xlsx")) {
			workbook = new SXSSFWorkbook(ROW_ACCESS_WINDOW_SIZE);
		}

		// 创建一个sheet页
		Sheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度
		sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);

		// 标题行样式
		// CellStyle titleStyle = generateTitleStyle(workbook);
		// 数据行样式
		// CellStyle dataStyle = generateDataStyle(workbook);
		// 创建标题行
		Row row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			// 创建单元格把表头写进去
			Cell cell = row.createCell(i);
			// cell.setCellStyle(titleStyle);
			cell.setCellValue(headers[i]);
		}

		// 填充数据
		tc(list,sheet);
		return workbook;
	}

	private static void tc(List<List<Object>> list, Sheet sheet) {
		for (int i = 0; i < list.size(); i++) {
			// 有多少数据生成多少行
			Row nextRow = sheet.createRow(i + 1);
			List<Object> rowsList = list.get(i);
			// 写入数据
			for (int j = 0; j < rowsList.size(); j++) {
				Cell cell = nextRow.createCell(j);
				// 设置数据行样式
				// cell.setCellStyle(dataStyle);
				cell.setCellValue(rowsList.get(j) == null ? "" : String.valueOf(rowsList.get(j)));
			}
		}
	}


	/**
	 * 根据传进来的文件后缀名创建不同版本的Excel Workbook
	 * 
	 * @param title
	 *            标题
	 * @param headers
	 *            表头
	 * @param list
	 *            数据集
	 */
	public static Workbook createWorkbook(Workbook workbook1,String title, String[] headers, List<List<Object>> list,
			String fileName) {
		// 判断是03之前还是03之后的版本创建不同的工作簿
		Workbook workbook = null;
		if(workbook1!=null)
			workbook=workbook1;
		else{
		if (fileName.endsWith(".xls")) {
			workbook = new HSSFWorkbook();
		} else if (fileName.endsWith(".xlsx")) {
			workbook = new SXSSFWorkbook(ROW_ACCESS_WINDOW_SIZE);
		}
		}

		// 创建一个sheet页
		Sheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度
		sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);
		//sheet.autoSizeColumn(1,true);
		// 标题行样式
		// CellStyle titleStyle = generateTitleStyle(workbook);
		// 数据行样式
		// CellStyle dataStyle = generateDataStyle(workbook);
		// 创建标题行
		Row row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			// 创建单元格把表头写进去
			Cell cell = row.createCell(i);
			// cell.setCellStyle(titleStyle);
			cell.setCellValue(headers[i]);
		}

		// 填充数据
		tc(list, sheet);
		return workbook;
	}

	/**
	 * 生成并设置标题行样式
	 * 
	 * @param workbook
	 * @return
	 *//*
	@SuppressWarnings("unused")
	private static CellStyle generateTitleStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(HSSFColor.SKY_BLUE.index); // 填充的背景颜色
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 填充图案
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置边框样式
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 顶边框
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setFont(generateTitleFont(workbook));// 字体样式
		return style;
	}*/

	/**
	 * 生成并设置数据行样式
	 * 
	 * @param workbook
	 * @return
	 */
	@SuppressWarnings("unused")
	/*private static CellStyle generateDataStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFont(generateDataFont(workbook));
		return style;
	}*/

	/**
	 * 生成并设置标题行字体
	 * 
	 * @param workbook
	 * @return
	 */
	/*private static Font generateTitleFont(Workbook workbook) {
		Font font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);// 字体颜色
		font.setFontHeightInPoints((short) 12);// 字号
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
		return font;
	}*/

	/**
	 * 生成并设置数据行字体
	 * 
	 * @param workbook
	 * @return
	 */
	private static Font generateDataFont(Workbook workbook) {
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		return font;
	}

	/**
	 * 生成本地文件
	 * 
	 * @param title
	 *            标题
	 * @param headers
	 *            表头
	 * @param list
	 *            数据集
	 * @param fileName
	 *            文件名
	 * @param path
	 *            文件保存地址
	 */
	public static void createLocalExcel(String title, String[] headers, List<List<Object>> list,
			String fileName, String path) {
		File file = new File(path + fileName);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			createWorkbook(title, headers, list, fileName).write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 创建工作簿，输出文件流
	 * 
	 * @param fileName
	 *            文件名
	 * @param title
	 *            主标题
	 * @param headers
	 *            表头
	 * @param list
	 *            数据集
	 * @return
	 * @throws IOException
	 */
	public static InputStream createWorkbook(String fileName, String title, String[] headers,
			List<List<Object>> list) throws IOException {
		Workbook workbook = createWorkbook(title, headers, list, fileName);
		// 以流形式下载文件
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// 把创建好的workbook以字节流的形式写进缓冲中
		workbook.write(os);
		// 读取os字节数组
		return new ByteArrayInputStream(os.toByteArray());
	}

	/**
	 * 以流形式下载Excel文件
	 * 
	 * @param is
	 *            工作簿文件流
	 * @param fileName
	 *            文件名
	 * @param response
	 *            响应对象
	 * @throws Exception
	 */
	public static void exportExcel(InputStream is, String fileName, HttpServletResponse response)
			throws Exception {
		// 设置response弹出下载框
		// 清空response
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes(), "iso-8859-1"));
		OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
		BufferedInputStream bis = new BufferedInputStream(is);
		// 获取缓冲数据
		byte[] buffer = new byte[bis.available()];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buffer, 0, buffer.length))) {
			toClient.write(buffer, 0, bytesRead);
		}
		toClient.flush();
		bis.close();
		toClient.close();
	}

	public static void exportExcel(Workbook workbook, String fileName, HttpServletResponse response)
			throws Exception {
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.writeToHttpResponse(workbook, fileName, response);
		/*// 以流形式下载文件
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		// 把创建好的workbook以字节流的形式写进缓冲中
		workbook.write(os);
		// 读取os字节数组
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		// 设置response弹出下载框
		// 清空response
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;fileName=" + new String(fileName.getBytes(), "iso-8859-1"));
		OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
		BufferedInputStream bis = new BufferedInputStream(is);
		// 获取缓冲数据
		byte[] buffer = new byte[bis.available()];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buffer, 0, buffer.length))) {
			toClient.write(buffer, 0, bytesRead);
		}
		toClient.flush();
		bis.close();
		toClient.close();*/
	}

	/**
	 * 以流形式下载Excel文件
	 * 
	 * @param title
	 *            标题
	 * @param headers
	 *            表头
	 * @param list
	 *            数据集
	 * @param fileName
	 *            文件名
	 * @param response
	 *            响应
	 * @throws Exception
	 */
	public static void exportExcel(String title, String[] headers, List<List<Object>> list, String fileName,
			HttpServletResponse response) throws Exception {
		// 创建workbook
		Workbook workbook = createWorkbook(title, headers, list, fileName);
		// 导出文件
		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.writeToHttpResponse(workbook, fileName, response);
	}

}