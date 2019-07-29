package com.morning.star.retail.stock.mq;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * @author jiangyf
 */
public class Test {

    public static void main(String[] args) {
        StringBuilder goodsCodes = new StringBuilder();

        System.out.println(StringUtils.isBlank(goodsCodes.toString()));
        Validate.isTrue(StringUtils.isBlank(goodsCodes.toString()), String.format("提交商品数据【商品编码：%s】存在重复，请检查"), "1111");

    }

}
