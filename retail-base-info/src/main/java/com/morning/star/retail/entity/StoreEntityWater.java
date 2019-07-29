package com.morning.star.retail.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 门店-实体对象
 * 
 */
@Entity
@Table(name = "retail_store_water")
public class StoreEntityWater extends WaterEntity {
	private static final long serialVersionUID = 4513502104947576129L;

	/**
	 * 门店编码
	 */
	@Column(length = 64)
	private String storeCode;
	/**
	 * 门店名称
	 */
	@Column(length = 64)
	private String storeName;
	/**
	 * 负责人
	 */
	@Column(length = 64)
	private String manager;
	/**
	 * 负责人邮箱
	 */
	@Column(length = 64)
	private String email;
	/**
	 * 负责人电话
	 */
	@Column(length = 32)
	private String mobile;
	/**
	 * 负责人qq
	 */
	@Column(length = 32)
	private String qq;
	/**
	 * 经营模式（0：直营；1：联营；2：加盟；3：入驻）
	 */
	private Integer model;
	/**
	 * 库存管理模式（0：总部维护；1：门店维护；2：共同维护）
	 */
	private Integer stockModel;
	/**
	 * 门店最大pos数量
	 */
	private Integer maxPosNum;
	/**
	 * 门店电话
	 */
	@Column(length = 32)
	private String tel;
	/**
	 * 门店位置-经度
	 */
	private String longitude;
	/**
	 * 门店位置-纬度
	 */
	private String latitude;
	/**
	 * 门店地址
	 */
	private String address;
	/**
	 * 省
	 */
	private Long provinceId;
	/**
	 * 市
	 */
	private Long cityId;
	/**
	 * 区
	 */
	private Long countyId;
	/**
	 * 省
	 */
	@Column(length = 16)
	private String provinceName;
	/**
	 * 市
	 */
	@Column(length = 16)
	private String cityName;
	/**
	 * 区
	 */
	@Column(length = 16)
	private String countyName;
	/**
	 * 营业开始时间
	 */
	private String openTime;
	/**
	 * 营业结束时间
	 */
	private String closeTime;
	/**
	 * 门店营业状态 (OPEN-营业中；CLOSE-关闭中)
	 */
	private String status;
	/**
	 * 是否冻结（0-正常 ，1-已冻结）
	 */
	private Integer isFree;
	/**
	 * 支付方式（1：线上支付）
	 */
	private Integer payType;
	/**
	 * 配送方式（1：送货上门；2：门店自提）
	 */
	private String deliverType;
	/**
	 * 配送范围
	 */
	private String deliverRange;
	/**
	 * 配送配置(配置1)
	 */
	private String postageConfig;
	/**
	 * 免运费订单金额，即订单金额超过多少则免运费
	 */
	private BigDecimal freePostageOrderFee;
	/**
	 * 运费
	 */
	private BigDecimal postageFee;
	/**
	 * 即时送服务
	 */
	private String instantService;
	/**
	 * 每日下单结束时间，在此时间前下单即可满足即时送
	 */
	private String orderEndTime;
	/**
	 * 次日达服务
	 */
	private String nextdayService;
	/**
	 * 售后服务
	 */
	private String customerService;
	/**
	 * 是否允许门店自行增加商品（0：否；1：是）
	 */
	private Integer canAddGoods;
	/**
	 * 是否允许门店自行定价（0：否；1：是）
	 */
	private Integer canPriceGoods;
	/**
	 * 详情备注
	 */
	private String remark;
	
	
	private Integer type;

	/**
	 * 集团编码
	 */
	private String groupCode;

	/**
	 * 集团名称
	 */
	private String groupName;

	/**
	 * 权限ID（逗号分隔）
	 */
	private String accessIds;

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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public Integer getMaxPosNum() {
		return maxPosNum;
	}

	public void setMaxPosNum(Integer maxPosNum) {
		this.maxPosNum = maxPosNum;
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

	public Integer getIsFree() {
		return isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

	public String getAccessIds() {
		return accessIds;
	}

	public void setAccessIds(String accessIds) {
		this.accessIds = accessIds;
	}

}