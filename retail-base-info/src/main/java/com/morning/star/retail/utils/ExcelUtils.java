package com.morning.star.retail.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by Administrator on 2017/5/4.
 */
public class ExcelUtils {

    public static List<Map<String, String>>  parseExcel(InputStream stream, int sheetIndex, List< String> names) {
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(stream);
        } catch (IOException e) {

            throw  new IllegalArgumentException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);// 取第一个sheet
        int rowSum = sheet.getLastRowNum();

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for(int i = 1; i <= rowSum; i++) {  // 解析行

            Row row = sheet.getRow(i);

            Map<String, String> map = new HashMap<String, String>();
            for(int j = 0; j < names.size(); j++) {
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);  // 先设置每个单元格为纯文本格式

                String str = row.getCell(j).getStringCellValue();
                if(str != null) {
                    map.put(names.get(j), str.trim());
                }
            }

            result.add(map);
        }

        return result;
    }
}
