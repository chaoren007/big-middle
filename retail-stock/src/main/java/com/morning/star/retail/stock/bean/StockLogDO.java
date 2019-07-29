package com.morning.star.retail.stock.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 库存日志-数据源对象
 * 
 * @author jiangyf
 */
public class StockLogDO implements Serializable {
	private static final long serialVersionUID = -6448787743486171092L;

	/**
	 * 记录ID
	 */
	private Integer id;
	/**
	 * 公司编码
	 */
	private String companyCode;
	/**
	 * 门店编码
	 */
	private String storeCode;
	/**
	 * 执行操作
	 */
	private String action;
	/**
	 * 访问路径
	 */
	private String url;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 操作类型(C：增；R：查；U：改；D：删)
	 */
	private String type;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 操作人ID
	 */
	private String operatorId;
	/**
	 * 操作人姓名
	 */
	private String operatorName;
	/**
	 * 详情备注
	 */
	private String remark;

	public StockLogDO() {
	}

	public StockLogDO(String companyCode, String storeCode, String action,
			String url, String ip, String type, Date createTime,
			String operatorId, String operatorName, String remark) {
		this.companyCode = companyCode;
		this.storeCode = storeCode;
		this.action = action;
		this.url = url;
		this.ip = ip;
		this.type = type;
		this.createTime = createTime;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
