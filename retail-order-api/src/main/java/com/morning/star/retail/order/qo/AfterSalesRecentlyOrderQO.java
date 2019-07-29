package com.morning.star.retail.order.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liangguobin on 2017/5/31.
 */
public class AfterSalesRecentlyOrderQO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 4642958103630746369L;

	//    public static  final  int ALL_TRACK = 1;
    public static  final  int LATEST_TRACK = 2; // 只查询最近的轨迹

    private int pageNo;
    private int pageSize;
    private int status;
    private int refundType;
    private Date startTime;
    private Date endTime;

    private int includeTrack;
    private Integer hasReturnedItem;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRefundType() {
        return refundType;
    }

    public void setRefundType(int refundType) {
        this.refundType = refundType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIncludeTrack() {
        return includeTrack;
    }

    public void setIncludeTrack(int includeTrack) {
        this.includeTrack = includeTrack;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getHasReturnedItem() {
        return hasReturnedItem;
    }

    public void setHasReturnedItem(Integer hasReturnedItem) {
        this.hasReturnedItem = hasReturnedItem;
    }
}
