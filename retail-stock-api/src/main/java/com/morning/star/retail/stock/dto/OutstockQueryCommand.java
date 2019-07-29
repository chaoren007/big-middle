package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.util.Date;

import com.morning.star.retail.consts.RetailDefaultConst;

import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutstockQueryCommand implements Serializable {

	private static final long serialVersionUID = 5442615802882509362L;
	/**
	 * 出库单号
	 */
	@ApiModelProperty(value = "出库单号")
	private String outstockCode;
	/**
	 * 入库单号
	 */
	@ApiModelProperty(value = "入库单号")
	private String instockCode;
	/**
	 * 调入门店编码
	 */
	@ApiModelProperty(value = "调入方编码")
	private String receiverCode;
	/**
	 * 调入门店名称
	 */
	@ApiModelProperty(value = "调入方名称")
	private String receiverName;

	/**
	 * 出库类型（0：其他，1：调拨出库）
	 */
	@ApiModelProperty(value = "出库类型（0：其他，1：调拨出库）")
	private Integer type;
	/**
	 * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、出库
	 */
	@ApiModelProperty(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、出库")
	private Integer status;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private Date startTime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private Date endTime;
	/**
	 * 商品编码
	 */
	@ApiModelProperty(value = "商品编码")
	private String goodsCode;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(value = "商品名称")
	private String goodsName;
	/**
	 * upc
	 */
	@ApiModelProperty(value = "upc")
	private String upcCode;
	/**
	 * 页码
	 */
	@ApiModelProperty(required = true, value = "页码")
	private Integer pageNo;
	/**
	 * 每页记录数
	 */
	@ApiModelProperty(required = true, value = "每页记录数")
	private Integer pageSize;

	public String getOutstockCode() {
		return outstockCode;
	}

	public void setOutstockCode(String outstockCode) {
		this.outstockCode = outstockCode;
	}

	public String getInstockCode() {
		return instockCode;
	}

	public void setInstockCode(String instockCode) {
		this.instockCode = instockCode;
	}

	public String getReceiverCode() {
		return receiverCode;
	}

	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Integer getPageNo() {
		if (pageNo == null || pageNo <= 0) {
			return 1;
		}
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		if (pageSize == null || pageSize <= 0) {
			return RetailDefaultConst.ADMIN_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
