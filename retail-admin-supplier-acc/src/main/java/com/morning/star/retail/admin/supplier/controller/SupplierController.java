package com.morning.star.retail.admin.supplier.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.sms.CaptchaDTO;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.enums.SupGoodsTypeEnum;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.SupplierGoodsFacade;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 供应商管理
 *
 * @author jiangyf
 */
@Api(tags = "供应商")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController extends AdminController {
    private Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierFacade facade;

    @Autowired
    private SupplierGoodsFacade supplierGoodsFacade;

    @ApiOperation(value = "供应商申请-获取验证码")
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public WebBean captcha(@RequestParam(required = true) String mobile) {
        LOGGER.info("start ---------------- 发送验证码 ----------------");
        facade.captcha(mobile);
        LOGGER.info("end ---------------- 发送验证码 ----------------");
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商申请-校验验证码")
    @RequestMapping(value = "/checkCaptcha", method = RequestMethod.POST)
    @Validate
    public WebBean<SupplierApplyDTO> checkCaptcha(@RequestBody CaptchaDTO dto) {
        return WebBean.ok(facade.checkCaptcha(dto));
    }

    @ApiOperation(value = "供应商申请-提交申请")
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @Validate
    public WebBean submit(@RequestBody SupplierSubmitDTO dto) {
        facade.submit(dto);
        return WebBean.ok();
    }


    @ApiOperation(value = "运营端供货列表")
    @RequestMapping(value = "/bus-supply-list", method = RequestMethod.GET)
    public WebBean<PageBean<BusSupplyGoodsDTO>> getSupplyGoods(BusSupplyGoodsQueryDTO queryDTO) {
        org.apache.commons.lang3.Validate.notNull(queryDTO.getPageNo(), "分页参数不能为空");
        org.apache.commons.lang.Validate.notNull(queryDTO.getPageSize(), "分页参数不能为空");
        String supplierCode = getLoginAdmin().getSupplierCode();
        queryDTO.setSupplierCode(supplierCode);
        PageBean<BusSupplyGoodsDTO> supplyGoods = supplierGoodsFacade.getSupplyGoods(queryDTO);
        return WebBean.ok(supplyGoods);
    }

    @ApiOperation(value = "确认发货")
    @RequestMapping(value = "/bus-comfire", method = RequestMethod.POST)
    public WebBean<Void> comfire(@RequestBody BusSupplyConfireDTO dto) {
        org.apache.commons.lang.Validate.notNull(SupGoodsTypeEnum.getEnum(dto.getType()));
        org.apache.commons.lang.Validate.notNull(dto.getCarrier(), "承运人不能为空");
        org.apache.commons.lang.Validate.notNull(dto.getCarrierTel(), "承运人联系方式不能为空");
        org.apache.commons.lang.Validate.notNull(dto.getCarrierTel(), "承运人联系方式不能为空");

        org.apache.commons.lang.Validate.notNull(dto.getLogisticsCode(), "到货仓库不能为空");
        org.apache.commons.lang.Validate.notNull(dto.getStartTime(), "发货时间不能为空");
        org.apache.commons.lang.Validate.notNull(dto.getEndTime(), "到货时间不能为空");
        org.apache.commons.lang.Validate.notNull(dto.getSupplyCodes(), "供货单号不能为空");
        if (dto.getType().intValue() == SupGoodsTypeEnum.LOGISTICS.getCode().intValue()) {
            org.apache.commons.lang.Validate.notNull(dto.getLogisticsCode(), "物流单号不能为空");
            org.apache.commons.lang.Validate.notNull(dto.getLogisticsName(), "物流公司不能为空");
        }
        if (dto.getType().intValue() == SupGoodsTypeEnum.AUTONOMOUS.getCode().intValue()) {
            org.apache.commons.lang.Validate.notNull(dto.getAddress(), "发货地址不能为空");
        }
        dto.setSupplierCode(getLoginAdmin().getSupplierCode());

        supplierGoodsFacade.comfire(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "根据供货编码获取仓库列表")
    @RequestMapping(value = "/bus-depots-list", method = RequestMethod.GET)
    public WebBean<List<String>> listDepots(String dto) {
        final String[] split = dto.split(",");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        List<String> result = supplierGoodsFacade.listDepots(list);
        return WebBean.ok(result);
    }

    @ApiOperation(value = "运营端送货单列表")
    @RequestMapping(value = "/bus-ship-list", method = RequestMethod.GET)
    public WebBean<PageBean<BusShipGoodsDTO>> getSupplyGoods(BusShipGoodsQueryDTO queryDTO) {
        org.apache.commons.lang3.Validate.notNull(queryDTO.getPageNo(), "分页参数不能为空");
        org.apache.commons.lang.Validate.notNull(queryDTO.getPageSize(), "分页参数不能为空");
        queryDTO.setSupplierCode(getLoginAdmin().getSupplierCode());
        PageBean<BusShipGoodsDTO> supplyGoods = supplierGoodsFacade.getShipGoods(queryDTO);
        return WebBean.ok(supplyGoods);
    }

    @ApiOperation(value = "运营端发货单详情")
    @RequestMapping(value = "/bus-supply-detail", method = RequestMethod.GET)
    public WebBean<BusSupplyGoodsDetailDTO> getSupplyGoodsDetail(String supplyCode) {
        BusSupplyGoodsDetailDTO dto = supplierGoodsFacade.getSupplyGoodsDetail(supplyCode);
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "运营端送货单详情")
    @RequestMapping(value = "/bus-ship-detail", method = RequestMethod.GET)
    public WebBean<BusShipGoodsDetailDTO> getShipGoodsDetail(String shipCode) {
        BusShipGoodsDetailDTO dto = supplierGoodsFacade.getShipGoodsDetail(shipCode);
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "统计各状态发货商品数")
    @RequestMapping(value = "/bus-supply-statistics", method = RequestMethod.GET)
    public WebBean<List<BusSupplyGoodsNumDTO>> getsupplyStatistics() {
        List<BusSupplyGoodsNumDTO> dto = supplierGoodsFacade.getsupplyStatistics(getLoginAdmin().getSupplierCode());
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "账单明细")
    @RequestMapping(value = "/amount_detail", method = RequestMethod.GET)
    public WebBean<PageBean<BusSupplyGoodsDTO>> getAmountDetail(BusSupplyGoodsQueryDTO queryDTO) {
        org.apache.commons.lang3.Validate.notNull(queryDTO.getPageNo(),"分页参数不能为空");
        org.apache.commons.lang.Validate.notNull(queryDTO.getPageSize(),"分页参数不能为空");
        queryDTO.setSupplierCode(getLoginAdmin().getSupplierCode());
        //展示生成的账单
        queryDTO.setBill(1);
        PageBean<BusSupplyGoodsDTO> supplyGoods = supplierGoodsFacade.getSupplyGoods(queryDTO);
        return WebBean.ok(supplyGoods);
    }

    @ApiOperation(value = "余额")
    @RequestMapping(value = "/rest_money", method = RequestMethod.GET)
    public WebBean<BigDecimal> getRestMoney() {
        BusSupplyGoodsQueryDTO queryDTO = new BusSupplyGoodsQueryDTO();
        queryDTO.setSupplierCode(getLoginAdmin().getSupplierCode());
        //展示生成的账单
        queryDTO.setBill(1);

        PageBean<BusSupplyGoodsDTO> supplyGoods = supplierGoodsFacade.getSupplyGoods(queryDTO);
        List<BusSupplyGoodsDTO> record = supplyGoods.getRecord();
        BigDecimal a = BigDecimal.ZERO;
        for (BusSupplyGoodsDTO busSupplyGoodsDTO : record) {
            a.add(busSupplyGoodsDTO.getRealAmount());
        }

        return WebBean.ok(a);
    }


    @ApiOperation(value = "处理运营端商品的定时任务")
    @RequestMapping(value = "/task_bus", method = RequestMethod.GET)
    public WebBean<Void> taskBus() {
        supplierGoodsFacade.taskBus();
        return WebBean.ok();
    }

}
