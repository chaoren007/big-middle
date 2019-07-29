package com.morning.star.retail.dto;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * 税种
 */
public class KingdeeTaxCategoryDTO {


    /**
     * Model : {"FName":"1","FTaxSystemID":{"FNumber":"SSZD01_SYS"},"FTempCountry":{"FNumber":"China"},"FTaxPrecise":2,"FRoundRule":"1","FStartDate":"2018-12-24 00:00:00","FEndDate":"9999-12-31 00:00:00","FIsModifyTaxRate":false,"FIsModifyAndRecordTax":false}
     */

    @JSONField(name = "Model")
    private ModelBean model;

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public KingdeeTaxCategoryDTO(String fName,String fStartDate ,String fEndDate){
        this.model = new ModelBean(fName,fStartDate,fEndDate);
    }
    public static class ModelBean {
        /**
         * FName : 1
         * FTaxSystemID : {"FNumber":"SSZD01_SYS"}
         * FTaxPrecise : 2
         * FRoundRule : 1
         * FStartDate : 2018-12-24 00:00:00
         * FEndDate : 9999-12-31 00:00:00
         * FIsModifyTaxRate : false
         * FIsModifyAndRecordTax : false
         */
        private ModelBean(String fName,String fStartDate ,String fEndDate){
            this.fname = fName;
            this.ftaxSystemID = new FTaxSystemIDBean();
            this.ftaxPrecise = 2;
            this.froundRule = "1";
            this.fstartDate = fStartDate;
            this.fendDate = fEndDate;
            this.fisModifyTaxRate = false;
            this.fisModifyAndRecordTax = false;
        }

        /**
         * 名称
         */
        @JSONField(name = "FName")
        private String fname;
        /**
         * 税收制度
         */
        @JSONField(name = "FTaxSystemID")
        private FTaxSystemIDBean ftaxSystemID;
        /**
         * 税额精确度
         */
        @JSONField(name = "FTaxPrecise")
        private int ftaxPrecise;
        /**
         * 舍入规则
         */
        @JSONField(name = "FRoundRule")
        private String froundRule;
        /**
         * 生效日期
         */
        @JSONField(name = "FStartDate")
        private String fstartDate;
        /**
         * 失效日期
         */
        @JSONField(name = "FEndDate")
        private String fendDate;
        /**
         * 允许改写税率
         */
        @JSONField(name = "FIsModifyTaxRate")
        private boolean fisModifyTaxRate;
        /**
         * 允许改写和录入税额
         */
        @JSONField(name = "FIsModifyAndRecordTax")
        private boolean fisModifyAndRecordTax;

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public FTaxSystemIDBean getFtaxSystemID() {
            return ftaxSystemID;
        }

        public void setFtaxSystemID(FTaxSystemIDBean ftaxSystemID) {
            this.ftaxSystemID = ftaxSystemID;
        }

        public int getFtaxPrecise() {
            return ftaxPrecise;
        }

        public void setFtaxPrecise(int ftaxPrecise) {
            this.ftaxPrecise = ftaxPrecise;
        }

        public String getFroundRule() {
            return froundRule;
        }

        public void setFroundRule(String froundRule) {
            this.froundRule = froundRule;
        }

        public String getFstartDate() {
            return fstartDate;
        }

        public void setFstartDate(String fstartDate) {
            this.fstartDate = fstartDate;
        }

        public String getFendDate() {
            return fendDate;
        }

        public void setFendDate(String fendDate) {
            this.fendDate = fendDate;
        }

        public boolean isFisModifyTaxRate() {
            return fisModifyTaxRate;
        }

        public void setFisModifyTaxRate(boolean fisModifyTaxRate) {
            this.fisModifyTaxRate = fisModifyTaxRate;
        }

        public boolean isFisModifyAndRecordTax() {
            return fisModifyAndRecordTax;
        }

        public void setFisModifyAndRecordTax(boolean fisModifyAndRecordTax) {
            this.fisModifyAndRecordTax = fisModifyAndRecordTax;
        }

        public static class FTaxSystemIDBean {
            /**
             * FNumber : SSZD01_SYS
             */
            private FTaxSystemIDBean(){
                this.fnumber = "SSZD01_SYS";
            }
            @JSONField(name = "FNumber")
            private String fnumber;

            public String getFnumber() {
                return fnumber;
            }

            public void setFnumber(String fnumber) {
                this.fnumber = fnumber;
            }
        }
    }
}
