package com.morning.star.retail.admin.controller.reconciliation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.facade.StatementOrderServiceFacade;
import com.morning.star.retail.order.facade.dto.FinanceSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSummaryOrderVO;
import com.morning.star.retail.order.facade.dto.StatementSummaryVO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "集团对账服务")
@RestController
@RequestMapping("api/v1/group/reconciliation")
public class ReconciliationController extends AdminController {

    @Autowired
    private StatementOrderServiceFacade statementServiceFacade;


    @ApiOperation(value = "汇总")
    @PostMapping(value = "tradeChannelSummary")
    public WebJsonBean tradeChannelSummary(@RequestBody FinanceSearchDTO search) {
        AdminLoginContent login = getLoginAdmin();
        search.setGroupCode(login.getGroupCode());
        search.setStoreCode(login.getStoreCode());

        //TODO 刘越群
        Object result = null;//statementServiceFacade.tradeChannelSummary(search);
        return success(result);
    }

    @ApiOperation(value = "按门店查")
    @PostMapping(value = "storeSummary")
    public WebJsonBean storeSummary(@RequestBody FinanceSearchDTO search) {
        AdminLoginContent login = getLoginAdmin();
        search.setGroupCode(login.getGroupCode());
        search.setStoreCode(login.getStoreCode());

        //TODO 刘越群
        List list = new ArrayList();
        PageBean<StatementSummaryVO> result =
                new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);//statementServiceFacade.storeSummary(search);
        return success(result);
    }


    @ApiOperation(value = "按订单")
    @PostMapping(value = "tohomeList")
    @ResponseBody
    public WebJsonBean orderList(@RequestBody FinanceSearchDTO search) {
        AdminLoginContent login = getLoginAdmin();
        search.setGroupCode(login.getGroupCode());
        search.setStoreCode(login.getStoreCode());

        //TODO 刘越群
        List list = new ArrayList();
        PageBean<StatementSummaryOrderVO> result =
                new PageBean<>(1, list, search.getPageNo(), search.getPageSize(), 1);
        //statementServiceFacade.orderList(search);
        for (StatementSummaryOrderVO vo : result.getRecord()) {
            vo.setPayChannelDesc(PayChannel.getName(vo.getPayChannel()));
        }
        return success(result);
    }


    @ApiOperation(value = "按商品")
    @PostMapping(value = "queryDetail")
    @ResponseBody
    public WebJsonBean queryDetail(@RequestBody StatementOrderSearchDTO search) {
        AdminLoginContent login = getLoginAdmin();
        search.setGroupCode(login.getGroupCode());
        search.setStoreCode(login.getStoreCode());

        //TODO 刘越群
        List list1 = new ArrayList();
        PageBean<StatementOrderVO> result =
                new PageBean<>(1, list1, search.getPageNo(), search.getPageSize(), 1);//statementServiceFacade.queryDetail(search);
        List<StatementOrderVO> list = result.getRecord();
        if (!CollectionUtils.isEmpty(list)){
            list.stream().forEach(vo -> {
                vo.setDiscountAmount(BigDecimal.ZERO);

                String[] spec = new String[]{vo.getSpecValue1(), vo.getSpecValue2(), vo.getSpecValue3()};
                StringBuffer info = new StringBuffer();
                Arrays.stream(spec).filter(a -> StringUtils.isNotEmpty(a)).forEach(b -> info.append(b));
                vo.setGoodsSpecInfo(info.toString());

                String[] category = new String[]{vo.getCategoryName1(), vo.getCategoryName2(), vo.getCategoryName3()};
                StringBuffer name = new StringBuffer();
                Arrays.stream(category).filter(a -> StringUtils.isNotEmpty(a)).forEach(b -> name.append(b));
                vo.setCategory(name.toString());

                if (vo.getPayChannel() != null) {
                    vo.setPayChannelDesc(PayChannel.getName(vo.getPayChannel()));
                }
            });
        }
        return success(result);
        /*list.stream().forEach(vo -> {
            vo.setDiscountAmount(BigDecimal.ZERO);

            String[] spec = new String[]{vo.getSpecValue1(), vo.getSpecValue2(), vo.getSpecValue3()};
            StringBuffer info = new StringBuffer();
            Arrays.stream(spec).filter(a -> StringUtils.isNotEmpty(a)).forEach(b -> info.append(b));
            vo.setGoodsSpecInfo(info.toString());

            String[] category = new String[]{vo.getCategoryName1(), vo.getCategoryName2(), vo.getCategoryName3()};
            StringBuffer name = new StringBuffer();
            Arrays.stream(category).filter(a -> StringUtils.isNotEmpty(a)).forEach(b -> name.append(b));
            vo.setCategory(name.toString());

            if (vo.getPayChannel() != null) {
                vo.setPayChannelDesc(PayChannel.getName(vo.getPayChannel()));
            }
        });*/
    }
}
