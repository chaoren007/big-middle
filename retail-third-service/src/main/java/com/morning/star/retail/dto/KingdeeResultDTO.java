package com.morning.star.retail.dto;

public class KingdeeResultDTO {

    /**
     * Result : {"ResponseStatus":{"IsSuccess":true},"Id":138759,"Number":"UOM007"}
     */

    private ResultBean Result;

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * ResponseStatus : {"IsSuccess":true}
         * Id : 138759
         * Number : UOM007
         */

        private ResponseStatusBean ResponseStatus;
        private int Id;
        private String Number;
        /**
         * A - B - C ===》保存-提交-审核
         */
        //private String DocumentStatus;

        public ResponseStatusBean getResponseStatus() {
            return ResponseStatus;
        }

        public void setResponseStatus(ResponseStatusBean ResponseStatus) {
            this.ResponseStatus = ResponseStatus;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }


        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public static class ResponseStatusBean {
            /**
             * IsSuccess : true
             */

            private boolean IsSuccess;

            public boolean isIsSuccess() {
                return IsSuccess;
            }

            public void setIsSuccess(boolean IsSuccess) {
                this.IsSuccess = IsSuccess;
            }
        }
    }
}
