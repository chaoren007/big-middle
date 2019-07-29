package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class BusOpcDTO  implements Serializable {

    /**
     * 运营点编码
     */

    private String opc ;
    /**
     * 是 运营点名册
     */
    private String opcName ;
    /**
     * 是 供应商入驻电话
     */
    private String supplierEnterPhone ;
    /**
     * 是 团长入驻电话   是
     */
    private String agentEnterPhone ;
    /**
     *  否 	string 	地址
     */
    private String address;
    /**
     * 	否 	string 	经度
     */
    private String longitude ;
    /**
     * 否 	string 	维度
     */
    private String latitude ;
    /**
     * 创建时间  是
     */
    private Date createTime;

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getOpcName() {
        return opcName;
    }

    public void setOpcName(String opcName) {
        this.opcName = opcName;
    }

    public String getSupplierEnterPhone() {
        return supplierEnterPhone;
    }

    public void setSupplierEnterPhone(String supplierEnterPhone) {
        this.supplierEnterPhone = supplierEnterPhone;
    }

    public String getAgentEnterPhone() {
        return agentEnterPhone;
    }

    public void setAgentEnterPhone(String agentEnterPhone) {
        this.agentEnterPhone = agentEnterPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
