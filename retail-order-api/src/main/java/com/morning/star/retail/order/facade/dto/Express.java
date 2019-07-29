package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Express implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String companyCode;
    private String companyName;
    
    public Express() {
    }
    public Express(String companyCode, String companyName) {
        this.companyCode = companyCode;
        this.companyName = companyName;
    }
    public String getCompanyCode() {
        return companyCode;
    }
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public static List<Express> list() {
        List<Express> list = new ArrayList<>();
        list.add(new Express("ziying", "自营"));
        list.add(new Express("dada", "达达快递"));
        list.add(new Express("other", "其他"));
//        list.add(new Express("shunfeng", "顺丰快递"));
//        list.add(new Express("zhongtong", "中通快递"));
//        list.add(new Express("shentong", "申通快递"));
        return list;
    }
    
    
}
