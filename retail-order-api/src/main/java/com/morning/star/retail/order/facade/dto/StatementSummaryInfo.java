package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/2/2.
 */
public class StatementSummaryInfo implements Serializable {
    private static final long serialVersionUID = 3650113946090268181L;

    //统计项
    List<StatisticsItem> statisticsItems;
    //根据支付渠道排序列表
    List<StatementSummaryVO> tradeChannelDetail;
    //根据业务类型排序
    List<StatementSummaryVO> businessTypeDetail;

    public List<StatisticsItem> getStatisticsItems() {
        return statisticsItems;
    }

    public void setStatisticsItems(List<StatisticsItem> statisticsItems) {
        this.statisticsItems = statisticsItems;
    }

    public List<StatementSummaryVO> getTradeChannelDetail() {
        return tradeChannelDetail;
    }

    public void setTradeChannelDetail(List<StatementSummaryVO> tradeChannelDetail) {
        this.tradeChannelDetail = tradeChannelDetail;
    }

    public List<StatementSummaryVO> getBusinessTypeDetail() {
        return businessTypeDetail;
    }

    public void setBusinessTypeDetail(List<StatementSummaryVO> businessTypeDetail) {
        this.businessTypeDetail = businessTypeDetail;
    }
}
