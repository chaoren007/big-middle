package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class StoreDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    /**
     * 店铺电话
     */
    private String phone;					
    /**
     * 客服电话
     */
    private String tel;						
	/**
	 * 省
	 */
	private String provinceName;
	/**
	 * 市
	 */
	private String cityName;
	/**
	 * 区
	 */
	private String countyName;
    
    private String postageConfig;
    private BigDecimal deliveryFee;
    
    private Double lat;
    private Double lng;
    
    public StoreDTO() {
    }
    
    public StoreDTO(String code, String name, String phone, String postageConfig, BigDecimal deliveryFee) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.postageConfig = postageConfig;
        this.deliveryFee = deliveryFee;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}



	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPostageConfig(String postageConfig) {
		this.postageConfig = postageConfig;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostageConfig() {
        return postageConfig;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
    
}
