package com.morning.star.retail.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 物料
 */
public class KingdeeMaterielDTO {

    /**
     * Model : {"FName":"BBB","FImgStorageType":"B","SubHeadEntity":{"FErpClsID":"1","FCategoryID":{"FNumber":"CHLB01_SYS"},"FTaxType":{"FNumber":"WLDSFL01_SYS"},"FTaxRateId":{"FNUMBER":"SL31_SYS"},"FBaseUnitId":{"FNumber":"Pcs"},"FIsPurchase":true,"FIsInventory":true,"FIsSubContract":false,"FIsSale":true,"FIsProduce":false,"FIsAsset":false,"FWEIGHTUNITID":{"FNUMBER":"kg"},"FVOLUMEUNITID":{"FNUMBER":"m"}},"SubHeadEntity1":{"FStoreUnitID":{"FNumber":"Pcs"},"FUnitConvertDir":"1","FIsLockStock":true,"FIsCycleCounting":false,"FCountCycle":"1","FCountDay":1,"FIsMustCounting":false,"FIsBatchManage":false,"FIsKFPeriod":false,"FIsExpParToFlot":false,"FCurrencyId":{"FNumber":"PRE001"},"FIsEnableMinStock":false,"FIsEnableMaxStock":false,"FIsEnableSafeStock":false,"FIsEnableReOrder":false,"FIsSNManage":false,"FIsSNPRDTracy":false,"FSNManageType":"1","FSNGenerateTime":"1"},"SubHeadEntity2":{"FSaleUnitId":{"FNumber":"Pcs"},"FSalePriceUnitId":{"FNumber":"Pcs"},"FMaxQty":100000,"FIsATPCheck":false,"FIsReturnPart":false,"FIsInvoice":false,"FIsReturn":true,"FAllowPublish":false,"FISAFTERSALE":true,"FISPRODUCTFILES":true,"FISWARRANTED":false,"FWARRANTYUNITID":"D","FOutLmtUnit":"SAL","FIsTaxEnjoy":false},"SubHeadEntity3":{"FPurchaseUnitId":{"FNumber":"Pcs"},"FPurchasePriceUnitId":{"FNumber":"Pcs"},"FIsQuota":false,"FQuotaType":"1","FIsVmiBusiness":false,"FEnableSL":false,"FIsPR":false,"FIsReturnMaterial":true,"FIsSourceControl":false,"FPOBillTypeId":{"FNUMBER":"CGSQD01_SYS"},"FPrintCount":1,"FMinPackCount":1},"SubHeadEntity4":{"FPlanningStrategy":"1","FMfgPolicyId":{"FNumber":"ZZCL001_SYS"},"FFixLeadTimeType":"1","FVarLeadTimeType":"1","FCheckLeadTimeType":"1","FOrderIntervalTimeType":"3","FMaxPOQty":100000,"FEOQ":1,"FVarLeadTimeLotSize":1,"FIsMrpComReq":false,"FReserveType":"1","FAllowPartAhead":false,"FCanDelayDays":999,"FAllowPartDelay":true,"FPlanOffsetTimeType":"1"},"SubHeadEntity5":{"FProduceUnitId":{"FNumber":"Pcs"},"FProduceBillType":{"FNUMBER":"SCDD03_SYS"},"FOrgTrustBillType":{"FNUMBER":"SCDD06_SYS"},"FIsSNCarryToParent":false,"FIsProductLine":false,"FBOMUnitId":{"FNumber":"Pcs"},"FIsMainPrd":false,"FIsCoby":false,"FIsECN":false,"FIssueType":"1","FOverControlMode":"1","FMinIssueQty":1,"FISMinIssueQty":false,"FIsKitting":false,"FIsCompleteSet":false,"FMinIssueUnitId":{"FNUMBER":"Pcs"},"FStandHourUnitId":"3600","FBackFlushType":"1"},"SubHeadEntity7":{"FSubconUnitId":{"FNumber":"Pcs"},"FSubconPriceUnitId":{"FNumber":"Pcs"},"FSubBillType":{"FNUMBER":"WWDD01_SYS"}},"SubHeadEntity6":{"FCheckIncoming":false,"FCheckProduct":false,"FCheckStock":false,"FCheckReturn":false,"FCheckDelivery":false,"FEnableCyclistQCSTK":false,"FEnableCyclistQCSTKEW":false,"FCheckEntrusted":false,"FCheckOther":false},"FEntityInvPty":[{"FInvPtyId":{"FNumber":"01"},"FIsEnable":true,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"02"},"FIsEnable":true,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"03"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"04"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"06"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false}]}
     */

    @JSONField(name = "Model")
    private ModelBean model;

    /**
     * @param fname         物料名称
     * @param unitsNumber   单位编码
     * @param taxRateNumber 税率编码
     * @param taxTypeNumber 税种编码
     */
    public KingdeeMaterielDTO(String fname, String unitsNumber, String taxRateNumber, String taxTypeNumber) {
        this.model = new ModelBean(fname, unitsNumber, taxRateNumber, taxTypeNumber);
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean {
        /**
         * FName : BBB
         * FImgStorageType : B
         * SubHeadEntity : {"FErpClsID":"1","FCategoryID":{"FNumber":"CHLB01_SYS"},"FTaxType":{"FNumber":"WLDSFL01_SYS"},"FTaxRateId":{"FNUMBER":"SL31_SYS"},"FBaseUnitId":{"FNumber":"Pcs"},"FIsPurchase":true,"FIsInventory":true,"FIsSubContract":false,"FIsSale":true,"FIsProduce":false,"FIsAsset":false,"FWEIGHTUNITID":{"FNUMBER":"kg"},"FVOLUMEUNITID":{"FNUMBER":"m"}}
         * SubHeadEntity1 : {"FStoreUnitID":{"FNumber":"Pcs"},"FUnitConvertDir":"1","FIsLockStock":true,"FIsCycleCounting":false,"FCountCycle":"1","FCountDay":1,"FIsMustCounting":false,"FIsBatchManage":false,"FIsKFPeriod":false,"FIsExpParToFlot":false,"FCurrencyId":{"FNumber":"PRE001"},"FIsEnableMinStock":false,"FIsEnableMaxStock":false,"FIsEnableSafeStock":false,"FIsEnableReOrder":false,"FIsSNManage":false,"FIsSNPRDTracy":false,"FSNManageType":"1","FSNGenerateTime":"1"}
         * SubHeadEntity2 : {"FSaleUnitId":{"FNumber":"Pcs"},"FSalePriceUnitId":{"FNumber":"Pcs"},"FMaxQty":100000,"FIsATPCheck":false,"FIsReturnPart":false,"FIsInvoice":false,"FIsReturn":true,"FAllowPublish":false,"FISAFTERSALE":true,"FISPRODUCTFILES":true,"FISWARRANTED":false,"FWARRANTYUNITID":"D","FOutLmtUnit":"SAL","FIsTaxEnjoy":false}
         * SubHeadEntity3 : {"FPurchaseUnitId":{"FNumber":"Pcs"},"FPurchasePriceUnitId":{"FNumber":"Pcs"},"FIsQuota":false,"FQuotaType":"1","FIsVmiBusiness":false,"FEnableSL":false,"FIsPR":false,"FIsReturnMaterial":true,"FIsSourceControl":false,"FPOBillTypeId":{"FNUMBER":"CGSQD01_SYS"},"FPrintCount":1,"FMinPackCount":1}
         * SubHeadEntity4 : {"FPlanningStrategy":"1","FMfgPolicyId":{"FNumber":"ZZCL001_SYS"},"FFixLeadTimeType":"1","FVarLeadTimeType":"1","FCheckLeadTimeType":"1","FOrderIntervalTimeType":"3","FMaxPOQty":100000,"FEOQ":1,"FVarLeadTimeLotSize":1,"FIsMrpComReq":false,"FReserveType":"1","FAllowPartAhead":false,"FCanDelayDays":999,"FAllowPartDelay":true,"FPlanOffsetTimeType":"1"}
         * SubHeadEntity5 : {"FProduceUnitId":{"FNumber":"Pcs"},"FProduceBillType":{"FNUMBER":"SCDD03_SYS"},"FOrgTrustBillType":{"FNUMBER":"SCDD06_SYS"},"FIsSNCarryToParent":false,"FIsProductLine":false,"FBOMUnitId":{"FNumber":"Pcs"},"FIsMainPrd":false,"FIsCoby":false,"FIsECN":false,"FIssueType":"1","FOverControlMode":"1","FMinIssueQty":1,"FISMinIssueQty":false,"FIsKitting":false,"FIsCompleteSet":false,"FMinIssueUnitId":{"FNUMBER":"Pcs"},"FStandHourUnitId":"3600","FBackFlushType":"1"}
         * SubHeadEntity7 : {"FSubconUnitId":{"FNumber":"Pcs"},"FSubconPriceUnitId":{"FNumber":"Pcs"},"FSubBillType":{"FNUMBER":"WWDD01_SYS"}}
         * SubHeadEntity6 : {"FCheckIncoming":false,"FCheckProduct":false,"FCheckStock":false,"FCheckReturn":false,"FCheckDelivery":false,"FEnableCyclistQCSTK":false,"FEnableCyclistQCSTKEW":false,"FCheckEntrusted":false,"FCheckOther":false}
         * FEntityInvPty : [{"FInvPtyId":{"FNumber":"01"},"FIsEnable":true,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"02"},"FIsEnable":true,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"03"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"04"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false},{"FInvPtyId":{"FNumber":"06"},"FIsEnable":false,"FIsAffectPrice":false,"FIsAffectPlan":false,"FIsAffectCost":false}]
         */

        @JSONField(ordinal = 1, name = "FName")
        private String fname;
        @JSONField(ordinal = 2, name = "FImgStorageType")
        private String fimgStorageType;
        @JSONField(ordinal = 3, name = "SubHeadEntity")
        private SubHeadEntityBean subHeadEntity;
        @JSONField(ordinal = 4, name = "SubHeadEntity1")
        private SubHeadEntity1Bean subHeadEntity1;
        @JSONField(ordinal = 5, name = "SubHeadEntity2")
        private SubHeadEntity2Bean subHeadEntity2;
        @JSONField(ordinal = 6, name = "SubHeadEntity3")
        private SubHeadEntity3Bean subHeadEntity3;
        @JSONField(ordinal = 7, name = "SubHeadEntity4")
        private SubHeadEntity4Bean subHeadEntity4;
        @JSONField(ordinal = 8, name = "SubHeadEntity5")
        private SubHeadEntity5Bean subHeadEntity5;
        @JSONField(ordinal = 9, name = "SubHeadEntity7")
        private SubHeadEntity7Bean subHeadEntity7;
        @JSONField(ordinal = 10, name = "SubHeadEntity6")
        private SubHeadEntity6Bean subHeadEntity6;
        @JSONField(ordinal = 11, name = "FEntityInvPty")
        private List<FEntityInvPtyBean> fentityInvPty;

        private ModelBean(String fname, String unitsNumber, String taxRateNumber, String taxTypeNumber) {
            this.fname = fname;
            this.fimgStorageType = "1";
            this.subHeadEntity = new SubHeadEntityBean(unitsNumber, taxRateNumber, taxTypeNumber);
            this.subHeadEntity1 = new SubHeadEntity1Bean(unitsNumber);
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getFimgStorageType() {
            return fimgStorageType;
        }

        public void setFimgStorageType(String fimgStorageType) {
            this.fimgStorageType = fimgStorageType;
        }

        public SubHeadEntityBean getSubHeadEntity() {
            return subHeadEntity;
        }

        public void setSubHeadEntity(SubHeadEntityBean subHeadEntity) {
            this.subHeadEntity = subHeadEntity;
        }

        public SubHeadEntity1Bean getSubHeadEntity1() {
            return subHeadEntity1;
        }

        public void setSubHeadEntity1(SubHeadEntity1Bean subHeadEntity1) {
            this.subHeadEntity1 = subHeadEntity1;
        }

        public SubHeadEntity2Bean getSubHeadEntity2() {
            return subHeadEntity2;
        }

        public void setSubHeadEntity2(SubHeadEntity2Bean subHeadEntity2) {
            this.subHeadEntity2 = subHeadEntity2;
        }

        public SubHeadEntity3Bean getSubHeadEntity3() {
            return subHeadEntity3;
        }

        public void setSubHeadEntity3(SubHeadEntity3Bean subHeadEntity3) {
            this.subHeadEntity3 = subHeadEntity3;
        }

        public SubHeadEntity4Bean getSubHeadEntity4() {
            return subHeadEntity4;
        }

        public void setSubHeadEntity4(SubHeadEntity4Bean subHeadEntity4) {
            this.subHeadEntity4 = subHeadEntity4;
        }

        public SubHeadEntity5Bean getSubHeadEntity5() {
            return subHeadEntity5;
        }

        public void setSubHeadEntity5(SubHeadEntity5Bean subHeadEntity5) {
            this.subHeadEntity5 = subHeadEntity5;
        }

        public SubHeadEntity7Bean getSubHeadEntity7() {
            return subHeadEntity7;
        }

        public void setSubHeadEntity7(SubHeadEntity7Bean subHeadEntity7) {
            this.subHeadEntity7 = subHeadEntity7;
        }

        public SubHeadEntity6Bean getSubHeadEntity6() {
            return subHeadEntity6;
        }

        public void setSubHeadEntity6(SubHeadEntity6Bean subHeadEntity6) {
            this.subHeadEntity6 = subHeadEntity6;
        }

        public List<FEntityInvPtyBean> getFentityInvPty() {
            return fentityInvPty;
        }

        public void setFentityInvPty(List<FEntityInvPtyBean> fentityInvPty) {
            this.fentityInvPty = fentityInvPty;
        }

        public static class SubHeadEntityBean {
            /**
             * FErpClsID : 1
             * FCategoryID : {"FNumber":"CHLB01_SYS"}
             * FTaxType : {"FNumber":"WLDSFL01_SYS"}
             * FTaxRateId : {"FNUMBER":"SL31_SYS"}
             * FBaseUnitId : {"FNumber":"Pcs"}
             * FIsPurchase : true
             * FIsInventory : true
             * FIsSubContract : false
             * FIsSale : true
             * FIsProduce : false
             * FIsAsset : false
             */
            private SubHeadEntityBean(String unitsNumber, String taxRateNumber, String taxTypeNumber) {
                this.ferpClsID = "1";
                this.fcategoryID = new FCategoryIDBean();
                this.ftaxType = new FTaxTypeBean(taxTypeNumber);
                this.ftaxRateId = new FTaxRateIdBean(taxRateNumber);
                this.fbaseUnitId = new FBaseUnitIdBean(unitsNumber);
                this.fisPurchase = true;
                this.fisInventory = true;
                this.fisSubContract = false;
                this.fisSale = true;
                this.fisProduce = false;
                this.fisAsset = false;
            }


            @JSONField(ordinal = 1, name = "FErpClsID")
            private String ferpClsID;
            @JSONField(ordinal = 2, name = "FCategoryID")
            private FCategoryIDBean fcategoryID;
            @JSONField(ordinal = 3, name = "FTaxType")
            private FTaxTypeBean ftaxType;
            @JSONField(ordinal = 4, name = "FTaxRateId")
            private FTaxRateIdBean ftaxRateId;
            @JSONField(ordinal = 5, name = "FBaseUnitId")
            private FBaseUnitIdBean fbaseUnitId;
            @JSONField(ordinal = 6, name = "FIsPurchase")
            private boolean fisPurchase;
            @JSONField(ordinal = 7, name = "FIsInventory")
            private boolean fisInventory;
            @JSONField(ordinal = 8, name = "FIsSubContract")
            private boolean fisSubContract;
            @JSONField(ordinal = 9, name = "FIsSale")
            private boolean fisSale;
            @JSONField(ordinal = 10, name = "FIsProduce")
            private boolean fisProduce;
            @JSONField(ordinal = 11, name = "FIsAsset")
            private boolean fisAsset;

            public String getFerpClsID() {
                return ferpClsID;
            }

            public void setFerpClsID(String ferpClsID) {
                this.ferpClsID = ferpClsID;
            }

            public FCategoryIDBean getFcategoryID() {
                return fcategoryID;
            }

            public void setFcategoryID(FCategoryIDBean fcategoryID) {
                this.fcategoryID = fcategoryID;
            }

            public FTaxTypeBean getFtaxType() {
                return ftaxType;
            }

            public void setFtaxType(FTaxTypeBean ftaxType) {
                this.ftaxType = ftaxType;
            }

            public FTaxRateIdBean getFtaxRateId() {
                return ftaxRateId;
            }

            public void setFtaxRateId(FTaxRateIdBean ftaxRateId) {
                this.ftaxRateId = ftaxRateId;
            }

            public FBaseUnitIdBean getFbaseUnitId() {
                return fbaseUnitId;
            }

            public void setFbaseUnitId(FBaseUnitIdBean fbaseUnitId) {
                this.fbaseUnitId = fbaseUnitId;
            }

            public boolean isFisPurchase() {
                return fisPurchase;
            }

            public void setFisPurchase(boolean fisPurchase) {
                this.fisPurchase = fisPurchase;
            }

            public boolean isFisInventory() {
                return fisInventory;
            }

            public void setFisInventory(boolean fisInventory) {
                this.fisInventory = fisInventory;
            }

            public boolean isFisSubContract() {
                return fisSubContract;
            }

            public void setFisSubContract(boolean fisSubContract) {
                this.fisSubContract = fisSubContract;
            }

            public boolean isFisSale() {
                return fisSale;
            }

            public void setFisSale(boolean fisSale) {
                this.fisSale = fisSale;
            }

            public boolean isFisProduce() {
                return fisProduce;
            }

            public void setFisProduce(boolean fisProduce) {
                this.fisProduce = fisProduce;
            }

            public boolean isFisAsset() {
                return fisAsset;
            }

            public void setFisAsset(boolean fisAsset) {
                this.fisAsset = fisAsset;
            }

            public static class FCategoryIDBean {
                /**
                 * FNumber : CHLB01_SYS
                 */
                private FCategoryIDBean() {
                    this.fnumber = "CHLB01_SYS";
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

            public static class FTaxTypeBean {
                /**
                 * FNumber : WLDSFL01_SYS
                 */

                private FTaxTypeBean(String taxRateNumber) {
                    this.fnumber = taxRateNumber;
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

            public static class FTaxRateIdBean {
                /**
                 * FNUMBER : SL31_SYS
                 */
                private FTaxRateIdBean(String taxRateNumber) {
                    this.FNUMBER = taxRateNumber;
                }

                @JSONField(name = "FNUMBER")
                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }

            public static class FBaseUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private FBaseUnitIdBean(String unitsNumber) {
                    this.fnumber = unitsNumber;
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

            public static class FWEIGHTUNITIDBean {
                /**
                 * FNUMBER : kg
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }

            public static class FVOLUMEUNITIDBean {
                /**
                 * FNUMBER : m
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }
        }

        public static class SubHeadEntity1Bean {
            /**
             * FStoreUnitID : {"FNumber":"Pcs"}
             * FUnitConvertDir : 1
             * FIsLockStock : true
             * FIsCycleCounting : false
             * FCountCycle : 1
             * FCountDay : 1
             * FIsMustCounting : false
             * FIsBatchManage : false
             * FIsKFPeriod : false
             * FIsExpParToFlot : false
             * FCurrencyId : {"FNumber":"PRE001"}
             * FIsEnableMinStock : false
             * FIsEnableMaxStock : false
             * FIsEnableSafeStock : false
             * FIsEnableReOrder : false
             * FIsSNManage : false
             * FIsSNPRDTracy : false
             * FSNManageType : 1
             * FSNGenerateTime : 1
             */
            private SubHeadEntity1Bean(String unitsNumber) {
                this.fstoreUnitID = new FStoreUnitIDBean(unitsNumber);
            }

            @JSONField(ordinal = 1, name = "FStoreUnitID")
            private FStoreUnitIDBean fstoreUnitID;
            @JSONField(ordinal = 2, name = "FUnitConvertDir")
            private String funitConvertDir;
            @JSONField(ordinal = 3, name = "FIsLockStock")
            private boolean fisLockStock;
            @JSONField(ordinal = 4, name = "FIsCycleCounting")
            private boolean fisCycleCounting;
            @JSONField(ordinal = 5, name = "FCountCycle")
            private String fcountCycle;
            @JSONField(ordinal = 6, name = "FCountDay")
            private int fcountDay;
            @JSONField(ordinal = 7, name = "FIsMustCounting")
            private boolean fisMustCounting;
            @JSONField(ordinal = 8, name = "FIsBatchManage")
            private boolean fisBatchManage;
            @JSONField(ordinal = 9, name = "FIsKFPeriod")
            private boolean fisKFPeriod;
            @JSONField(ordinal = 10, name = "FIsExpParToFlot")
            private boolean fisExpParToFlot;
            @JSONField(ordinal = 11, name = "FCurrencyId")
            private FCurrencyIdBean fcurrencyId;
            @JSONField(ordinal = 12, name = "FIsEnableMinStock")
            private boolean fisEnableMinStock;
            @JSONField(ordinal = 13, name = "FIsEnableMaxStock")
            private boolean fisEnableMaxStock;
            @JSONField(ordinal = 14, name = "FIsEnableSafeStock")
            private boolean fisEnableSafeStock;
            @JSONField(ordinal = 15, name = "FIsEnableReOrder")
            private boolean fisEnableReOrder;
            @JSONField(ordinal = 16, name = "FIsSNManage")
            private boolean fisSNManage;
            @JSONField(ordinal = 17, name = "FIsSNPRDTracy")
            private boolean fisSNPRDTracy;
            @JSONField(ordinal = 18, name = "FSNManageType")
            private String FSNManageType;
            @JSONField(ordinal = 19, name = "FSNGenerateTime")
            private String FSNGenerateTime;

            public FStoreUnitIDBean getFstoreUnitID() {
                return fstoreUnitID;
            }

            public void setFstoreUnitID(FStoreUnitIDBean fstoreUnitID) {
                this.fstoreUnitID = fstoreUnitID;
            }

            public String getFunitConvertDir() {
                return funitConvertDir;
            }

            public void setFunitConvertDir(String funitConvertDir) {
                this.funitConvertDir = funitConvertDir;
            }

            public boolean isFisLockStock() {
                return fisLockStock;
            }

            public void setFisLockStock(boolean fisLockStock) {
                this.fisLockStock = fisLockStock;
            }

            public boolean isFisCycleCounting() {
                return fisCycleCounting;
            }

            public void setFisCycleCounting(boolean fisCycleCounting) {
                this.fisCycleCounting = fisCycleCounting;
            }

            public String getFcountCycle() {
                return fcountCycle;
            }

            public void setFcountCycle(String fcountCycle) {
                this.fcountCycle = fcountCycle;
            }

            public int getFcountDay() {
                return fcountDay;
            }

            public void setFcountDay(int fcountDay) {
                this.fcountDay = fcountDay;
            }

            public boolean isFisMustCounting() {
                return fisMustCounting;
            }

            public void setFisMustCounting(boolean fisMustCounting) {
                this.fisMustCounting = fisMustCounting;
            }

            public boolean isFisBatchManage() {
                return fisBatchManage;
            }

            public void setFisBatchManage(boolean fisBatchManage) {
                this.fisBatchManage = fisBatchManage;
            }

            public boolean isFisKFPeriod() {
                return fisKFPeriod;
            }

            public void setFisKFPeriod(boolean fisKFPeriod) {
                this.fisKFPeriod = fisKFPeriod;
            }

            public boolean isFisExpParToFlot() {
                return fisExpParToFlot;
            }

            public void setFisExpParToFlot(boolean fisExpParToFlot) {
                this.fisExpParToFlot = fisExpParToFlot;
            }

            public FCurrencyIdBean getFcurrencyId() {
                return fcurrencyId;
            }

            public void setFcurrencyId(FCurrencyIdBean fcurrencyId) {
                this.fcurrencyId = fcurrencyId;
            }

            public boolean isFisEnableMinStock() {
                return fisEnableMinStock;
            }

            public void setFisEnableMinStock(boolean fisEnableMinStock) {
                this.fisEnableMinStock = fisEnableMinStock;
            }

            public boolean isFisEnableMaxStock() {
                return fisEnableMaxStock;
            }

            public void setFisEnableMaxStock(boolean fisEnableMaxStock) {
                this.fisEnableMaxStock = fisEnableMaxStock;
            }

            public boolean isFisEnableSafeStock() {
                return fisEnableSafeStock;
            }

            public void setFisEnableSafeStock(boolean fisEnableSafeStock) {
                this.fisEnableSafeStock = fisEnableSafeStock;
            }

            public boolean isFisEnableReOrder() {
                return fisEnableReOrder;
            }

            public void setFisEnableReOrder(boolean fisEnableReOrder) {
                this.fisEnableReOrder = fisEnableReOrder;
            }

            public boolean isFisSNManage() {
                return fisSNManage;
            }

            public void setFisSNManage(boolean fisSNManage) {
                this.fisSNManage = fisSNManage;
            }

            public boolean isFisSNPRDTracy() {
                return fisSNPRDTracy;
            }

            public void setFisSNPRDTracy(boolean fisSNPRDTracy) {
                this.fisSNPRDTracy = fisSNPRDTracy;
            }

            public String getFSNManageType() {
                return FSNManageType;
            }

            public void setFSNManageType(String FSNManageType) {
                this.FSNManageType = FSNManageType;
            }

            public String getFSNGenerateTime() {
                return FSNGenerateTime;
            }

            public void setFSNGenerateTime(String FSNGenerateTime) {
                this.FSNGenerateTime = FSNGenerateTime;
            }

            public static class FStoreUnitIDBean {
                /**
                 * FNumber : Pcs
                 */

                private FStoreUnitIDBean(String unitsNumber){
                    this.fnumber = unitsNumber;
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

            public static class FCurrencyIdBean {
                /**
                 * FNumber : PRE001
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }
        }

        public static class SubHeadEntity2Bean {
            /**
             * FSaleUnitId : {"FNumber":"Pcs"}
             * FSalePriceUnitId : {"FNumber":"Pcs"}
             * FMaxQty : 100000
             * FIsATPCheck : false
             * FIsReturnPart : false
             * FIsInvoice : false
             * FIsReturn : true
             * FAllowPublish : false
             * FISAFTERSALE : true
             * FISPRODUCTFILES : true
             * FISWARRANTED : false
             * FWARRANTYUNITID : D
             * FOutLmtUnit : SAL
             * FIsTaxEnjoy : false
             */

            private FSaleUnitIdBean FSaleUnitId;
            private FSalePriceUnitIdBean FSalePriceUnitId;
            private int FMaxQty;
            private boolean FIsATPCheck;
            private boolean FIsReturnPart;
            private boolean FIsInvoice;
            private boolean FIsReturn;
            private boolean FAllowPublish;
            private boolean FISAFTERSALE;
            private boolean FISPRODUCTFILES;
            private boolean FISWARRANTED;
            private String FWARRANTYUNITID;
            private String FOutLmtUnit;
            private boolean FIsTaxEnjoy;

            public FSaleUnitIdBean getFSaleUnitId() {
                return FSaleUnitId;
            }

            public void setFSaleUnitId(FSaleUnitIdBean FSaleUnitId) {
                this.FSaleUnitId = FSaleUnitId;
            }

            public FSalePriceUnitIdBean getFSalePriceUnitId() {
                return FSalePriceUnitId;
            }

            public void setFSalePriceUnitId(FSalePriceUnitIdBean FSalePriceUnitId) {
                this.FSalePriceUnitId = FSalePriceUnitId;
            }

            public int getFMaxQty() {
                return FMaxQty;
            }

            public void setFMaxQty(int FMaxQty) {
                this.FMaxQty = FMaxQty;
            }

            public boolean isFIsATPCheck() {
                return FIsATPCheck;
            }

            public void setFIsATPCheck(boolean FIsATPCheck) {
                this.FIsATPCheck = FIsATPCheck;
            }

            public boolean isFIsReturnPart() {
                return FIsReturnPart;
            }

            public void setFIsReturnPart(boolean FIsReturnPart) {
                this.FIsReturnPart = FIsReturnPart;
            }

            public boolean isFIsInvoice() {
                return FIsInvoice;
            }

            public void setFIsInvoice(boolean FIsInvoice) {
                this.FIsInvoice = FIsInvoice;
            }

            public boolean isFIsReturn() {
                return FIsReturn;
            }

            public void setFIsReturn(boolean FIsReturn) {
                this.FIsReturn = FIsReturn;
            }

            public boolean isFAllowPublish() {
                return FAllowPublish;
            }

            public void setFAllowPublish(boolean FAllowPublish) {
                this.FAllowPublish = FAllowPublish;
            }

            public boolean isFISAFTERSALE() {
                return FISAFTERSALE;
            }

            public void setFISAFTERSALE(boolean FISAFTERSALE) {
                this.FISAFTERSALE = FISAFTERSALE;
            }

            public boolean isFISPRODUCTFILES() {
                return FISPRODUCTFILES;
            }

            public void setFISPRODUCTFILES(boolean FISPRODUCTFILES) {
                this.FISPRODUCTFILES = FISPRODUCTFILES;
            }

            public boolean isFISWARRANTED() {
                return FISWARRANTED;
            }

            public void setFISWARRANTED(boolean FISWARRANTED) {
                this.FISWARRANTED = FISWARRANTED;
            }

            public String getFWARRANTYUNITID() {
                return FWARRANTYUNITID;
            }

            public void setFWARRANTYUNITID(String FWARRANTYUNITID) {
                this.FWARRANTYUNITID = FWARRANTYUNITID;
            }

            public String getFOutLmtUnit() {
                return FOutLmtUnit;
            }

            public void setFOutLmtUnit(String FOutLmtUnit) {
                this.FOutLmtUnit = FOutLmtUnit;
            }

            public boolean isFIsTaxEnjoy() {
                return FIsTaxEnjoy;
            }

            public void setFIsTaxEnjoy(boolean FIsTaxEnjoy) {
                this.FIsTaxEnjoy = FIsTaxEnjoy;
            }

            public static class FSaleUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FSalePriceUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }
        }

        public static class SubHeadEntity3Bean {
            /**
             * FPurchaseUnitId : {"FNumber":"Pcs"}
             * FPurchasePriceUnitId : {"FNumber":"Pcs"}
             * FIsQuota : false
             * FQuotaType : 1
             * FIsVmiBusiness : false
             * FEnableSL : false
             * FIsPR : false
             * FIsReturnMaterial : true
             * FIsSourceControl : false
             * FPOBillTypeId : {"FNUMBER":"CGSQD01_SYS"}
             * FPrintCount : 1
             * FMinPackCount : 1
             */

            private FPurchaseUnitIdBean FPurchaseUnitId;
            private FPurchasePriceUnitIdBean FPurchasePriceUnitId;
            private boolean FIsQuota;
            private String FQuotaType;
            private boolean FIsVmiBusiness;
            private boolean FEnableSL;
            private boolean FIsPR;
            private boolean FIsReturnMaterial;
            private boolean FIsSourceControl;
            private FPOBillTypeIdBean FPOBillTypeId;
            private int FPrintCount;
            private int FMinPackCount;

            public FPurchaseUnitIdBean getFPurchaseUnitId() {
                return FPurchaseUnitId;
            }

            public void setFPurchaseUnitId(FPurchaseUnitIdBean FPurchaseUnitId) {
                this.FPurchaseUnitId = FPurchaseUnitId;
            }

            public FPurchasePriceUnitIdBean getFPurchasePriceUnitId() {
                return FPurchasePriceUnitId;
            }

            public void setFPurchasePriceUnitId(FPurchasePriceUnitIdBean FPurchasePriceUnitId) {
                this.FPurchasePriceUnitId = FPurchasePriceUnitId;
            }

            public boolean isFIsQuota() {
                return FIsQuota;
            }

            public void setFIsQuota(boolean FIsQuota) {
                this.FIsQuota = FIsQuota;
            }

            public String getFQuotaType() {
                return FQuotaType;
            }

            public void setFQuotaType(String FQuotaType) {
                this.FQuotaType = FQuotaType;
            }

            public boolean isFIsVmiBusiness() {
                return FIsVmiBusiness;
            }

            public void setFIsVmiBusiness(boolean FIsVmiBusiness) {
                this.FIsVmiBusiness = FIsVmiBusiness;
            }

            public boolean isFEnableSL() {
                return FEnableSL;
            }

            public void setFEnableSL(boolean FEnableSL) {
                this.FEnableSL = FEnableSL;
            }

            public boolean isFIsPR() {
                return FIsPR;
            }

            public void setFIsPR(boolean FIsPR) {
                this.FIsPR = FIsPR;
            }

            public boolean isFIsReturnMaterial() {
                return FIsReturnMaterial;
            }

            public void setFIsReturnMaterial(boolean FIsReturnMaterial) {
                this.FIsReturnMaterial = FIsReturnMaterial;
            }

            public boolean isFIsSourceControl() {
                return FIsSourceControl;
            }

            public void setFIsSourceControl(boolean FIsSourceControl) {
                this.FIsSourceControl = FIsSourceControl;
            }

            public FPOBillTypeIdBean getFPOBillTypeId() {
                return FPOBillTypeId;
            }

            public void setFPOBillTypeId(FPOBillTypeIdBean FPOBillTypeId) {
                this.FPOBillTypeId = FPOBillTypeId;
            }

            public int getFPrintCount() {
                return FPrintCount;
            }

            public void setFPrintCount(int FPrintCount) {
                this.FPrintCount = FPrintCount;
            }

            public int getFMinPackCount() {
                return FMinPackCount;
            }

            public void setFMinPackCount(int FMinPackCount) {
                this.FMinPackCount = FMinPackCount;
            }

            public static class FPurchaseUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FPurchasePriceUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FPOBillTypeIdBean {
                /**
                 * FNUMBER : CGSQD01_SYS
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }
        }

        public static class SubHeadEntity4Bean {
            /**
             * FPlanningStrategy : 1
             * FMfgPolicyId : {"FNumber":"ZZCL001_SYS"}
             * FFixLeadTimeType : 1
             * FVarLeadTimeType : 1
             * FCheckLeadTimeType : 1
             * FOrderIntervalTimeType : 3
             * FMaxPOQty : 100000
             * FEOQ : 1
             * FVarLeadTimeLotSize : 1
             * FIsMrpComReq : false
             * FReserveType : 1
             * FAllowPartAhead : false
             * FCanDelayDays : 999
             * FAllowPartDelay : true
             * FPlanOffsetTimeType : 1
             */

            private String FPlanningStrategy;
            private FMfgPolicyIdBean FMfgPolicyId;
            private String FFixLeadTimeType;
            private String FVarLeadTimeType;
            private String FCheckLeadTimeType;
            private String FOrderIntervalTimeType;
            private int FMaxPOQty;
            private int FEOQ;
            private int FVarLeadTimeLotSize;
            private boolean FIsMrpComReq;
            private String FReserveType;
            private boolean FAllowPartAhead;
            private int FCanDelayDays;
            private boolean FAllowPartDelay;
            private String FPlanOffsetTimeType;

            public String getFPlanningStrategy() {
                return FPlanningStrategy;
            }

            public void setFPlanningStrategy(String FPlanningStrategy) {
                this.FPlanningStrategy = FPlanningStrategy;
            }

            public FMfgPolicyIdBean getFMfgPolicyId() {
                return FMfgPolicyId;
            }

            public void setFMfgPolicyId(FMfgPolicyIdBean FMfgPolicyId) {
                this.FMfgPolicyId = FMfgPolicyId;
            }

            public String getFFixLeadTimeType() {
                return FFixLeadTimeType;
            }

            public void setFFixLeadTimeType(String FFixLeadTimeType) {
                this.FFixLeadTimeType = FFixLeadTimeType;
            }

            public String getFVarLeadTimeType() {
                return FVarLeadTimeType;
            }

            public void setFVarLeadTimeType(String FVarLeadTimeType) {
                this.FVarLeadTimeType = FVarLeadTimeType;
            }

            public String getFCheckLeadTimeType() {
                return FCheckLeadTimeType;
            }

            public void setFCheckLeadTimeType(String FCheckLeadTimeType) {
                this.FCheckLeadTimeType = FCheckLeadTimeType;
            }

            public String getFOrderIntervalTimeType() {
                return FOrderIntervalTimeType;
            }

            public void setFOrderIntervalTimeType(String FOrderIntervalTimeType) {
                this.FOrderIntervalTimeType = FOrderIntervalTimeType;
            }

            public int getFMaxPOQty() {
                return FMaxPOQty;
            }

            public void setFMaxPOQty(int FMaxPOQty) {
                this.FMaxPOQty = FMaxPOQty;
            }

            public int getFEOQ() {
                return FEOQ;
            }

            public void setFEOQ(int FEOQ) {
                this.FEOQ = FEOQ;
            }

            public int getFVarLeadTimeLotSize() {
                return FVarLeadTimeLotSize;
            }

            public void setFVarLeadTimeLotSize(int FVarLeadTimeLotSize) {
                this.FVarLeadTimeLotSize = FVarLeadTimeLotSize;
            }

            public boolean isFIsMrpComReq() {
                return FIsMrpComReq;
            }

            public void setFIsMrpComReq(boolean FIsMrpComReq) {
                this.FIsMrpComReq = FIsMrpComReq;
            }

            public String getFReserveType() {
                return FReserveType;
            }

            public void setFReserveType(String FReserveType) {
                this.FReserveType = FReserveType;
            }

            public boolean isFAllowPartAhead() {
                return FAllowPartAhead;
            }

            public void setFAllowPartAhead(boolean FAllowPartAhead) {
                this.FAllowPartAhead = FAllowPartAhead;
            }

            public int getFCanDelayDays() {
                return FCanDelayDays;
            }

            public void setFCanDelayDays(int FCanDelayDays) {
                this.FCanDelayDays = FCanDelayDays;
            }

            public boolean isFAllowPartDelay() {
                return FAllowPartDelay;
            }

            public void setFAllowPartDelay(boolean FAllowPartDelay) {
                this.FAllowPartDelay = FAllowPartDelay;
            }

            public String getFPlanOffsetTimeType() {
                return FPlanOffsetTimeType;
            }

            public void setFPlanOffsetTimeType(String FPlanOffsetTimeType) {
                this.FPlanOffsetTimeType = FPlanOffsetTimeType;
            }

            public static class FMfgPolicyIdBean {
                /**
                 * FNumber : ZZCL001_SYS
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }
        }

        public static class SubHeadEntity5Bean {
            /**
             * FProduceUnitId : {"FNumber":"Pcs"}
             * FProduceBillType : {"FNUMBER":"SCDD03_SYS"}
             * FOrgTrustBillType : {"FNUMBER":"SCDD06_SYS"}
             * FIsSNCarryToParent : false
             * FIsProductLine : false
             * FBOMUnitId : {"FNumber":"Pcs"}
             * FIsMainPrd : false
             * FIsCoby : false
             * FIsECN : false
             * FIssueType : 1
             * FOverControlMode : 1
             * FMinIssueQty : 1
             * FISMinIssueQty : false
             * FIsKitting : false
             * FIsCompleteSet : false
             * FMinIssueUnitId : {"FNUMBER":"Pcs"}
             * FStandHourUnitId : 3600
             * FBackFlushType : 1
             */

            private FProduceUnitIdBean FProduceUnitId;
            private FProduceBillTypeBean FProduceBillType;
            private FOrgTrustBillTypeBean FOrgTrustBillType;
            private boolean FIsSNCarryToParent;
            private boolean FIsProductLine;
            private FBOMUnitIdBean FBOMUnitId;
            private boolean FIsMainPrd;
            private boolean FIsCoby;
            private boolean FIsECN;
            private String FIssueType;
            private String FOverControlMode;
            private int FMinIssueQty;
            private boolean FISMinIssueQty;
            private boolean FIsKitting;
            private boolean FIsCompleteSet;
            private FMinIssueUnitIdBean FMinIssueUnitId;
            private String FStandHourUnitId;
            private String FBackFlushType;

            public FProduceUnitIdBean getFProduceUnitId() {
                return FProduceUnitId;
            }

            public void setFProduceUnitId(FProduceUnitIdBean FProduceUnitId) {
                this.FProduceUnitId = FProduceUnitId;
            }

            public FProduceBillTypeBean getFProduceBillType() {
                return FProduceBillType;
            }

            public void setFProduceBillType(FProduceBillTypeBean FProduceBillType) {
                this.FProduceBillType = FProduceBillType;
            }

            public FOrgTrustBillTypeBean getFOrgTrustBillType() {
                return FOrgTrustBillType;
            }

            public void setFOrgTrustBillType(FOrgTrustBillTypeBean FOrgTrustBillType) {
                this.FOrgTrustBillType = FOrgTrustBillType;
            }

            public boolean isFIsSNCarryToParent() {
                return FIsSNCarryToParent;
            }

            public void setFIsSNCarryToParent(boolean FIsSNCarryToParent) {
                this.FIsSNCarryToParent = FIsSNCarryToParent;
            }

            public boolean isFIsProductLine() {
                return FIsProductLine;
            }

            public void setFIsProductLine(boolean FIsProductLine) {
                this.FIsProductLine = FIsProductLine;
            }

            public FBOMUnitIdBean getFBOMUnitId() {
                return FBOMUnitId;
            }

            public void setFBOMUnitId(FBOMUnitIdBean FBOMUnitId) {
                this.FBOMUnitId = FBOMUnitId;
            }

            public boolean isFIsMainPrd() {
                return FIsMainPrd;
            }

            public void setFIsMainPrd(boolean FIsMainPrd) {
                this.FIsMainPrd = FIsMainPrd;
            }

            public boolean isFIsCoby() {
                return FIsCoby;
            }

            public void setFIsCoby(boolean FIsCoby) {
                this.FIsCoby = FIsCoby;
            }

            public boolean isFIsECN() {
                return FIsECN;
            }

            public void setFIsECN(boolean FIsECN) {
                this.FIsECN = FIsECN;
            }

            public String getFIssueType() {
                return FIssueType;
            }

            public void setFIssueType(String FIssueType) {
                this.FIssueType = FIssueType;
            }

            public String getFOverControlMode() {
                return FOverControlMode;
            }

            public void setFOverControlMode(String FOverControlMode) {
                this.FOverControlMode = FOverControlMode;
            }

            public int getFMinIssueQty() {
                return FMinIssueQty;
            }

            public void setFMinIssueQty(int FMinIssueQty) {
                this.FMinIssueQty = FMinIssueQty;
            }

            public boolean isFISMinIssueQty() {
                return FISMinIssueQty;
            }

            public void setFISMinIssueQty(boolean FISMinIssueQty) {
                this.FISMinIssueQty = FISMinIssueQty;
            }

            public boolean isFIsKitting() {
                return FIsKitting;
            }

            public void setFIsKitting(boolean FIsKitting) {
                this.FIsKitting = FIsKitting;
            }

            public boolean isFIsCompleteSet() {
                return FIsCompleteSet;
            }

            public void setFIsCompleteSet(boolean FIsCompleteSet) {
                this.FIsCompleteSet = FIsCompleteSet;
            }

            public FMinIssueUnitIdBean getFMinIssueUnitId() {
                return FMinIssueUnitId;
            }

            public void setFMinIssueUnitId(FMinIssueUnitIdBean FMinIssueUnitId) {
                this.FMinIssueUnitId = FMinIssueUnitId;
            }

            public String getFStandHourUnitId() {
                return FStandHourUnitId;
            }

            public void setFStandHourUnitId(String FStandHourUnitId) {
                this.FStandHourUnitId = FStandHourUnitId;
            }

            public String getFBackFlushType() {
                return FBackFlushType;
            }

            public void setFBackFlushType(String FBackFlushType) {
                this.FBackFlushType = FBackFlushType;
            }

            public static class FProduceUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FProduceBillTypeBean {
                /**
                 * FNUMBER : SCDD03_SYS
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }

            public static class FOrgTrustBillTypeBean {
                /**
                 * FNUMBER : SCDD06_SYS
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }

            public static class FBOMUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FMinIssueUnitIdBean {
                /**
                 * FNUMBER : Pcs
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }
        }

        public static class SubHeadEntity7Bean {
            /**
             * FSubconUnitId : {"FNumber":"Pcs"}
             * FSubconPriceUnitId : {"FNumber":"Pcs"}
             * FSubBillType : {"FNUMBER":"WWDD01_SYS"}
             */

            private FSubconUnitIdBean FSubconUnitId;
            private FSubconPriceUnitIdBean FSubconPriceUnitId;
            private FSubBillTypeBean FSubBillType;

            public FSubconUnitIdBean getFSubconUnitId() {
                return FSubconUnitId;
            }

            public void setFSubconUnitId(FSubconUnitIdBean FSubconUnitId) {
                this.FSubconUnitId = FSubconUnitId;
            }

            public FSubconPriceUnitIdBean getFSubconPriceUnitId() {
                return FSubconPriceUnitId;
            }

            public void setFSubconPriceUnitId(FSubconPriceUnitIdBean FSubconPriceUnitId) {
                this.FSubconPriceUnitId = FSubconPriceUnitId;
            }

            public FSubBillTypeBean getFSubBillType() {
                return FSubBillType;
            }

            public void setFSubBillType(FSubBillTypeBean FSubBillType) {
                this.FSubBillType = FSubBillType;
            }

            public static class FSubconUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FSubconPriceUnitIdBean {
                /**
                 * FNumber : Pcs
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }

            public static class FSubBillTypeBean {
                /**
                 * FNUMBER : WWDD01_SYS
                 */

                private String FNUMBER;

                public String getFNUMBER() {
                    return FNUMBER;
                }

                public void setFNUMBER(String FNUMBER) {
                    this.FNUMBER = FNUMBER;
                }
            }
        }

        public static class SubHeadEntity6Bean {
            /**
             * FCheckIncoming : false
             * FCheckProduct : false
             * FCheckStock : false
             * FCheckReturn : false
             * FCheckDelivery : false
             * FEnableCyclistQCSTK : false
             * FEnableCyclistQCSTKEW : false
             * FCheckEntrusted : false
             * FCheckOther : false
             */

            private boolean FCheckIncoming;
            private boolean FCheckProduct;
            private boolean FCheckStock;
            private boolean FCheckReturn;
            private boolean FCheckDelivery;
            private boolean FEnableCyclistQCSTK;
            private boolean FEnableCyclistQCSTKEW;
            private boolean FCheckEntrusted;
            private boolean FCheckOther;

            public boolean isFCheckIncoming() {
                return FCheckIncoming;
            }

            public void setFCheckIncoming(boolean FCheckIncoming) {
                this.FCheckIncoming = FCheckIncoming;
            }

            public boolean isFCheckProduct() {
                return FCheckProduct;
            }

            public void setFCheckProduct(boolean FCheckProduct) {
                this.FCheckProduct = FCheckProduct;
            }

            public boolean isFCheckStock() {
                return FCheckStock;
            }

            public void setFCheckStock(boolean FCheckStock) {
                this.FCheckStock = FCheckStock;
            }

            public boolean isFCheckReturn() {
                return FCheckReturn;
            }

            public void setFCheckReturn(boolean FCheckReturn) {
                this.FCheckReturn = FCheckReturn;
            }

            public boolean isFCheckDelivery() {
                return FCheckDelivery;
            }

            public void setFCheckDelivery(boolean FCheckDelivery) {
                this.FCheckDelivery = FCheckDelivery;
            }

            public boolean isFEnableCyclistQCSTK() {
                return FEnableCyclistQCSTK;
            }

            public void setFEnableCyclistQCSTK(boolean FEnableCyclistQCSTK) {
                this.FEnableCyclistQCSTK = FEnableCyclistQCSTK;
            }

            public boolean isFEnableCyclistQCSTKEW() {
                return FEnableCyclistQCSTKEW;
            }

            public void setFEnableCyclistQCSTKEW(boolean FEnableCyclistQCSTKEW) {
                this.FEnableCyclistQCSTKEW = FEnableCyclistQCSTKEW;
            }

            public boolean isFCheckEntrusted() {
                return FCheckEntrusted;
            }

            public void setFCheckEntrusted(boolean FCheckEntrusted) {
                this.FCheckEntrusted = FCheckEntrusted;
            }

            public boolean isFCheckOther() {
                return FCheckOther;
            }

            public void setFCheckOther(boolean FCheckOther) {
                this.FCheckOther = FCheckOther;
            }
        }

        public static class FEntityInvPtyBean {
            /**
             * FInvPtyId : {"FNumber":"01"}
             * FIsEnable : true
             * FIsAffectPrice : false
             * FIsAffectPlan : false
             * FIsAffectCost : false
             */

            private FInvPtyIdBean FInvPtyId;
            private boolean FIsEnable;
            private boolean FIsAffectPrice;
            private boolean FIsAffectPlan;
            private boolean FIsAffectCost;

            public FInvPtyIdBean getFInvPtyId() {
                return FInvPtyId;
            }

            public void setFInvPtyId(FInvPtyIdBean FInvPtyId) {
                this.FInvPtyId = FInvPtyId;
            }

            public boolean isFIsEnable() {
                return FIsEnable;
            }

            public void setFIsEnable(boolean FIsEnable) {
                this.FIsEnable = FIsEnable;
            }

            public boolean isFIsAffectPrice() {
                return FIsAffectPrice;
            }

            public void setFIsAffectPrice(boolean FIsAffectPrice) {
                this.FIsAffectPrice = FIsAffectPrice;
            }

            public boolean isFIsAffectPlan() {
                return FIsAffectPlan;
            }

            public void setFIsAffectPlan(boolean FIsAffectPlan) {
                this.FIsAffectPlan = FIsAffectPlan;
            }

            public boolean isFIsAffectCost() {
                return FIsAffectCost;
            }

            public void setFIsAffectCost(boolean FIsAffectCost) {
                this.FIsAffectCost = FIsAffectCost;
            }

            public static class FInvPtyIdBean {
                /**
                 * FNumber : 01
                 */

                private String FNumber;

                public String getFNumber() {
                    return FNumber;
                }

                public void setFNumber(String FNumber) {
                    this.FNumber = FNumber;
                }
            }
        }
    }
}
