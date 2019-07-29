package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;

/**
 * Item VO of Response.
 * 
 * @author Tim
 *
 */
public class SalesOrderItemVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String image;
    private Integer buyNum;
   
    private BigDecimal unitPrice = BigDecimal.ZERO;			//商品销售单价
    private BigDecimal originalPrice = BigDecimal.ZERO;    	//商品原售单价
    private BigDecimal realPrice = BigDecimal.ZERO;    		//订单项除去预付卡跟优惠的第三方总支付金额
    private BigDecimal discountAmount = BigDecimal.ZERO;	//订单项总优惠价格		
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//订单项总预付卡金额
    private BigDecimal originalAmount = BigDecimal.ZERO;    //优惠前总金额

    private Date createTime;
    private Date modifyTime;
    
    
    private String unit;
    
    private BigDecimal weight;			//重量
    
    /**
     * upc商品编码
     */
    private String upcCode;

    /**
     * 货品规格
     */
    private String specInfo;
    

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}
	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public BigDecimal getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    public Integer getBuyNum() {
        return buyNum;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
	public String getUpcCode() {
		return upcCode;
	}
	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public static List<SalesOrderItemVO> toVOList(List<OrderGoodsItemDTO> items) {
        if(items == null || items.isEmpty()) {
            return Collections.emptyList();
        }
        return items.stream().map(e -> toVO(e)).collect(Collectors.toList());
    }
    public static SalesOrderItemVO toVO(OrderGoodsItemDTO dto) {
        SalesOrderItemVO vo = new SalesOrderItemVO();
        BeanUtils.copyProperties(dto, vo);
        return vo;
    }
    
}
