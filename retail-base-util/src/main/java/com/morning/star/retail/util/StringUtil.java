package com.morning.star.retail.util;

/**
 * 字符串工具类
 *
 * @author jiangyf
 */
public class StringUtil {

    /**
     * 删除字符串最后一个分隔符
     *
     * @param str     目标字符串
     * @param spliter 分隔符
     * @return
     */
    public static String removeLastSpliter(String str, String spliter) {
        if (str == null || str.trim().length() == 0 || str.lastIndexOf(spliter) < 1) {
            return str;
        }
        return str.substring(0, str.lastIndexOf(spliter));
    }

}
