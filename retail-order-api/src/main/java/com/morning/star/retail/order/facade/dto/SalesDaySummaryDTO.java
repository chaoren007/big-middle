package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/1/30.
 */
public class SalesDaySummaryDTO implements Serializable {
    private static final long serialVersionUID = 3366268618785581377L;
    //某个月份所有日期
    private List<String> dayList;
    //每天的销售金额列表
    private List<SalesDayDTO> salesDayList;

    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

    public List<SalesDayDTO> getSalesDayList() {
        return salesDayList;
    }

    public void setSalesDayList(List<SalesDayDTO> salesDayList) {
        this.salesDayList = salesDayList;
    }
}
