package com.morning.star.retail.consts;

/**
 * 新零售默认常量
 *
 * @author zhouwen
 */
public class RetailDefaultConst {

    /*************************** 图片 ***************************/

    public static final String IMG_URL = "http://img.central.morning-star.cn/";

    /*************************** 系统 ***************************/

    /**
     * 默认公司编码
     */
    public static final String DEFAULT_COMPANY_CODE = "";

    /**
     * 默认门店编码
     */
    public static final String DEFAULT_STORE_CODE = "";

    /**
     * 业务处理默认成功返回值
     */
    public static final int SUCCESS = 0;

    /*************************** 分页 ***************************/

    /**
     * 默认每页记录数（admin）
     */
    public static final int ADMIN_PAGE_SIZE = 20;
    /**
     * 默认每页记录数（pos）
     */
    public static final int POS_PAGE_SIZE = 10;
    /**
     * 默认每页记录数（app）
     */
    public static final int APP_PAGE_SIZE = 10;

    /*************************** 登录 ***************************/

    /**
     * 请求信息中的token统一名称
     */
    public static final String REQUEST_TOKEN = "token";
    /**
     * admin token key
     */
    public static final String ADMIN_TOKEN = "admin_token";
    /**
     * pos token key
     */
    public static final String POS_TOKEN = "pos_token";
    /**
     * POS设备秘钥字符串长度
     */
    public static final int KEY_LENGTH = 12;
    /**
     * 登录账户盐值字符串长度
     */
    public static final int SALT_LENGTH = 12;
    /**
     * 登录凭证token字符串长度
     */
    public static final int TOKEN_LENGTH = 8;
    /**
     * 登录凭证token有效期(单位：秒)
     */
    public static final int TOKEN_EXPIRE_TIME_S = 3600;
    /**
     * 登录凭证token有效期(单位：分)
     */
    public static final int TOKEN_EXPIRE_TIME_M = 60;
    /**
     * 登录凭证token有效期(单位：时)
     */
    public static final int TOKEN_EXPIRE_TIME_H = 1;

    /*************************** cookie ***************************/

    /**
     * 管理端cookie
     */
    public static final String ADMIN_COOKIE = "admin_cookie";
    /**
     * 上帝端cookie
     */
    public static final String GOD_COOKIE = "god_cookie";
    /**
     * 登录凭证cookie有效期(单位：秒)
     */
    public static final int COOKIE_EXPIRE_TIME_S = 6000;
    /**
     * 登录凭证cookie有效期(单位：分)
     */
    public static final int COOKIE_EXPIRE_TIME_M = 60;
    /**
     * 登录凭证cookie有效期(单位：时)
     */
    public static final int COOKIE_EXPIRE_TIME_H = 1;

    public static final String MODULE_NAME_KEY = "appName";
    public static final String REQUEST_ID_CREATOR_KEY = "request_id_creator";
    public static final String REQUEST_ID_KEY = "request_id";
    public static final String USER_ID_KEY = "user_id";

    public static final String METHOD_SEQUENCE_KEY = "method_sequence";

    /**
     * 登录账户会话key
     */
    public static final String ACCOUNT_SESSION_KEY = "account";

    /**
     * 您我您默认入驻城市-全国
     */
    public static final long DEFAULT_CITY_ID = 1;
    public static final String DEFAULT_CITY_NAME = "全国";

}
