package com.morning.star.retail.admin.goods.vo;

import java.math.BigDecimal;

/**
 * Created by liangguobin on 2017/6/3.
 */
public class GoodsPackSpecVO {
    private String type;

    private String goodsPackSpec;

    private String goodsCode;

    private String imgPaths;
    private String iconPath;
    private String spuCode;
    private BigDecimal guidePrice;
    private String weight;
    private Integer status;

    private Integer isSelect;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGoodsPackSpec() {
        return goodsPackSpec;
    }

    public void setGoodsPackSpec(String goodsPackSpec) {
        this.goodsPackSpec = goodsPackSpec;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String imgPaths) {
        this.imgPaths = imgPaths;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }
}
