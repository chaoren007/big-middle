package com.morning.star.retail.stock.entity;

import com.morning.star.retail.stock.enums.ReplenishStatus;
import com.morning.star.retail.stock.enums.ReplenishType;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "retail_replenish")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReplenishEntity extends BaseEntity {
    private static final long serialVersionUID = 1111320370190733556L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("补货单编码")
    @Column(length = 64, unique = true, updatable = false)
    private String replenishCode;

    @Column
    @Comment("城市id")
    private Long cityId;

    @Column(length = 16)
    @Comment("城市名称")
    private String cityName;

    @Column(length = 64)
    @Comment(value = "门店编码")
    private String storeCode;

    @Column(length = 64)
    @Comment(value = "门店名称")
    private String storeName;

    @Column(length = 64)
    @Comment(value = "集团编码")
    private String groupCode;

    @Column(length = 64)
    @Comment(value = "集团名称")
    private String groupName;

    @Comment("物流编码")
    @Column(length = 64)
    private String deliveryCode;

    @Comment("补货单类型 0：门店申请补货，1：总部主动补货")
    @Column(length = 2)
    @Convert(converter = ReplenishType.ReplenishTypeConverter.class)
    private ReplenishType type;

    @Comment("补货状态（0：待确认，1：已确认，2：驳回）")
    @Column(length = 2)
    @Convert(converter = ReplenishStatus.ReplenishStatusConverter.class)
    private ReplenishStatus status;

    @Comment("审核时间")
    @Column
    private Date authTime;

    @Comment("备注")
    @Column
    private String remark;

    @Comment("补货仓库编码集")
    @Column
    private String warehouseCodes;

    @Comment("补货仓库名称集")
    @Column
    private String warehouseNames;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "replenishCode", referencedColumnName = "replenishCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private List<ReplenishItemEntity> detailEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplenishCode() {
        return replenishCode;
    }

    public void setReplenishCode(String replenishCode) {
        this.replenishCode = replenishCode;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

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

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public ReplenishType getType() {
        return type;
    }

    public void setType(ReplenishType type) {
        this.type = type;
    }

    public ReplenishStatus getStatus() {
        return status;
    }

    public void setStatus(ReplenishStatus status) {
        this.status = status;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouseCodes() {
        return warehouseCodes;
    }

    public void setWarehouseCodes(String warehouseCodes) {
        this.warehouseCodes = warehouseCodes;
    }

    public String getWarehouseNames() {
        return warehouseNames;
    }

    public void setWarehouseNames(String warehouseNames) {
        this.warehouseNames = warehouseNames;
    }

    public List<ReplenishItemEntity> getDetailEntityList() {
        return detailEntityList;
    }

    public void setDetailEntityList(List<ReplenishItemEntity> detailEntityList) {
        this.detailEntityList = detailEntityList;
    }
}
