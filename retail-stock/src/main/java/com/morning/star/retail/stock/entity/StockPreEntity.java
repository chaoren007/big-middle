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
 * 库存预占
 *
 * @author jiangyf
 */
@Table(name = "retail_stock_pre")
@Where(clause = "delete_flag <> 1")
@Entity
public class StockPreEntity extends BaseEntity {
    private static final long serialVersionUID = 5935218065854247108L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("集团编码")
    @Column(length = 32, nullable = false)
    private String groupode;

    @Comment("门店编码")
    @Column(length = 32, nullable = false)
    private String storeCode;

    @Comment("货品编码")
    @Column(length = 32, nullable = false)
    private String productCode;

    @Comment("货品名称")
    @Column(length = 200, nullable = false)
    private String productName;

    @Comment("商品编码")
    @Column(length = 32, nullable = false)
    private String goodsCode;

    @Comment("条形码")
    @Column
    private String upcCode;

    @Comment("订单编码")
    @Column(length = 32, nullable = false)
    private String orderCode;

    @Comment("预占数量")
    @Column(nullable = false)
    private BigDecimal num;

    @Comment("预占状态（0：初始化；1：确认；2：取消；3：结束）")
    @Column(nullable = false)
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupode() {
        return groupode;
    }

    public void setGroupode(String groupode) {
        this.groupode = groupode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}