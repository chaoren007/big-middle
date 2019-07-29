package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 一次性回测dto
 */
@ApiModel
public class AllWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "分类")
    @NotNull(message = "分类不能为空")
    @Valid
    private CategoryWmsDTO categoryWmsDTO;

    @ApiModelProperty(required = true, value = "商品")
    @NotNull(message = "商品不能为空")
    @Valid
    private GoodsWmsDTO goodsWmsDTO;

    @ApiModelProperty(required = true, value = "仓库")
    @NotNull(message = "仓库不能为空")
    @Valid
    private StorageWmsDTO storageWmsDTO;

    @ApiModelProperty(required = true, value = "分公司")
    @NotNull(message = "分公司不能为空")
    @Valid
    private StoreWmsDTO storeWmsDTO;

    @ApiModelProperty(required = true, value = "供应商")
    @NotNull(message = "供应商不能为空")
    @Valid
    private SupplierWmsDTO supplierWmsDTO;

    @ApiModelProperty(required = true, value = "（推送类型：3-其他入库单接口，2-其他出库单接口,1-移库单接口）")
    @NotNull(message = "（推送类型：3-其他入库单接口，2-其他出库单接口,1-移库单接口）不能为空")
    @Valid
    private MoveStockWmsDTO moveStockWmsDTO;

    @ApiModelProperty(required = true, value = "（推送类型：S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）")
    @NotNull(message = "（推送类型：S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）不能为空")
    @Valid
    private OutStockWmsDTO outStockWmsDTO;

    @ApiModelProperty(required = true, value = "（推送类型：P1-采购退单,PO-采购入库单）")
    @NotNull(message = "（推送类型：P1-采购退单,PO-采购入库单）不能为空")
    @Valid
    private PurchaseWmsDTO purchaseWmsDTO;

    public CategoryWmsDTO getCategoryWmsDTO() {
        return categoryWmsDTO;
    }

    public void setCategoryWmsDTO(CategoryWmsDTO categoryWmsDTO) {
        this.categoryWmsDTO = categoryWmsDTO;
    }

    public GoodsWmsDTO getGoodsWmsDTO() {
        return goodsWmsDTO;
    }

    public void setGoodsWmsDTO(GoodsWmsDTO goodsWmsDTO) {
        this.goodsWmsDTO = goodsWmsDTO;
    }

    public StorageWmsDTO getStorageWmsDTO() {
        return storageWmsDTO;
    }

    public void setStorageWmsDTO(StorageWmsDTO storageWmsDTO) {
        this.storageWmsDTO = storageWmsDTO;
    }

    public StoreWmsDTO getStoreWmsDTO() {
        return storeWmsDTO;
    }

    public void setStoreWmsDTO(StoreWmsDTO storeWmsDTO) {
        this.storeWmsDTO = storeWmsDTO;
    }

    public SupplierWmsDTO getSupplierWmsDTO() {
        return supplierWmsDTO;
    }

    public void setSupplierWmsDTO(SupplierWmsDTO supplierWmsDTO) {
        this.supplierWmsDTO = supplierWmsDTO;
    }

    public MoveStockWmsDTO getMoveStockWmsDTO() {
        return moveStockWmsDTO;
    }

    public void setMoveStockWmsDTO(MoveStockWmsDTO moveStockWmsDTO) {
        this.moveStockWmsDTO = moveStockWmsDTO;
    }

    public OutStockWmsDTO getOutStockWmsDTO() {
        return outStockWmsDTO;
    }

    public void setOutStockWmsDTO(OutStockWmsDTO outStockWmsDTO) {
        this.outStockWmsDTO = outStockWmsDTO;
    }

    public PurchaseWmsDTO getPurchaseWmsDTO() {
        return purchaseWmsDTO;
    }

    public void setPurchaseWmsDTO(PurchaseWmsDTO purchaseWmsDTO) {
        this.purchaseWmsDTO = purchaseWmsDTO;
    }
}
