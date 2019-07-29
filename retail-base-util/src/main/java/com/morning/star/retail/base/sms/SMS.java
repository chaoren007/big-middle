package com.morning.star.retail.base.sms;

public interface SMS {
    boolean sendSMS(String phone, String msg) throws Exception;
}
