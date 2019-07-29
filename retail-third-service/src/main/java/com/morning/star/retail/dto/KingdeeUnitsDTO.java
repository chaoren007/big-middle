package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class KingdeeUnitsDTO {


    /**
     * Model : {"FName":"111","FUnitGroupId":{"FNumber":"ZU"},"FRoundType":"1","SubHeadEntity":{"FCreateDate1":"2018-12-18 14:03:43"}}
     */

    @JSONField(name="Model")
    private ModelBean model;

    public KingdeeUnitsDTO(String unitsName) {
        this.model = new ModelBean(unitsName);
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean {
        /**
         * FName : 111
         * FUnitGroupId : {"FNumber":"ZU"}
         * FRoundType : 1
         * SubHeadEntity : {"FCreateDate1":"2018-12-18 14:03:43"}
         */
        @JSONField(name="FName")
        private String fname;
        @JSONField(name="FUnitGroupId")
        private FUnitGroupIdBean funitGroupId;
        @JSONField(name="FroundType")
        private String froundType;

        private ModelBean(String Fname) {
            this.funitGroupId = new FUnitGroupIdBean();
            this.fname = Fname;
            this.froundType = "1";
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public FUnitGroupIdBean getFunitGroupId() {
            return funitGroupId;
        }

        public void setFunitGroupId(FUnitGroupIdBean funitGroupId) {
            this.funitGroupId = funitGroupId;
        }

        public String getFroundType() {
            return froundType;
        }

        public void setFroundType(String froundType) {
            this.froundType = froundType;
        }

        public static class FUnitGroupIdBean {
            /**
             * FNumber : ZU
             */
            @JSONField(name="FNumber")
            private String fnumber;

            private FUnitGroupIdBean() {
                this.fnumber = "ZU";
            }

            public String getFnumber() {
                return fnumber;
            }

            public void setFnumber(String fnumber) {
                this.fnumber = fnumber;
            }
        }
    }
}
