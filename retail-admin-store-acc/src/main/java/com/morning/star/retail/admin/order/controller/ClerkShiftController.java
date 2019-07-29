package com.morning.star.retail.admin.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.order.facade.ClerkShiftServiceFacade;
import com.morning.star.retail.order.facade.dto.ClerkShiftBO;
import com.morning.star.retail.order.facade.dto.ClerkShiftDO;
import com.morning.star.retail.order.facade.dto.ClerkShiftDetailDO;
import com.morning.star.retail.order.facade.dto.ClerkShiftInfoVO;

/**
 * Created by lenovo on 2018/1/3.
 */
@Controller
@RequestMapping(value = "/api/shift/")
public class ClerkShiftController extends AdminController {
    private static final Logger logger = LoggerFactory.getLogger(ClerkShiftController.class);
    private static final Gson GSON = new Gson();
    @Autowired
    private ClerkShiftServiceFacade clerkShiftServiceFacade;
    @Autowired
    private AccountFacade accountFacade;

    @RequestMapping(value = "listShiftRecord")
    @ResponseBody
    public WebJsonBean pageShiftRecord(@RequestBody ClerkShiftBO clerkShiftBO) {
        AdminLoginContent login =  getLoginAdmin();
        Integer pageNo = clerkShiftBO.getPageNo();
        Integer pageSize = clerkShiftBO.getPageSize();
        // clerkShiftBO.setAccount(login.getAccount());
        clerkShiftBO.setGroupCode(login.getGroupCode());
        clerkShiftBO.setStoreCode(login.getStoreCode());
        clerkShiftBO.setPageNo(pageNo == null ? 1 : pageNo);
        clerkShiftBO.setPageSize(pageSize == null ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);
        return success(this.clerkShiftServiceFacade.listShiftRecord(clerkShiftBO));
    }

    @RequestMapping(value = "getShiftDetail", method = RequestMethod.POST)
    @ResponseBody
    public WebJsonBean getShiftRecord(Integer shiftRecordId) {
        Object result = clerkShiftServiceFacade.getShiftRecord(shiftRecordId);
        return success(result);
    }

    @RequestMapping(value = "submit")
    @ResponseBody
    public WebJsonBean clerkShift(@RequestBody ClerkShiftBO clerkShiftBO) {
        AdminLoginContent login = getLoginAdmin();

        AccountDTO receiverAccount=null;
        if(clerkShiftBO.getReceiverAccount()!=null) {
            receiverAccount = this.accountFacade.getAccount(clerkShiftBO.getReceiverAccount());
            if (receiverAccount == null) {
                return fail(CODE.NO_USER);
            }
        }
        clerkShiftBO.setAccount(login.getAccount());
        clerkShiftBO.setGroupCode(login.getGroupCode());
        clerkShiftBO.setStoreCode(login.getStoreCode());

        ClerkShiftInfoVO clerkShiftInfoVO=clerkShiftServiceFacade.generateShiftData(clerkShiftBO);
        addShiftRecord(login, receiverAccount, clerkShiftBO,clerkShiftInfoVO);
        return success(clerkShiftInfoVO);
    }

    private void addShiftRecord(AdminLoginContent login, AccountDTO receiverAccount, ClerkShiftBO clerkShiftBO,ClerkShiftInfoVO clerkShiftInfoVO) {
        ClerkShiftDO clerkShiftDO=new ClerkShiftDO();
        clerkShiftDO.setGroupCode(login.getGroupCode());
        clerkShiftDO.setStoreCode(login.getStoreCode());
        clerkShiftDO.setStoreName(login.getStoreName());
        clerkShiftDO.setSurrenderAccount(login.getAccount());
        clerkShiftDO.setSurrenderName(login.getName());
        if(receiverAccount!=null) {
            clerkShiftDO.setReceiverAccount(receiverAccount.getAccount());
            clerkShiftDO.setReceiverName(receiverAccount.getName());
        }
        clerkShiftDO.setCash(clerkShiftBO.getCash());
        clerkShiftDO.setHandoverTime(clerkShiftBO.getHandoverTime());
        clerkShiftDO.setLoginTime(clerkShiftBO.getLoginTime());

        clerkShiftDO.setSaleNum(clerkShiftInfoVO.getSaleNum());
        clerkShiftDO.setSaleAmount(clerkShiftInfoVO.getSaleAmount());
        clerkShiftDO.setRefundNum(clerkShiftInfoVO.getRefundNum());
        clerkShiftDO.setRefundAmount(clerkShiftInfoVO.getRefundAmount());
        logger.info("----------------------------------clerkShiftDO:{}",GSON.toJson(clerkShiftDO));
        Integer shiftRecordId=clerkShiftServiceFacade.addShiftRecord(clerkShiftDO);

        logger.info("---------------addShiftRecord------------clerkShiftDO:{}",GSON.toJson(clerkShiftDO));
        //添加交班对账明细
        ClerkShiftDetailDO newDetail=null;
        for(ClerkShiftDetailDO detail:clerkShiftInfoVO.getSaleDetail()) {
            newDetail= ObjectCopier.copyObject(ClerkShiftDetailDO.class,detail);
            newDetail.setShiftRecordId(shiftRecordId);
            logger.info("---------------SaleDetail------------SaleDetail:{}",GSON.toJson(newDetail));
            clerkShiftServiceFacade.addShiftDetail(newDetail);
        }
        logger.info("---------------addSaleDetail------------ClerkShiftDetailDO:{}",GSON.toJson(clerkShiftInfoVO.getSaleDetail()));
        for(ClerkShiftDetailDO detail:clerkShiftInfoVO.getRefundDetail()) {
            detail.setShiftRecordId(shiftRecordId);
            clerkShiftServiceFacade.addShiftDetail(detail);
        }
        logger.info("---------------addRefundDetail------------RefundDetail:{}",GSON.toJson(clerkShiftInfoVO.getRefundDetail()));
    }
}
