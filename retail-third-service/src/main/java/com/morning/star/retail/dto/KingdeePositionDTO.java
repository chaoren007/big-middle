package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 岗位
 */
public class KingdeePositionDTO {

    /**
     * Model : {"FName":"岗位1","FDept":{"FNumber":"BM000001"},"FEffectDate":"2018-12-26 00:00:00","FLapseDate":"2018-12-27 00:00:00","FHRPostSubHead":{"FLEADERPOST":false}}
     */

    @JSONField(name = "Model")
    private ModelBean model;

    /**
     *
     * @param fName 岗位名称
     * @param fEffectDate 开始时间
     * @param fLapseDate 失效时间
     * @param fleaderpost 是否负责人岗位
     */
    public KingdeePositionDTO(String fName,String fEffectDate,String fLapseDate,boolean fleaderpost){
        this.model = new ModelBean(fName,fEffectDate,fLapseDate,fleaderpost);
    }
    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean {
        /**
         * FName : 岗位1
         * FDept : {"FNumber":"BM000001"}
         * FEffectDate : 2018-12-26 00:00:00
         * FLapseDate : 2018-12-27 00:00:00
         * FHRPostSubHead : {"FLEADERPOST":false}
         *
         * Model : {"FName":"岗位1","FDept":{"FNumber":"BM000001"},"FEffectDate":"2018-12-26 00:00:00","FLapseDate":"2018-12-27 00:00:00","FHRPostSubHead":{"FLEADERPOST":false}}
         */
        /**
         * 岗位名称
         */
        private ModelBean(String fName,String fEffectDate,String fLapseDate,boolean fleaderpost){
            this.fname = fName ;
            this.fdept = new FDeptBean();
            this.feffectDate = fEffectDate ;
            this.flapseDate = fLapseDate ;
            this.fHRPostSubHead = new FHRPostSubHeadBean(fleaderpost);
        }
        @JSONField(ordinal = 1 ,name = "FName")
        private String fname;
        /**
         * 所属部门 默认长沙分公司
         */
        @JSONField(ordinal = 2 ,name = "FDept")
        private FDeptBean fdept;
        /**
         * 生效日期
         */
        @JSONField(ordinal = 3 ,name = "FEffectDate")
        private String feffectDate;
        /**
         * 失效日期
         */
        @JSONField(ordinal = 4 ,name = "FLapseDate")
        private String flapseDate;

        /**
         * 是否负责人岗位
         */
        @JSONField(ordinal = 5 ,name = "FHRPostSubHead")
        private FHRPostSubHeadBean fHRPostSubHead;

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public FDeptBean getFdept() {
            return fdept;
        }

        public void setFdept(FDeptBean fdept) {
            this.fdept = fdept;
        }

        public String getFeffectDate() {
            return feffectDate;
        }

        public void setFeffectDate(String feffectDate) {
            this.feffectDate = feffectDate;
        }

        public String getFlapseDate() {
            return flapseDate;
        }

        public void setFlapseDate(String flapseDate) {
            this.flapseDate = flapseDate;
        }

        public FHRPostSubHeadBean getfHRPostSubHead() {
            return fHRPostSubHead;
        }

        public void setfHRPostSubHead(FHRPostSubHeadBean fHRPostSubHead) {
            this.fHRPostSubHead = fHRPostSubHead;
        }

        public static class FDeptBean {
            /**
             * FNumber : BM000001
             */
            @JSONField(name = "FNumber")
            private String fnumber;

            private FDeptBean(){
                this.fnumber = "BM000001";
            }

            public String getFnumber() {
                return fnumber;
            }

            public void setFnumber(String fnumber) {
                this.fnumber = fnumber;
            }
        }

        public static class FHRPostSubHeadBean {
            /**
             * FLEADERPOST : false
             */
            @JSONField(name = "FLEADERPOST")
            private boolean FLEADERPOST;

            private FHRPostSubHeadBean(boolean fleaderpost){
                this.FLEADERPOST = fleaderpost;
            }
            public boolean isFLEADERPOST() {
                return FLEADERPOST;
            }

            public void setFLEADERPOST(boolean FLEADERPOST) {
                this.FLEADERPOST = FLEADERPOST;
            }
        }
    }
}


