package com.morning.star.retail.admin.group.stock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.group.stock.controller.command.QueryReceiptDiffCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.ReceiptDiffFacade;
import com.morning.star.retail.stock.dto.ExportReceiptDiffItemDTO;
import com.morning.star.retail.stock.dto.QueryReceiptDiffDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffItemInfoDTO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by kimhuhg on 2017/11/15.
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
        queryReceiptDiffDTO.setGroupCode(login.getGroupCode());
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
            throw new RuntimeException("导出导出差异单明细",e);
        }
    }
}
