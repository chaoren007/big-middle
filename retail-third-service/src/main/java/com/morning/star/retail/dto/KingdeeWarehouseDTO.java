package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 岗位
 */
public class KingdeeWarehouseDTO {


    /**
     * Model : {"FName":"湖南仓","FStockProperty":"1","FStockStatusType":"0,1,2,3,4,5,6,7,8","FAllowMinusQty":false,"FAllowLock":false,"FIsOpenLocation":false,"FAllowMRPPlan":false,"FAvailablePicking":false,"FAvailableAlert":false,"FSortingPriority":1}
     */
    @JSONField(name = "Model")
    private ModelBean model;

    /**
     * @param fName 仓库名称
     * @param fAllowMinusQty 是否允许负库存
     */
    public KingdeeWarehouseDTO(String fName, boolean fAllowMinusQty) {
        this.model = new ModelBean(fName, fAllowMinusQty);
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean Model) {
        this.model = Model;
    }

    public static class ModelBean {
        /**
         * FName : 湖南仓
         * FStockProperty : 1
         * FStockStatusType : 0,1,2,3,4,5,6,7,8
         * FAllowMinusQty : false
         * FAllowLock : false
         * FIsOpenLocation : false
         */
        private ModelBean(String fName, boolean fAllowMinusQty) {
            this.fname = fName ;
            this.fstockProperty = "1";
            this.fstockStatusType = "0,1,2,3,4,5,6,7,8";
            this.fallowMinusQty = fAllowMinusQty ;
            this.fallowLock = false;
            this.fisOpenLocation = false;
        }

        /**
         * 仓库名称
         */
        @JSONField(name = "FName")
        private String fname;

        /**
         * 仓库属性 1普通仓库
         */
        @JSONField(name = "FStockProperty")
        private String fstockProperty;

        /**
         * 0可用 1待检 2冻结 3退回冻结 4在途 5收货冻结 6废品 7不良 8不参与核算
         */
        @JSONField(name = "FStockProperty")
        private String fstockStatusType;

        /**
         * 允许负库存
         */
        @JSONField(name = "FAllowMinusQty")
        private boolean fallowMinusQty;
        /**
         * 允许锁库
         */
        @JSONField(name = "FAllowLock")
        private boolean fallowLock;
        /**
         * 启用仓位管理
         */
        @JSONField(name = "FIsOpenLocation")
        private boolean fisOpenLocation;


        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getFstockProperty() {
            return fstockProperty;
        }

        public void setFstockProperty(String fstockProperty) {
            this.fstockProperty = fstockProperty;
        }

        public String getFstockStatusType() {
            return fstockStatusType;
        }

        public void setFstockStatusType(String fstockStatusType) {
            this.fstockStatusType = fstockStatusType;
        }

        public boolean isFallowMinusQty() {
            return fallowMinusQty;
        }

        public void setFallowMinusQty(boolean fallowMinusQty) {
            this.fallowMinusQty = fallowMinusQty;
        }

        public boolean isFallowLock() {
            return fallowLock;
        }

        public void setFallowLock(boolean fallowLock) {
            this.fallowLock = fallowLock;
        }

        public boolean isFisOpenLocation() {
            return fisOpenLocation;
        }

        public void setFisOpenLocation(boolean fisOpenLocation) {
            this.fisOpenLocation = fisOpenLocation;
        }
    }
}
