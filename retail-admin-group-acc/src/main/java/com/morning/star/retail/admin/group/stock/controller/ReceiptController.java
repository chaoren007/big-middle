package com.morning.star.retail.admin.group.stock.controller;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.admin.group.helper.StoreService;
import com.morning.star.retail.admin.group.stock.controller.command.*;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.ReceiptFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.util.Json;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.Validate;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "入库单接口")
@Controller
@RequestMapping("/api/receipt")
public class ReceiptController extends AdminController {
    private Logger log = LoggerFactory.getLogger(ReceiptController.class);

    @Autowired
    private ReceiptFacade receiptFacade;
    @Autowired
    private GoodsAdminFacade goodsAdminFacade;

    @Autowired
    private StoreService storeService;

    @RequiresPermissions(value = "receipt:list")
    @ApiOperation(value = "入库列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<ReceiptDTO>> list(ReceiptQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(receiptFacade.list(queryDTO));
    }

    @RequiresPermissions(value = "receipt:get")
    @ApiOperation(value = "入库单详情")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<ReceiptDTO> get(@ApiParam(value = "入库单号", required = true) @RequestParam String receiptCode) {
        Validate.notNull(receiptCode, "入库单号不能为空");
        ReceiptQueryDTO queryDTO = new ReceiptQueryDTO();
        queryDTO.setReceiptCode(receiptCode);
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        ReceiptDTO receiptInfoDTO = receiptFacade.get(queryDTO);
        return WebBean.ok(receiptInfoDTO);
    }

    @RequiresPermissions(value = "receipt:export")
    @ApiOperation(value = "入库详情导出（封存）")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<Void> exportReceiptDetail(@ApiParam(value = "入库单号", required = true) @RequestParam String receiptCode, HttpServletResponse response) {
        Validate.isTrue(receiptCode != null, "入库单号不能为空");
        List<ReceiptItemDTO> details = receiptFacade.queryDetail(receiptCode);
        List<ReceiptItemExportDTO> list = new ArrayList<>();
        for (ReceiptItemDTO detail : details) {
            ReceiptItemExportDTO receiptItemExportDTO = new ReceiptItemExportDTO();
            BeanUtils.copy(detail, receiptItemExportDTO);
            list.add(receiptItemExportDTO);
        }
        try {
            new ExcelUtil<>(ReceiptItemExportDTO.class).writeToHttpResponse(list, "导出入库列表(集团端)【" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "】.xlsx", "入库列表", response);
        } catch (Exception e) {
            throw new RuntimeException("导出入库列表错误", e);
        }
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:query-expired-goods")
    @ApiOperation(value = "过期商品列表（封存）")
    @RequestMapping(value = "/query-expired-goods", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<ExpiredGoodsDTO>> queryExpiredGoods(ExpiredGoodsQueryDTO queryDTO) {
        AdminLoginContent login = getLoginAdmin();
        queryDTO.setGroupCode(login.getGroupCode());
        return WebBean.ok(receiptFacade.queryExpiredGoods(queryDTO));
    }

    @RequiresPermissions(value = "receipt:export-expired-goods")
    @ApiOperation(value = "过期商品导出（封存）")
    @RequestMapping(value = "/export-expired-goods", method = RequestMethod.GET)
    public void exportExpiredGoods(ExpiredGoodsQueryDTO queryDTO, HttpServletResponse response) {
        AdminLoginContent login = getLoginAdmin();
        queryDTO.setGroupCode(login.getGroupCode());
        queryDTO.setPageSize(queryDTO.getPageSize() == null ? Integer.MAX_VALUE : queryDTO.getPageSize());
        queryDTO.setPageNo(queryDTO.getPageNo() == null ? 1 : queryDTO.getPageNo());
        PageBean<ExpiredGoodsDTO> page = receiptFacade.queryExpiredGoods(queryDTO);
        List<ExpiredGoodsDTO> records = page.getRecord();
        List<ExportExpiredGoodsDTO> dataList = new ArrayList<>();
        for (ExpiredGoodsDTO record : records) {
            ExportExpiredGoodsDTO exportExpiredGoodsDTO = new ExportExpiredGoodsDTO();
            BeanUtils.copy(record, exportExpiredGoodsDTO);
            dataList.add(exportExpiredGoodsDTO);
        }
        try {
            new ExcelUtil<>(ExportExpiredGoodsDTO.class).writeToHttpResponse(dataList, "导出过期货品【" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "】.xlsx", "过期货品", response);
        } catch (Exception e) {
            throw new RuntimeException("导出过期货品错误", e);
        }
    }

    @RequiresPermissions(value = "receipt:import")
    @ApiOperation(value = "手动产生入库单导入（封存）")
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> importGoods(MultipartFile importFile) {
        List<ReceiptImportCommand> imports = new ExcelUtil<>(ReceiptImportCommand.class).readXLSData(importFile, null);
        //按组号将数据分类这里成map集合,一个key集代表一个入库单
        ReceiptImportCommand receiptImportCommand;
        Map<String, List<ReceiptImportCommand>> resultMap = new HashMap<>(); // 最终要的结果
        for (int i = 0; i < imports.size(); i++) {
            receiptImportCommand = imports.get(i);
            Validate.notEmpty(receiptImportCommand.getGroupNum(), String.format("第%d行导入的入库组号不能为空", i + 1));
            if (resultMap.containsKey(receiptImportCommand.getGroupNum())) {
                resultMap.get(receiptImportCommand.getGroupNum()).add(receiptImportCommand);
            } else {
                List<ReceiptImportCommand> list = new ArrayList<>();
                list.add(receiptImportCommand);
                resultMap.put(receiptImportCommand.getGroupNum(), list);
            }
        }
        ArrayList<ReceiptAddDTO> receiptAddDTOS = new ArrayList<>();
        //遍历map集合存进数据库
        for (Map.Entry<String, List<ReceiptImportCommand>> entry : resultMap.entrySet()) {
            List<ReceiptImportCommand> importCommands = entry.getValue();
            ArrayList<ReceiptItemAddDTO> receiptItemAddDTOList = new ArrayList<>();
            //收集主表信息
            ReceiptAddDTO receiptAddDTO = getReceipt(importCommands);
            for (ReceiptImportCommand importCommand : importCommands) {
                //收集入库细表
                ReceiptItemAddDTO receiptItemAddDTO = getReceiptItem(importCommand);
                receiptItemAddDTOList.add(receiptItemAddDTO);
            }
            receiptAddDTO.setItems(receiptItemAddDTOList);
            receiptAddDTOS.add(receiptAddDTO);
        }
        receiptFacade.batchSaveReceipt(receiptAddDTOS);
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:add-outstock-code")
    @ApiOperation(value = "填写第三方出库单号")
    @RequestMapping(value = "/add-outstock-code", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> addOutStockCode(@RequestBody AddOutstockCodeCommand addOutstockCodeCommand) {
        receiptFacade.addOutStockCode(addOutstockCodeCommand.getReceiptCode(), addOutstockCodeCommand.getOutstockCode());
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:add-expected-time")
    @ApiOperation(value = "填写预计入库时间（封存）")
    @RequestMapping(value = "/add-expected-time", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> addExpectedReceiptTime(@RequestBody ExpectedReceiptTimeCommand expectedReceiptTimeCommand) {
        receiptFacade.addExpectedReceiptTime(expectedReceiptTimeCommand.getReceiptCode(), expectedReceiptTimeCommand.getExpectedReceiptTime());
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:sure-receipt")
    @ApiOperation(value = "确认入库（封存）")
    @RequestMapping(value = "/sure-receipt", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> sureReceipt(@RequestBody SureReceiptCommand sureReceiptCommand) {
        log.info("接收确认入库数据：" + Json.toJson(sureReceiptCommand));
        Map<String, List<ReceiptImeiDTO>> resultMap = new HashMap<>(); // 最终要的结果
        List<ReceiptImeiDTO> imports = sureReceiptCommand.getImeis();
        if (imports != null && imports.size() > 0) {
            //按货品编码将数据分类这里成map集合,一个key集代表一个入库单
            ReceiptImeiDTO receiptImeiDTO;
            for (int i = 0; i < imports.size(); i++) {
                receiptImeiDTO = imports.get(i);
                if (resultMap.containsKey(receiptImeiDTO.getGoodsCode())) {
                    resultMap.get(receiptImeiDTO.getGoodsCode()).add(receiptImeiDTO);
                } else {
                    List<ReceiptImeiDTO> list = new ArrayList<>();
                    list.add(receiptImeiDTO);
                    resultMap.put(receiptImeiDTO.getGoodsCode(), list);
                }
            }
        }
        SureReceiptDTO sureReceiptDTO = new SureReceiptDTO();
        BeanUtils.copy(sureReceiptCommand, sureReceiptDTO);
        log.info("转化后确认入库iemi数据：" + Json.toJson(resultMap));
        receiptFacade.sureReceipt(sureReceiptDTO, resultMap);
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:sure-receipt")
    @ApiOperation(value = "确认入库的串码导入")
    @RequestMapping(value = "/get-iemi-info", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<List<ReceiptImeiDTO>> getIemiInfo(MultipartFile importFile) {
        Validate.isTrue(importFile != null, "上传导入串码不能为空");
        List<ReceiptImeiDTO> imports = new ExcelUtil<>(ReceiptImeiDTO.class).readXLSData(importFile, null);
        return WebBean.ok(imports);
    }

    @RequiresPermissions(value = "receipt:confirm-delivery")
    @ApiOperation(value = "确认发货（封存）")
    @RequestMapping(value = "/confirm-delivery", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> confirmDelivery(@RequestBody ConfirmDeliveryCommand receiptCode) {
        receiptFacade.modifyTransStatus(receiptCode.getReceiptCode(), 10);
        return WebBean.ok();
    }

    @RequiresPermissions(value = "receipt:confirm-arrival")
    @ApiOperation(value = "确认到货（封存）")
    @RequestMapping(value = "/confirm-arrival", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> confirmArrival(@RequestBody ReceiptConfirmArrivalCommand receiptCode) {
        receiptFacade.modifyTransStatus(receiptCode.getReceiptCode(), 20);
        return WebBean.ok();
    }

    /**
     * 收集入库主表信息
     *
     * @param itemDTOs
     * @return
     */
    private ReceiptAddDTO getReceipt(List<ReceiptImportCommand> itemDTOs) {
        ReceiptImportCommand itemDTO = itemDTOs.get(0);
        ReceiptAddDTO receiptAddDTO = new ReceiptAddDTO();
        AdminLoginContent login = getLoginAdmin();
        //收集入库主表信息
        receiptAddDTO.setRemark(itemDTO.getRemark());
//        receiptAddDTO.setGroupCode(login.getGroupCode());
//        receiptAddDTO.setGroupName(login.getGroupName());
//        receiptAddDTO.setBusinessCode(login.getBusinessCode());
//        receiptAddDTO.setBusinessName(login.getBusinessName());
//        receiptAddDTO.setVcontainerCode(login.getVcontainerCode());
//        receiptAddDTO.setVcontainerName(login.getVcontainerName());

        StoreDTO store = storeService.getStore(itemDTO.getStoreCode());
        Validate.isTrue(store != null, "该门店不存在");
        Validate.isTrue(store.getGroupCode().equals(login.getGroupCode()), "该门店不属于当前集团");
//        receiptAddDTO.setStoreCode(store.getStoreCode());
//        receiptAddDTO.setStoreName(itemDTO.getStoreName());
//        receiptAddDTO.setSupplierName(itemDTO.getSupplierName());
        receiptAddDTO.setSupplierCode(itemDTO.getSupplierCode());
        //判断入库类型
        if (itemDTO.getReceiptType().equals("采购")) {
            receiptAddDTO.setReceiptType(0);
        } else if (itemDTO.getReceiptType().equals("调拨")) {
            receiptAddDTO.setReceiptType(10);
        } else {
            receiptAddDTO.setReceiptType(30);
        }
//        receiptAddDTO.setReceiptTypeCode(itemDTO.getReceiptTypeCode());
        //计算总额
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);
        for (ReceiptImportCommand dto : itemDTOs) {
            Validate.isTrue(dto.getAmount() != null, "入库金额不能为空");
            amount = amount.add(new BigDecimal(dto.getAmount()));
        }
//        receiptAddDTO.setAmount(amount);
        return receiptAddDTO;
    }

    /**
     * 收集入库细表信息
     *
     * @param itemDTO
     * @return
     */
    private ReceiptItemAddDTO getReceiptItem(ReceiptImportCommand itemDTO) {
        //收集入库细表
        ReceiptItemAddDTO receiptItemAddDTO = new ReceiptItemAddDTO();
        GoodsDTO goods = goodsAdminFacade.getGoods(itemDTO.getGoodsCode());
        Validate.isTrue(goods != null, "未获取到商品信息,请检查商品编码是否正确");
//        receiptItemAddDTO.setAmount(new BigDecimal(itemDTO.getAmount()));
//        receiptItemAddDTO.setPrice(new BigDecimal(itemDTO.getPrice()));
//        receiptItemAddDTO.setGoodsCode(goods.getGoodsCode());
//        receiptItemAddDTO.setQty(new BigDecimal(itemDTO.getQty()));
//        receiptItemAddDTO.setRemark(itemDTO.getRemark());
//        receiptItemAddDTO.setReceiptUnits(itemDTO.getReceiptUnits());
        return receiptItemAddDTO;
    }


    @ApiOperation(value = "采购入库单")
    @RequestMapping(value = "/purchaseReceipt", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Boolean> purchaseReceipt(@RequestBody WMSReceiptAddDTO dto) {
        log.info("start ------------------ purchaseReceipt ------------------ dto:{}", JSON.toJSON(dto));
        ReceiptAddDTO receipt = new ReceiptAddDTO();
        receipt.setReceiptCode(dto.getCode());
        receipt.setTrackCode(dto.getTcode());
        receipt.setSupplierCode(dto.getScode());
        receipt.setWarehouseCode(dto.getWcode());
        receipt.setRemark(dto.getDesc());

        List<ReceiptItemAddDTO> receiptItems = new ArrayList<>();
        for (WMSReceiptAddItemDTO itemDTO : dto.getDetail()) {
            ReceiptItemAddDTO receiptItem = new ReceiptItemAddDTO();
            receiptItem.setProductCode(itemDTO.getPcode());
            receiptItem.setNum(itemDTO.getCount());
            receiptItem.setProductionDate(itemDTO.getPdate());
            receiptItems.add(receiptItem);
        }
        receipt.setItems(receiptItems);

        log.info("end ------------------ purchaseReceipt ------------------ ");
        return WebBean.ok(receiptFacade.purchaseReceipt(receipt));
    }

//    @ApiOperation(value = "出库信息回写")
//    @RequestMapping(value = "/outStock", method = RequestMethod.POST)
//    @com.morning.star.retail.validate.Validate
//    @ResponseBody
//    public WebBean outStock(@RequestBody OutStockWmsPullDTO dto) {
//        return WebBean.ok();
//    }
}
