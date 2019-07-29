package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 税率
 */
public class KingdeeTaxRateDTO {


    @JSONField(name = "Model")
    private ModelBean model;

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public KingdeeTaxRateDTO(String fName, Integer fTaxRate, String fEffectiveDate, String fExpiryDate, String fMakeVatInvoice){
        this.model=new ModelBean(fName,fTaxRate,fEffectiveDate,fExpiryDate,fMakeVatInvoice);
    }

    public static class ModelBean {

        /**
         * FName : 1
         * FTaxatiionSystem : {"FNumber":"SSZD01_SYS"}
         * FTaxType : {"FNumber":"SZ01_SYS"}
         * FMakeVatInvoice : 1
         * FEffectiveDate : 2018-12-24 00:00:00
         * FExpiryDate : 2018-12-31 00:00:00
         * FIsVat : false
         * FSellerWithHold : true
         * FBuyerWithHold : false
         *
         * Model : {"FName":"1","FTaxatiionSystem":{"FNumber":"SSZD01_SYS"},"FTaxType":{"FNumber":"SZ01_SYS"},"FMakeVatInvoice":"1","FDefaultCost":{"FNumber":"FYXM02_SYS"},"FEffectiveDate":"2018-12-24 00:00:00","FExpiryDate":"2018-12-31 00:00:00","FIsVat":false,"FSellerWithHold":true,"FBuyerWithHold":false}
         */

        /**
         * 税率名称
         */
        @JSONField(ordinal = 0 ,name = "FName")
        private String fname;
        /**
         * 税收制度
         */
        @JSONField(ordinal = 1 , name = "FTaxatiionSystem")
        private FTaxatiionSystemBean ftaxatiionSystem;

        /**
         * 税种
         */
        @JSONField(ordinal = 2 , name = "FTaxType")
        private FTaxTypeBean ftaxType;

        /**
         * 开增值税发票
         */
        @JSONField(ordinal = 3 , name = "FMakeVatInvoice")
        private String fmakeVatInvoice;


        /**
         * 生效日期 2018-12-24
         */
        @JSONField(ordinal = 4 , name = "FEffectiveDate")
        private String feffectiveDate;


        /**
         * 失效日期 2018-12-24
         */
        @JSONField(ordinal = 5 , name = "FExpiryDate")
        private String fexpiryDate;

        /**
         * 税率
         */
        @JSONField(ordinal = 6 , name = "FTaxRate")
        private Integer ftaxRate;

        /**
         * 增值税
         */
        @JSONField(ordinal = 7 , name = "FIsVat")
        private boolean fisVat;

        /**
         * 卖方代扣代缴
         */
        @JSONField(ordinal = 8 , name = "FSellerWithHold")
        private boolean fsellerWithHold;

        /**
         * 买方代扣代缴
         */
        @JSONField(ordinal = 9 , name = "FBuyerWithHold")
        private boolean fbuyerWithHold;

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public Integer getFtaxRate() {
            return ftaxRate;
        }

        public void setFtaxRate(Integer ftaxRate) {
            this.ftaxRate = ftaxRate;
        }

        public FTaxatiionSystemBean getFtaxatiionSystem() {
            return ftaxatiionSystem;
        }

        public void setFtaxatiionSystem(FTaxatiionSystemBean ftaxatiionSystem) {
            this.ftaxatiionSystem = ftaxatiionSystem;
        }

        public FTaxTypeBean getFtaxType() {
            return ftaxType;
        }

        public void setFtaxType(FTaxTypeBean ftaxType) {
            this.ftaxType = ftaxType;
        }

        public String getFmakeVatInvoice() {
            return fmakeVatInvoice;
        }

        public void setFmakeVatInvoice(String fmakeVatInvoice) {
            this.fmakeVatInvoice = fmakeVatInvoice;
        }

        public String getFeffectiveDate() {
            return feffectiveDate;
        }

        public void setFeffectiveDate(String feffectiveDate) {
            this.feffectiveDate = feffectiveDate;
        }

        public String getFexpiryDate() {
            return fexpiryDate;
        }

        public void setFexpiryDate(String fexpiryDate) {
            this.fexpiryDate = fexpiryDate;
        }

        public boolean isFisVat() {
            return fisVat;
        }

        public void setFisVat(boolean fisVat) {
            this.fisVat = fisVat;
        }

        public boolean isFsellerWithHold() {
            return fsellerWithHold;
        }

        public void setFsellerWithHold(boolean fsellerWithHold) {
            this.fsellerWithHold = fsellerWithHold;
        }

        public boolean isFbuyerWithHold() {
            return fbuyerWithHold;
        }

        public void setFbuyerWithHold(boolean fbuyerWithHold) {
            this.fbuyerWithHold = fbuyerWithHold;
        }

        private ModelBean(String fName, Integer fTaxRate, String fEffectiveDate, String fExpiryDate, String fMakeVatInvoice){
            this.fname=fName;
            this.ftaxRate = fTaxRate;
            this.ftaxatiionSystem = new FTaxatiionSystemBean();
            this.ftaxType = new FTaxTypeBean();
            this.fmakeVatInvoice = fMakeVatInvoice;
            this.feffectiveDate = fEffectiveDate;
            this.fexpiryDate = fExpiryDate;
            this.fisVat = false;
            this.fsellerWithHold = true;
            this.fbuyerWithHold = false;
        }

        public static class FTaxatiionSystemBean {

            /**
             * 税收制度 编码 FNumber : SSZD01_SYS
             */
            @JSONField(name = "FNumber")
            private String fnumber;

            public String getFnumber() {
                return fnumber;
            }

            public void setFnumber(String fnumber) {
                this.fnumber = fnumber;
            }

            private FTaxatiionSystemBean(){
                this.fnumber = "SSZD01_SYS";
            }
        }

        public static class FTaxTypeBean {

            /**
             * 税种编码 FNumber : SZ01_SYS
             */

            @JSONField(name = "FNumber")
            private String fnumber;

            public String getFnumber() {
                return fnumber;
            }

            public void setFnumber(String fnumber) {
                this.fnumber = fnumber;
            }

            private FTaxTypeBean(){
                this.fnumber = "SZ01_SYS";
            }
        }
    }
}
