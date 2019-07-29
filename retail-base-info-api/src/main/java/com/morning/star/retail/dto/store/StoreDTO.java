package com.morning.star.retail.dto.store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 门店详情
 */
@ApiModel
public class StoreDTO implements Serializable {
	private static final long serialVersionUID = -5886149595928713815L;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("负责人")
	private String manager;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("负责人手机号")
	private String mobile;

	@ApiModelProperty("经营模式（0：自营；1：联营；2：租赁）")
	private Integer model;

	@ApiModelProperty("库存管理模式（0：总部维护；1：门店维护；2：共同维护）")
	private Integer stockModel;

	@ApiModelProperty("门店电话")
	private String tel;

	@ApiModelProperty("门店位置-经度")
	private String longitude;

	@ApiModelProperty("门店位置-纬度")
	private String latitude;

	@ApiModelProperty("门店地址")
	private String address;

	@ApiModelProperty("省")
	private Long provinceId;

	@ApiModelProperty("市")
	private Long cityId;

	@ApiModelProperty("区")
	private Long countyId;

	@ApiModelProperty("省名")
	private String provinceName;

	@ApiModelProperty("市名")
	private String cityName;

	@ApiModelProperty("区名")
	private String countyName;

	@ApiModelProperty("营业开始时间")
	private String openTime;

	@ApiModelProperty("营业结束时间")
	private String closeTime;

	@ApiModelProperty("门店营业状态 (OPEN-营业中；CLOSE-关闭中)")
	private String status;

	@ApiModelProperty("是否冻结（0-正常 ，1-已冻结）")
	private Integer isFree;

	@ApiModelProperty("支付方式（1：线上支付）")
	private Integer payType;

	@ApiModelProperty("配送方式（1：送货上门；2：门店自提）")
	private String deliverType;

	@ApiModelProperty("配送范围")
	private String deliverRange;

	@ApiModelProperty("配送配置(配置1)")
	private String postageConfig;

	@ApiModelProperty("免运费订单金额，即订单金额超过多少则免运费")
	private BigDecimal freePostageOrderFee;

	@ApiModelProperty("运费")
	private BigDecimal postageFee;

	@ApiModelProperty("即时送服务")
	private String instantService;

	@ApiModelProperty("每日下单结束时间，在此时间前下单即可满足即时送")
	private String orderEndTime;

	@ApiModelProperty("次日达服务")
	private String nextdayService;

	@ApiModelProperty("售后服务")
	private String customerService;

	@ApiModelProperty("是否允许门店自行增加商品（0：否；1：是）")
	private Integer canAddGoods;

	@ApiModelProperty("是否允许门店自行定价（0：否；1：是）")
	private Integer canPriceGoods;

	private Integer type;

	@ApiModelProperty("权限ID（逗号分隔）")
	private String accessIds;

	private Date createTime;


	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getStockModel() {
		return stockModel;
	}

	public void setStockModel(Integer stockModel) {
		this.stockModel = stockModel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getDeliverType() {
		return deliverType;
	}

	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}

	public String getDeliverRange() {
		return deliverRange;
	}

	public void setDeliverRange(String deliverRange) {
		this.deliverRange = deliverRange;
	}

	public String getPostageConfig() {
		return postageConfig;
	}

	public void setPostageConfig(String postageConfig) {
		this.postageConfig = postageConfig;
	}

	public BigDecimal getFreePostageOrderFee() {
		return freePostageOrderFee;
	}

	public void setFreePostageOrderFee(BigDecimal freePostageOrderFee) {
		this.freePostageOrderFee = freePostageOrderFee;
	}

	public BigDecimal getPostageFee() {
		return postageFee;
	}

	public void setPostageFee(BigDecimal postageFee) {
		this.postageFee = postageFee;
	}

	public String getInstantService() {
		return instantService;
	}

	public void setInstantService(String instantService) {
		this.instantService = instantService;
	}

	public String getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public String getNextdayService() {
		return nextdayService;
	}

	public void setNextdayService(String nextdayService) {
		this.nextdayService = nextdayService;
	}

	public String getCustomerService() {
		return customerService;
	}

	public void setCustomerService(String customerService) {
		this.customerService = customerService;
	}

	public Integer getCanAddGoods() {
		return canAddGoods;
	}

	public void setCanAddGoods(Integer canAddGoods) {
		this.canAddGoods = canAddGoods;
	}

	public Integer getCanPriceGoods() {
		return canPriceGoods;
	}

	public void setCanPriceGoods(Integer canPriceGoods) {
		this.canPriceGoods = canPriceGoods;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

	public Integer getIsFree() {
		return isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
