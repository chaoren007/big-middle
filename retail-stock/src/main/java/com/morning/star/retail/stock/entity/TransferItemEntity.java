package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 调拨单明细
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@Comment("调拨单明细")
@Entity
@Table(name = "retail_transfer_item")
@Where(clause = "delete_flag <> 1")
public class TransferItemEntity extends BaseEntity {
    private static final long serialVersionUID = -8486923471118173785L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("调拨单号")
    @Column(length = 32, nullable = false, updatable = false)
    private String transferCode;

    @Comment("集团编码")
    @Column(length = 32, nullable = false)
    private String groupCode;

    @Comment("货品编码")
    @Column(length = 32, nullable = false)
    private String productCode;

    @Comment("货品名称")
    @Column(length = 200, nullable = false)
    private String productName;

    @Comment(value = "SAP货品编码")
    @Column(length = 32, nullable = false)
    private String sapProductCode;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("upc")
    @Column
    private String upcCode;

    @Comment("调拨数量")
    @Column(nullable = false)
    private BigDecimal num;

    @Comment("单位")
    @Column(nullable = false)
    private String unitsName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }
}
