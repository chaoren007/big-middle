package com.morning.star.retail.export.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kimhuhg
 * @create_time 2018/10/16 9:42
 */
public class ExportRecordDTO implements Serializable {
	private static final long serialVersionUID = 502091575038006187L;

	private Long id;

	//集团编码
	private String groupCode;

	//门店编码
	private String storeCode;

    //查询条件字符串
    private String queryStr;

	//导出类型
	private String type;

	//导出状态
	private Integer status;

	//用户唯一标识
	private Long userId;

	//用户名
	private String username;

	//文件地址
	private String url;

	//创建时间
	private Date createTime = new Date();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }
}
