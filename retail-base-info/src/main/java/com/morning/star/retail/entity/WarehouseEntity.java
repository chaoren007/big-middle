package com.morning.star.retail.entity;

import com.morning.star.retail.facade.dto.StorageWmsDTO;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_store_warehouse")
@Where(clause = "delete_flag <> 1")
public class WarehouseEntity extends BaseEntity {

    private static final long serialVersionUID = -2415654623413404712L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("分部编码")
    @Column(length = 64, nullable = true)
    private String storeCode;
    @Comment("集团编码")
    @Column(length = 64, nullable = true)
    private String groupCode;

    @Comment("仓库名称")
    @Column(length = 128, nullable = false)
    private String warehouseName;

    @Comment("城市")
    @Column(length = 11, nullable = false)
    private String city;


    @Comment("城市ID")
    @Column(length = 20, nullable = false)
    private Long cityId;

    @Comment("仓库编码")
    @Column(length = 128, nullable = false)
    private String warehouseCode;

    @Comment("仓库地址")
    @Column(length = 128, nullable = false)
    private String warehouseAddress;

    @Comment("负责人")
    @Column(length = 128, nullable = false)
    private String createName;

    @Comment("电话号码")
    @Column(length = 128, nullable = false)
    private String tel;

    @Comment("备注")
    @Column(length = 128)
    private String remark;


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static StorageWmsDTO toWmsDTO(WarehouseEntity entity) {
        if(entity == null) {
            return null;
        }
        StorageWmsDTO wms = new StorageWmsDTO();
        wms.setWarehouseCode(entity.getWarehouseCode());
        wms.setWarehouseName(entity.getWarehouseName());
        wms.setStoreCode(entity.getStoreCode());
        wms.setCityId(entity.getCityId());
        wms.setCityName(entity.getCity());

        return wms;
    }

}
