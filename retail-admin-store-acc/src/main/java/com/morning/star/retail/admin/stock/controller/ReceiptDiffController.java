package com.morning.star.retail.admin.stock.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.stock.controller.command.ExportReceiptDiffCommand;
import com.morning.star.retail.admin.stock.controller.command.ModifyReceiptDiffCommand;
import com.morning.star.retail.admin.stock.controller.command.QueryReceiptDiffCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.ReceiptDiffFacade;
import com.morning.star.retail.stock.dto.ExportReceiptDiffItemDTO;
import com.morning.star.retail.stock.dto.ModifyReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ModifyReceiptDiffItemDTO;
import com.morning.star.retail.stock.dto.QueryReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffItemInfoDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by kimhuhg on 2018/08/17.
 */
@Api(tags = "入库差异单")
@Controller
@RequestMapping("/api/receipt-diff/")
public class ReceiptDiffController extends AdminController {

    @Autowired
    private ReceiptDiffFacade receiptDiffFacade;

    @RequiresPermissions(value = "receipt-diff:query")
    @ApiOperation(value = "入库差异单分页列表")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<ReceiptDiffInfoDTO>> query(QueryReceiptDiffCommand search) {
        AdminLoginContent login = getLoginAdmin();
        QueryReceiptDiffDTO queryReceiptDiffDTO = new QueryReceiptDiffDTO();
        BeanUtils.copy(search, queryReceiptDiffDTO);
        queryReceiptDiffDTO.setStoreCode(login.getStoreCode());
        PageBean<ReceiptDiffInfoDTO> result = receiptDiffFacade.query(queryReceiptDiffDTO);
        return WebBean.ok(result);
    }

    @RequiresPermissions(value = "receipt-diff:get-by-code")
    @ApiOperation(value = "根据主表编码查询")
    @RequestMapping(value = "get-by-code", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<ReceiptDiffInfoDTO> query(String receiptDiffCode) {
        return WebBean.ok(receiptDiffFacade.list(receiptDiffCode));
    }

    @RequiresPermissions(value = "receipt-diff:write-diff-item")
    @ApiOperation(value = "填写差异单")
    @RequestMapping(value = "write-diff-item", method = RequestMethod.POST)
    @ResponseBody
    @Validate
    public WebBean<Void> writeDiffItem(@RequestBody ModifyReceiptDiffCommand modifyReceiptDiffCommand) {
        ModifyReceiptDiffDTO modifyReceiptDiffDTO = new ModifyReceiptDiffDTO();
        BeanUtils.copy(modifyReceiptDiffCommand, modifyReceiptDiffDTO);
        receiptDiffFacade.writeDiffItem(modifyReceiptDiffDTO);
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt-diff:export-detail")
    @ApiOperation(value = "差异单明细导出")
    @RequestMapping(value = "export-detail", method = RequestMethod.GET)
    public void exportDetail(String receiptDiffCode, HttpServletResponse response) {
        ReceiptDiffInfoDTO list = receiptDiffFacade.list(receiptDiffCode);
        List<ReceiptDiffItemInfoDTO> item = list.getItem();
        ArrayList<ExportReceiptDiffItemDTO> export = new ArrayList<>();
        for (ReceiptDiffItemInfoDTO receiptDiffItemInfoDTO : item) {
            ExportReceiptDiffItemDTO exportReceiptDiffItemDTO = new ExportReceiptDiffItemDTO();
            BeanUtils.copy(receiptDiffItemInfoDTO,exportReceiptDiffItemDTO);
            export.add(exportReceiptDiffItemDTO);
        }
        try {
            new ExcelUtil<>(ExportReceiptDiffItemDTO.class).writeToHttpResponse(export, "导出差异单明细【"+
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"】.xlsx", "明细", response);
        } catch (Exception e) {
            throw new RuntimeException("导出差异单明细",e);
        }
    }

    @RequiresPermissions(value = "receipt-diff:import")
    @ApiOperation(value = "导入差异单")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> importReceiptDiff(MultipartFile importFile) {
        List<ExportReceiptDiffCommand> imports = new ExcelUtil<>(ExportReceiptDiffCommand.class).readXLSData(importFile, null);
        //按入库差异单编码将数据分类这里成map集合,一个key集代表一个入库单
        ExportReceiptDiffCommand exportReceiptDiffCommand;
        Map<String, List<ExportReceiptDiffCommand>> resultMap= new HashMap<>(); // 最终要的结果
        for(int i=0;i<imports.size();i++){
            exportReceiptDiffCommand = imports.get(i);
            if(resultMap.containsKey(exportReceiptDiffCommand.getReceiptDifferenceCode())){
                resultMap.get(exportReceiptDiffCommand.getReceiptDifferenceCode()).add(exportReceiptDiffCommand);
            }else{
                List<ExportReceiptDiffCommand> list = new ArrayList<>();
                list.add(exportReceiptDiffCommand);
                resultMap.put(exportReceiptDiffCommand.getReceiptDifferenceCode(),list);
            }
        }

        ArrayList<ModifyReceiptDiffDTO> dtos = new ArrayList<>();
        for (String key : resultMap.keySet()) {
            ModifyReceiptDiffDTO dto = new ModifyReceiptDiffDTO();
            ArrayList<ModifyReceiptDiffItemDTO> itemDTOS = new ArrayList<>();
            for (ExportReceiptDiffCommand li : resultMap.get(key)) {
                ModifyReceiptDiffItemDTO itemDTO = new ModifyReceiptDiffItemDTO();
                BeanUtils.copy(li, itemDTO);
                //个别属性类型转换
                itemDTO.setDifferenceQty(new BigDecimal(li.getDifferenceQty()));
                itemDTOS.add(itemDTO);
            }
            dto.setItem(itemDTOS);
            dto.setReceiptDiffCode(key);
            dtos.add(dto);
        }
        receiptDiffFacade.batchWriteDiffItem(dtos);
        return WebBean.ok();
    }
}
