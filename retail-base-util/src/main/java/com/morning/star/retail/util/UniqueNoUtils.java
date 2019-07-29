package com.morning.star.retail.util;

import com.morning.star.redis.Redis;

import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 唯一单号生成器
 */
public class UniqueNoUtils {

    public enum UniqueNoType {
        SO, // 订单号
        SU, // 子订单号
        DO, // 交易号
        P, // 支付请求号
        CID, // 匿名用户唯一号
        WITHDRAW, // 提现申请号
        RA, // 退款申请
        PAY, // 付款
        SE, // 结算单号
        PRE, // 预付款结算单
        PR, // 采购单号
        PRIN, // 采购入库单号
        RS,// 入库单
        R, // 退款单号
        C, // 优惠券批次号Coupon
        POS, // POS商品
        PG, // POS订单
        CTM, // POS售后订单
        MP, // 创客余额支付流水号
        REP, // 补货编号
        BH, // 补货编号
        DEL, // 送货编号
        PD, // 库存盘点编号
        CDD, // 库存盘点长短单
        SAP, // SAP库存导入编号,
        SPU, // SUP编号
        PC,  //货品编码（product_code）
        GC, // 货品编号(goods_code)
        GSC, // 供货商品编号(goods_supply_code)
        IC, // 商品编号（item_code）
        ASC,    // 售后订单(after_sales_code)
        RI,        // requestId
        AC,    // 活动code(activity code)
        JSD, //账期结算单
        RO,
        DC,    // 快递号
        CC,    // companyCode
        DB,    // 库存调拨单号
        OSC,    // 出库单号
        SC,  // 供应商编码
        STC,  // 供应商类别编码
        SCC,  // 供应商变更单编码
        TJD,     //调价单
        G,     //分工公司商品编号
        RDS // 入库差异单
    }

    private static Calendar cal = Calendar.getInstance();
    private static int seq = 0;
    private static final int ROTATION = 999;
    private static int ipMix = 0;

    /**
     * 订单号生成规则：时间戳（精确到秒）+最后一段的IP地址+序列号
     *
     * @return 唯一订单号
     */
    public static synchronized String next(UniqueNoType type) {
        if (seq > ROTATION) {
            seq = 0;
        }
        checkinfo();
        cal.setTimeInMillis(System.currentTimeMillis());
        return type + String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS%2$03d%3$03d", cal, ipMix, seq++).substring(2);
    }

    public static synchronized String nextInc(UniqueNoType type, int size) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        checkinfo();
        cal.setTimeInMillis(System.currentTimeMillis());

        String day = sdf.format(cal.getTime());

        Long suf = Context.getBean(Redis.class).incro(type + day);
        String sufStr = String.valueOf(suf);
        int zeroSize = size - sufStr.length();
        for(int i = 0; i < zeroSize; i++) {
            sufStr = "0" + sufStr;
        }
        return type + day + sufStr;
    }

    public static synchronized String nextInc(UniqueNoType type, String str, int size) {
        checkinfo();
        Long suf = Context.getBean(Redis.class).incro(type + str);
        String sufStr = String.valueOf(suf);
        int zeroSize = size - sufStr.length();
        for(int i = 0; i < zeroSize; i++) {
            sufStr = "0" + sufStr;
        }
        return type + str + sufStr;
    }

    private static void checkinfo() {
        if (ipMix == 0) {
            try {
                String ipAddress = Inet4Address.getLocalHost().getHostAddress();
                String[] ipAddresses = ipAddress.split("\\.");
                ipMix = Integer.parseInt(ipAddresses[3]);
            } catch (Exception e) {
                ipMix = 1;
            }
        }
    }

    public static synchronized String next() {
        if (seq > ROTATION) {
            seq = 0;
        }
        checkinfo();
        cal.setTimeInMillis(System.currentTimeMillis());
        return String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS%2$03d%3$03d", cal,
                ipMix, seq++);
    }

    public static synchronized String nextNew(UniqueNoType type, String storeCode) {
        Integer storeId = 0;
        if (seq > ROTATION) {
            seq = 0;
        }
        try {
            String ipAddress = Inet4Address.getLocalHost().getHostAddress();
            String[] ipAddresses = ipAddress.split("\\.");
            ipMix = Integer.parseInt(ipAddresses[3]);
            if (storeCode.length() > 2) {
                storeCode = storeCode.substring(storeCode.length() - 2);
            }
            storeId = Integer.parseInt(storeCode);
        } catch (Exception e) {
            ipMix = 1;
        }

        cal.setTimeInMillis(System.currentTimeMillis());
        //日期+门店code+3位序号
        return type + String.format("%1$tY%1$tm%1$td%2$02d%3$03d%4$03d", cal, storeId, ipMix, seq++).substring(2);
    }

    public static synchronized Long getId() {
        cal.setTimeInMillis(System.currentTimeMillis());
        String str = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", cal) + RandomUtil.generateNumString(4);
        return Long.parseLong(str);
    }

}
