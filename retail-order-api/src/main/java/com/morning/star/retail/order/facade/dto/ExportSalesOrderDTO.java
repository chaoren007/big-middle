package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * 导出订单信息
 * 
 * @author jiangyf
 * @date 2017年9月11日 下午3:17:14
 */
public class ExportSalesOrderDTO implements Serializable {
	private static final long serialVersionUID = -4747131725684945423L;

	/**
	 * 订单编号
	 */
	@ExcelColumn(name = "订单号", isExport = true)
	private String orderCode;
	/**
	 * 生成订单时间
	 */
	@ExcelColumn(name = "生成订单时间", isExport = true)
	private String createTime;
	/**
	 * 支付时间
	 */
	@ExcelColumn(name = "支付时间", isExport = true)
	private String payTime;
	/**
	 * 门店/编号
	 */
	@ExcelColumn(name = "门店/编号", isExport = true)
	private String storeInfo;
	/**
	 * 收货人姓名
	 */
	@ExcelColumn(name = "收货人姓名", isExport = true)
	private String receiverName;
	/**
	 * 收货人电话
	 */
	@ExcelColumn(name = "收货人电话", isExport = true)
	private String receiverPhone;
	/**
	 * 收货人地址
	 */
	@ExcelColumn(name = "收货人地址", isExport = true)
	private String receiverAddress;
	/**
	 * 配送方式
	 */
	@ExcelColumn(name = "配送方式", isExport = true)
	private String deliveryType;
	/**
	 * 订单类型（0线上 1线下）
	 */
	@ExcelColumn(name = "订单类型", isExport = true)
	private String orderType;
	/**
	 * 订单总金额
	 */
	@ExcelColumn(name = "订单总金额", isExport = true)
	private BigDecimal totalPrice;
	/**
	 * 订单运费
	 */
	@ExcelColumn(name = "订单运费", isExport = true)
	private BigDecimal deliveryFee;
	/**
	 * 订单优惠金额
	 */
	@ExcelColumn(name = "订单优惠金额", isExport = true)
	private BigDecimal discountAmount;
	/**
	 * 订单实付金额
	 */
	@ExcelColumn(name = "订单实付金额", isExport = true)
	private BigDecimal realPayAmount;
	/**
	 * 订单支付方式
	 */
	@ExcelColumn(name = "订单支付方式", isExport = true)
	private String paymentChannel;
	/**
	 * 预付卡支付金额
	 */
	@ExcelColumn(name = "预付卡支付", isExport = true)
	private BigDecimal prepayCardAmount;
	/**
	 * 订单处理状态
	 */
	@ExcelColumn(name = "订单处理状态", isExport = true)
	private String orderStatus;
	/**
	 * 订单支付状态
	 */
	@ExcelColumn(name = "订单支付状态", isExport = true)
	private String paymentStatus;
	/**
	 * 买家备注
	 */
	@ExcelColumn(name = "买家备注", isExport = true)
	private String buyRemark;
	/**
	 * 商品编码
	 */
	@ExcelColumn(name = "商品编码", isExport = true)
	private String itemCode;
	/**
	 * upc
	 */
	@ExcelColumn(name = "UPC", isExport = true)
	private String upcCode;
	/**
	 * 商品名称
	 */
	@ExcelColumn(name = "商品名称", isExport = true)
	private String itemName;
	/**
	 * 商品分类
	 */
	@ExcelColumn(name = "商品分类", isExport = true)
	private String category;
	/**
	 * 商品单价
	 */
	@ExcelColumn(name = "商品单价", isExport = true)
	private BigDecimal unitPrice;
	/**
	 * 购买数量
	 */
	@ExcelColumn(name = "购买数量", isExport = true)
	private int buyNum;
	/**
	 * 该商品所购金额
	 */
	@ExcelColumn(name = "商品金额", isExport = true)
	private BigDecimal buyPrice;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getRealPayAmount() {
		return realPayAmount;
	}

	public void setRealPayAmount(BigDecimal realPayAmount) {
		this.realPayAmount = realPayAmount;
	}

	public String getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getBuyRemark() {
		return buyRemark;
	}

	public void setBuyRemark(String buyRemark) {
		this.buyRemark = buyRemark;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

}
