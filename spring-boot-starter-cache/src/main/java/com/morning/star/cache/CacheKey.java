package com.morning.star.cache;

public enum  CacheKey {
    UNKNOWN("", " 默认"),
    COLUMN2("column2_{0}_{1}", "首页分类"),
    COLUMN("column_{0}", "首页分类"),
    LIST_COLUMN_IN_MODULE("list_column_in_module_{0}", "查询栏目信息"),
    GOODS_ACTIVITY_IN_COLUMN("goods_activity_in_column_{0}", "首页栏目的商品活动线下"),
    USER_COLUMN("user_column_{0}_{1}", "用户栏目"),
    SEARCH_GOODS_ON_CODE("search_goods_on_code_{0}_{1}", "admin搜索商品"),
    SEARCH_GOODS_ON_CID("search_goods_on_cid_{0}_{1}_{2}", "admin搜索某已分类的商品"),
    ;


    private String val;
    private String desc;

    CacheKey(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }
}
