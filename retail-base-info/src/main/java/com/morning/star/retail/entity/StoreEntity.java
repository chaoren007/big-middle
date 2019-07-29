package com.morning.star.retail.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.morning.star.retail.facade.dto.StoreWmsDTO;
import org.hibernate.annotations.Where;

import com.morning.star.retail.enums.StoreModelType;

/**
 * 门店-实体对象
 */
@Entity
@Table(name = "retail_store")
@Where(clause = "delete_flag <> 1")
public class StoreEntity extends BaseEntity {
	private static final long serialVersionUID = 4513502104947576129L;

	@Id
	@Column(length = 64, nullable = false)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64, nullable = false)
	@Comment("门店名称")
	private String storeName;

	@Column(length = 64, nullable = false)
	@Comment("集团编码")
	private String groupCode;

	@Column(length = 64, nullable = false)
	@Comment("集团名称")
	private String groupName;

	@Column(length = 64)
	@Comment("负责人")
	private String manager;

	@Column(length = 64, nullable = false)
	@Comment("邮箱")
	private String email;

	@Column(length = 32, nullable = false)
	@Comment("负责人手机号")
	private String mobile;

	@Column(length = 32)
	@Comment("负责人qq")
	private String qq;

	@Column(length = 2, nullable = false)
	@Convert(converter = StoreModelType.DBConverter.class)
	@Comment("经营模式（0：自营；1：联营；2：租赁）")
	private StoreModelType model;

	@Comment("库存管理模式（0：总部维护；1：门店维护；2：共同维护）")
	private Integer stockModel;

	@Comment("门店最大pos数量")
	private Integer maxPosNum;

	@Comment("门店电话")
	@Column(length = 32)
	private String tel;

	@Comment("门店位置-经度")
	private String longitude;

	@Comment("门店位置-纬度")
	private String latitude;

	@Comment("门店地址")
	private String address;

	@Comment("省")
	private Long provinceId;

	@Comment("市")
	private Long cityId;

	@Comment("区")
	private Long countyId;

	@Comment("省名")
	@Column(length = 16)
	private String provinceName;

	@Comment("市名")
	@Column(length = 16)
	private String cityName;

	@Comment("区名")
	@Column(length = 16)
	private String countyName;

	@Comment("营业开始时间")
	private String openTime;

	@Comment("营业结束时间")
	private String closeTime;

	@Comment("门店营业状态 (OPEN-营业中；CLOSE-关闭中)")
	private String status;

	@Comment("是否冻结（0-正常 ，1-已冻结）")
	private Integer isFree;

	@Comment("支付方式（1：线上支付）")
	private Integer payType;

	@Comment("配送方式（1：送货上门；2：门店自提）")
	private String deliverType;

	@Comment("配送范围")
	private String deliverRange;

	@Comment("配送配置(配置1)")
	private String postageConfig;

	@Comment("免运费订单金额，即订单金额超过多少则免运费")
	private BigDecimal freePostageOrderFee;

	@Comment("运费")
	private BigDecimal postageFee;

	@Comment("即时送服务")
	private String instantService;

	@Comment("每日下单结束时间，在此时间前下单即可满足即时送")
	private String orderEndTime;

	@Comment("次日达服务")
	private String nextdayService;

	@Comment("售后服务")
	private String customerService;

	@Comment("是否允许门店自行增加商品（0：否；1：是）")
	private Integer canAddGoods;

	@Comment("是否允许门店自行定价（0：否；1：是）")
	private Integer canPriceGoods;

	@Comment("详情备注")
	private String remark;

	private Integer type;

	@Comment("权限ID（逗号分隔）")
	private String accessIds;

	@Comment("创建人")
	private String creator;

	@Comment("创建人名")
	private String creatorName;

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

	public StoreModelType getModel() {
		return model;
	}

	public void setModel(StoreModelType model) {
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public static StoreWmsDTO toWmsDTO(StoreEntity entity) {
		if(entity == null) {
			return null;
		}
		StoreWmsDTO wms = new StoreWmsDTO();
		wms.setStoreCode(entity.getStoreCode());
		wms.setStoreName(entity.getStoreName());

		return wms;
	}
}