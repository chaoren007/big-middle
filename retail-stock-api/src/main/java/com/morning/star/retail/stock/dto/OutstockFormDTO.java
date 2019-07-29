package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.util.List;

import com.morning.star.retail.bean.AdminLoginContent;

import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutstockFormDTO implements Serializable {
    private static final long serialVersionUID = 5708018644854459788L;
    /**
     * 出库单号
     */
    @ApiModelProperty(required=true,value="出库单号")
    private String outstockCode;
    /**
     * 调入门店编码
     */
    @ApiModelProperty(value="调入方编码")
    private String receiverCode;
    /**
     * 调入门店名称
     */
    @ApiModelProperty(value="调入方名称")
    private String receiverName;
    /**
     * 调出门店编码
     */
    @ApiModelProperty(value="调出方编码")
    private String senderCode;
    /**
     * 调出门店名称
     */    
    @ApiModelProperty(value="调出方名称")
    private String senderName;
    private String groupCode;
    /**
     * 出库类型（0：其他，1：调拨出库）
     */
    @ApiModelProperty(required=true,value="出库类型  0：其他， 1：调拨出库   2：退货出库")
    private Integer type;
    /**
     * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、出库
     */
    @ApiModelProperty(required=true,value="审核状态：0、草稿   10、待审核    20、已审核   30、驳回   40、出库")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 退货出库时对应的入库单号
     */
    @ApiModelProperty(value="退货出库时对应的入库单号")
    private String instockCode;
    /**
     * 出库商品
     */
    @ApiModelProperty(required=true,value="出库单明细")
    private List<OutstockOrderDetailDTO> outstockOrderDetailDTO;

    
    
   
	public String getInstockCode() {
		return instockCode;
	}

	public void setInstockCode(String instockCode) {
		this.instockCode = instockCode;
	}

	public static OutstockFormDTO supply(OutstockFormDTO formDTO, AdminLoginContent content) {
        formDTO.setSenderCode(content.getStoreCode());
        formDTO.setSenderName(content.getStoreName());
        formDTO.setGroupCode(content.getGroupCode());
        return formDTO;
    }

    public String getOutstockCode() {
        return outstockCode;
    }

    public void setOutstockCode(String outstockCode) {
        this.outstockCode = outstockCode;
    }



   

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public List<OutstockOrderDetailDTO> getOutstockOrderDetailDTO() {
		return outstockOrderDetailDTO;
	}

	public void setOutstockOrderDetailDTO(List<OutstockOrderDetailDTO> outstockOrderDetailDTO) {
		this.outstockOrderDetailDTO = outstockOrderDetailDTO;
	}

	
   
}
