package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class BusProductDTO implements Serializable {

    /**
     * 	是 	string 	运营点编码
     */
    private String opc ;
    /**
     * 是 	string 	商品编码，保证唯一性，可以的话，单品编码以“P”开头，系列商品以“SPU”开头
     */
    private String pCode ;
    /**
     * 是 	string 	商品名称
     */
    private String pName ;
    /**
     * 是 	string 	供应商名称
     */
    private String supplierName ;
    /**
     * 是 	int 	类型（0：单品、1：系列）
     */
    private Integer productType ;
    /**
     * 是 	string 	最后一级类目ID
     */
    private String pCategId ;
    /**
     * 是 	string 	最后一级类目名称
     */
    private String pCategName 	;
    /**
     * 是 	string 	创建时间
     */
    private String createdTime 	;
    /**
     * 是 	int 	是否农产品（0：否，1：是）
     */
    private Integer isFarm 	;
    /**
     * 是 	string 	商品说明
     */
    private String pDes ;
    /**
     * 是 	string 	商品主图url，只能单张
     */
    private String pImgIndex 	;
    /**
     * 是 	string 	单品轮播图url，多张用英文逗号隔开
     */
    private String pImgs ;
    /**
     * 是 	string 	商品详情图url，多张用英文逗号隔开
     */
    private String pImgDes ;
    /**
     * 是 	string 	创建人
     */
    private String createor ;

    private List<ProductList> productList;
    private String productParamList;

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getpCategId() {
        return pCategId;
    }

    public void setpCategId(String pCategId) {
        this.pCategId = pCategId;
    }

    public String getpCategName() {
        return pCategName;
    }

    public void setpCategName(String pCategName) {
        this.pCategName = pCategName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getIsFarm() {
        return isFarm;
    }

    public void setIsFarm(Integer isFarm) {
        this.isFarm = isFarm;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public String getpImgIndex() {
        return pImgIndex;
    }

    public void setpImgIndex(String pImgIndex) {
        this.pImgIndex = pImgIndex;
    }

    public String getpImgs() {
        return pImgs;
    }

    public void setpImgs(String pImgs) {
        this.pImgs = pImgs;
    }

    public String getpImgDes() {
        return pImgDes;
    }

    public void setpImgDes(String pImgDes) {
        this.pImgDes = pImgDes;
    }

    public String getCreateor() {
        return createor;
    }

    public void setCreateor(String createor) {
        this.createor = createor;
    }

    public List<ProductList> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }

    public String getProductParamList() {
        return productParamList;
    }

    public void setProductParamList(String productParamList) {
        this.productParamList = productParamList;
    }

    public static class ProductList{

        /**
         * pCode : P123456
         * pName : q1
         * pImgIndex : https://img.niwoning.com/4c26e31b-ff27-41f9-b3ab-79f97c94a730.png
         * pImgs : https://img.niwoning.com/2472bb97-ce90-4349-a6a8-8ac2334b2e26.jpg,https://img.niwoning.com/798af024-8fcf-43ef-a3d6-f370db6345ea.jpg
         * pImgDess : [{"id":1,"imgUrl":"https://img.niwoning.com/2db70ae7-d862-48b5-b7bd-1a78cc24fd13.png"},{"id":2,"imgUrl":"https://img.niwoning.com/a04c02d5-3fab-4c7b-a253-2fb6405c54fe.jpg"}]
         * productParamList : [{"paramName":"水分","paramValue":"1"},{"paramValue":"2","paramName":"产地"}]
         * pImgDes : https://img.niwoning.com/2db70ae7-d862-48b5-b7bd-1a78cc24fd13.png,https://img.niwoning.com/a04c02d5-3fab-4c7b-a253-2fb6405c54fe.jpg
         */

        /**
         * 单品编码
         */
        private String pCode;
        /**
         * 单品名称
         */
        private String pName;
        /**
         * 商品主页URI 单张
         */
        private String pImgIndex;
        /**
         * 单品轮播图url，多张用英文逗号隔开
         */
        private String pImgs;
        /**
         * 商品详情图url，多张用英文逗号隔开
         */
        private String pImgDes;
        private List<PImgDessBean> pImgDess;
        private List<ProductParamListBean> productParamList;

        public String getpCode() {
            return pCode;
        }

        public void setpCode(String pCode) {
            this.pCode = pCode;
        }

        public String getpName() {
            return pName;
        }

        public void setpName(String pName) {
            this.pName = pName;
        }

        public String getpImgIndex() {
            return pImgIndex;
        }

        public void setpImgIndex(String pImgIndex) {
            this.pImgIndex = pImgIndex;
        }

        public String getpImgs() {
            return pImgs;
        }

        public void setpImgs(String pImgs) {
            this.pImgs = pImgs;
        }

        public String getpImgDes() {
            return pImgDes;
        }

        public void setpImgDes(String pImgDes) {
            this.pImgDes = pImgDes;
        }

        public List<PImgDessBean> getpImgDess() {
            return pImgDess;
        }

        public void setpImgDess(List<PImgDessBean> pImgDess) {
            this.pImgDess = pImgDess;
        }

        public List<ProductParamListBean> getProductParamList() {
            return productParamList;
        }

        public void setProductParamList(List<ProductParamListBean> productParamList) {
            this.productParamList = productParamList;
        }

        public static class PImgDessBean {
            /**
             * id : 1
             * imgUrl : https://img.niwoning.com/2db70ae7-d862-48b5-b7bd-1a78cc24fd13.png
             */

            private int id;
            private String imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class ProductParamListBean {
            /**
             * paramName : 水分
             * paramValue : 1
             */

            private String paramName;
            private String paramValue;

            public String getParamName() {
                return paramName;
            }

            public void setParamName(String paramName) {
                this.paramName = paramName;
            }

            public String getParamValue() {
                return paramValue;
            }

            public void setParamValue(String paramValue) {
                this.paramValue = paramValue;
            }
        }
    }
}
