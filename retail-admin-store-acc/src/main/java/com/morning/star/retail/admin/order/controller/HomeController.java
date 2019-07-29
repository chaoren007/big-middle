package com.morning.star.retail.admin.order.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.order.facade.ClerkShiftServiceFacade;
import com.morning.star.retail.order.facade.OrderServiceFacadeForAdmin;
import com.morning.star.retail.order.facade.StatementOrderServiceFacade;
import com.morning.star.retail.order.facade.dto.ClerkShiftBO;
import com.morning.star.retail.order.facade.dto.ExportOrderItemSummaryDTO;
import com.morning.star.retail.order.facade.dto.HomeSearchDTO;
import com.morning.star.retail.order.facade.dto.ItemStatisticsInfo;
import com.morning.star.retail.order.facade.dto.SalesItemSummaryDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderSearchDTO;
import com.morning.star.retail.order.facade.dto.StatementOrderVO;
import com.morning.star.retail.stock.dto.StockDTO;
import com.morning.star.retail.stock.dto.StockQueryDTO;
import com.morning.star.retail.util.DateUtil;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by lenovo on 2018/1/26.
 */
@Api(tags = "工作台")
@Controller
@RequestMapping(value = "/api/home/")
public class HomeController extends AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private static final Gson GSON = new Gson();

    @Autowired
    private StatementOrderServiceFacade statementServiceFacade;
    @Autowired
    private ClerkShiftServiceFacade clerkShiftServiceFacade;
    @Autowired
    private OrderServiceFacadeForAdmin orderServiceFacade;

    @Autowired
    private StockFacade stockFacade;

    @ApiOperation(value = "销售统计")
    @RequestMapping(value = "sales",method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean salesData(HomeSearchDTO searchDTO) {
        AdminLoginContent login =  getLoginAdmin();
        ClerkShiftBO clerkShiftBO=new ClerkShiftBO();
        //clerkShiftBO.setAccount(login.getAccount());
        clerkShiftBO.setGroupCode(login.getGroupCode());
       // clerkShiftBO.setCompanyCode(searchDTO.getCompanyCode());
        clerkShiftBO.setStoreCode(login.getStoreCode());
        clerkShiftBO.setLoginTime(searchDTO.getBeginTime());
        clerkShiftBO.setHandoverTime(searchDTO.getEndTime());
        return success(this.clerkShiftServiceFacade.generateShiftData(clerkShiftBO));
    }

    @ApiOperation(value = "商品统计畅销")
    @RequestMapping(value = "topSaleItems", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean topSaleItems(HomeSearchDTO searchDTO) throws Exception {
        AdminLoginContent login =  getLoginAdmin();
        Integer topNum=searchDTO.getTopNum();
        Integer pageNo = searchDTO.getPageNo();

        searchDTO.setPageNo(pageNo == null ? 1 : pageNo);
        searchDTO.setPageSize(topNum == null ? 10: topNum);
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());
        searchDTO.setOrderFiled(searchDTO.getOrderFiled()==null?"saleNum":searchDTO.getOrderFiled());

        PageBean<SalesItemSummaryDTO> list=orderServiceFacade.countSaleItems(searchDTO);
        return success(list.getRecord());
    }

    @ApiOperation(value = "商品统计低销")
    @RequestMapping(value = "downSaleItems", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean downSaleItems(HomeSearchDTO searchDTO) throws Exception {
        AdminLoginContent login =  getLoginAdmin();
        Integer topNum=searchDTO.getTopNum();
        Integer pageNo = searchDTO.getPageNo();

        searchDTO.setPageNo(pageNo == null ? 1 : pageNo);
        searchDTO.setPageSize(topNum == null ? 10: topNum);
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());
        //按照销售数量排序
        searchDTO.setOrderBySaleNumAsc(true);
        searchDTO.setOrderFiled(searchDTO.getOrderFiled()==null?"saleNum":searchDTO.getOrderFiled());

        PageBean<SalesItemSummaryDTO> list=orderServiceFacade.countSaleItems(searchDTO);
        return success(list.getRecord());
    }

    @ApiOperation(value = "销售天数")
    @RequestMapping(value = "salesDay", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean salesDaySummary(HomeSearchDTO searchDTO) {
        AdminLoginContent login =  getLoginAdmin();
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());

        return success(orderServiceFacade.salesDaySummary(searchDTO));
    }

    @ApiOperation(value = "销售详情统计")
    @RequestMapping(value = "saleItemsSummary", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean saleItemsSummary(HomeSearchDTO searchDTO) {
        AdminLoginContent login =  getLoginAdmin();
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());
        LOGGER.info("start ------- SaleItemsSummary ------- searchDTO:{}", GSON.toJson(searchDTO));
        ItemStatisticsInfo result=orderServiceFacade.saleItemsSummary(searchDTO);
        LOGGER.info("end ------- SaleItemsSummary ------- result:{}", GSON.toJson(result));
        return success(result);
    }

    @ApiOperation(value = "获取在库商品数量")
    @RequestMapping(value = "getInStockNum", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean getInStockNum(HomeSearchDTO searchDTO) {
        AdminLoginContent login = getLoginAdmin();
        StockQueryDTO queryDTO =new StockQueryDTO();
        queryDTO.setGroupCode(login.getGroupCode());
        queryDTO.setStoreCode(searchDTO.getStoreCode());

        // stockBO.setStockStatus(1);//查询在库商品

        List<StockDTO> stockList=stockFacade.query(queryDTO);
        BigDecimal totalNum = BigDecimal.ZERO;
        for(StockDTO stock : stockList){
            totalNum.add(stock.getDoneInStockNum());
        }
        //List<UsedStockVO> stockVOList=stockPOList.stream().map(e->UsedStockVO.fromDTO(e)).collect(Collectors.toList());

        return success(totalNum);
    }

    @ApiOperation(value = "畅销详情分类")
    @RequestMapping(value = "topItemCategory", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean topItemCategory(@RequestBody HomeSearchDTO searchDTO) throws Exception {
        AdminLoginContent login =  getLoginAdmin();
        Integer topNum=searchDTO.getTopNum();
        Integer pageNo = searchDTO.getPageNo();

        searchDTO.setPageNo(pageNo == null ? 1 : pageNo);
        searchDTO.setPageSize(topNum == null ? 10: topNum);
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());
        searchDTO.setOrderFiled(searchDTO.getOrderFiled()==null?"saleNum":searchDTO.getOrderFiled());

        PageBean<SalesItemSummaryDTO> list=orderServiceFacade.countItemCategory(searchDTO);
        return success(list.getRecord());
    }

    @ApiOperation(value = "低销详情分类")
    @RequestMapping(value = "downItemCategory", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean downItemCategory(@RequestBody HomeSearchDTO searchDTO) throws Exception {
        AdminLoginContent login =  getLoginAdmin();
        Integer topNum=searchDTO.getTopNum();
        Integer pageNo = searchDTO.getPageNo();

        searchDTO.setPageNo(pageNo == null ? 1 : pageNo);
        searchDTO.setPageSize(topNum == null ? 10: topNum);
        searchDTO.setGroupCode(login.getGroupCode());
//        searchDTO.setCompanyCode(searchDTO.getCompanyCode());
        searchDTO.setStoreCode(login.getStoreCode());
        searchDTO.setBeginTime(searchDTO.getBeginTime());
        searchDTO.setEndTime(searchDTO.getEndTime());
        //按照销售数量排序
        searchDTO.setOrderBySaleNumAsc(true);
        searchDTO.setOrderFiled(searchDTO.getOrderFiled()==null?"saleNum":searchDTO.getOrderFiled());

        PageBean<SalesItemSummaryDTO> list=orderServiceFacade.countItemCategory(searchDTO);
        return success(list.getRecord());
    }

    @ApiOperation(value = "导出订单明细统计")
    @RequestMapping(value = "exportOrderItemSummary", method = RequestMethod.GET)
    @ResponseBody
    public WebJsonBean exportOrderItemSummary(StatementOrderSearchDTO search,HttpServletResponse response) {
        LOGGER.info("------------ exportOrderItemSummary ------------ start");

        AdminLoginContent login = getLoginAdmin();
//        String companyCode = search.getCompanyCode();

        Integer pageSize=Integer.MAX_VALUE;
        search.setGroupCode(login.getGroupCode());
//        search.setCompanyCode(companyCode);
        search.setStoreCode(search.getStoreCode());
        search.setPageNo(1);
        search.setPageSize(pageSize);

        PageBean<StatementOrderVO> orders = statementServiceFacade.orderItemSummary(search);
        Long totalNum=orders.getTotalNum();

        List<StatementOrderVO> orderList=orders.getRecord();

       // List<List<Object>> list = this.getExportData(orderList);
        if (CollectionUtils.isEmpty(orderList)) {
            throw new IllegalArgumentException("结算单不存在");
        }

        Integer saleNum=0;
        BigDecimal saleAmount=BigDecimal.ZERO;
        Integer refundNum=0;
        BigDecimal refundAmount=BigDecimal.ZERO;
        BigDecimal realAmount=BigDecimal.ZERO;
        List<ExportOrderItemSummaryDTO> orderItemSummaryDTOS = new ArrayList<>();
        ExportOrderItemSummaryDTO dto=null;
        for(StatementOrderVO order : orderList) {
            dto = new ExportOrderItemSummaryDTO();
            dto.setPayTime(order.getPayTime()==null?"":DateUtil.toString(order.getPayTime(),"yyyy-MM-dd"));
            dto.setGoodsName(order.getGoodsName());
            dto.setGoodsCode(order.getGoodsCode());
            dto.setUpc(order.getUpc()== null ? "" :order.getUpc());
            dto.setNum(order.getNum());
            dto.setType(order.getType());
            dto.setAmount(order.getAmount());
            dto.setCategoryName1(order.getCategoryName1()== null ? "" :order.getCategoryName1());
            dto.setCategoryName2(order.getCategoryName2()== null ? "" :order.getCategoryName2());
            dto.setCategoryName3(order.getCategoryName3()== null ? "" :order.getCategoryName3());

            String goodsSpecInfo = "";
            if(StringUtils.isBlank(order.getSpecValue2())){
                goodsSpecInfo=order.getSpecValue1();
            }else if(StringUtils.isBlank(order.getSpecValue3())){
                goodsSpecInfo=String.format("%s,%s",order.getSpecValue1(),order.getSpecValue2());
            }else{
                goodsSpecInfo=String.format("%s,%s,%s",order.getSpecValue1(),order.getSpecValue2(),order.getSpecValue3());
            }
            dto.setSpecInfo(goodsSpecInfo);

            dto.setStoreName(order.getStoreName() == null ? "" : order.getStoreName());
            orderItemSummaryDTOS.add(dto);
            if(order.getType().equals("入账")) {
                saleNum += order.getNum();
                saleAmount = saleAmount.add(order.getAmount());
            }else {
                refundNum += order.getNum();
                refundAmount=refundAmount.add(order.getAmount());
            }
        }

        realAmount=saleAmount.subtract(refundAmount);
        //添加合计行
        dto = new ExportOrderItemSummaryDTO();
        dto.setPayTime("");
        dto.setGoodsName("");
        dto.setGoodsCode("");
        dto.setUpc("销售数量:");
        dto.setNum(saleNum);
        dto.setType("销售金额:");
        dto.setAmount(saleAmount);
        dto.setCategoryName1("退货数量:");
        dto.setCategoryName2(String.valueOf(refundNum));
        dto.setCategoryName3("退货金额:");
        dto.setSpecInfo(String.valueOf(refundAmount));
        orderItemSummaryDTOS.add(dto);

        LOGGER.info("------------ exportOrderItemSummary ------------ rows:{},ExportData{}", orderList.size(),GSON.toJson(orderList));

        try {
          //  PoiUtil.exportExcel("商品汇总", HEADERS, list, FILE_NAME, response);
            new ExcelUtil<>(ExportOrderItemSummaryDTO.class).writeToHttpResponse(orderItemSummaryDTOS, "商品销售汇总.xls", "商品汇总", response);
        } catch (Exception e) {
            LOGGER.info("------------ exportOrderItemSummary ------------ Exception：{}", e.toString());
            throw new IllegalArgumentException("导出账期数据错误");
        }

        return success();
    }

}
