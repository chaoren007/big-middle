package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;
import java.util.Date;

public class SalesOrderSearchVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1910090540669270942L;

	
	private Integer status;
    private int type = 0;
    private Date startTime;
    private Date endTime;
    private int pageNo = 1;
    private int pageSize = 10;
    private String keyWord;
    
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
	
	
}
