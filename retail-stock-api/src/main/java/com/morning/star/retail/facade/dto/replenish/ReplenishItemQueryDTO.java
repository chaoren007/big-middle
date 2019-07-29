package com.morning.star.retail.facade.dto.replenish;

import java.io.Serializable;

public class ReplenishItemQueryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String replenishCode;
    private String keyWord;
    private Integer page;
    private Integer pageSize;

    public String getReplenishCode() {
        return replenishCode;
    }

    public void setReplenishCode(String replenishCode) {
        this.replenishCode = replenishCode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
