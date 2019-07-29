package com.morning.star.retail.pay.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

public class WxPayKeyEntity implements WXPayConfig {
	private int ownerId;
	private String key;
	private String appID;
	private String mchID;
	private String sdbMchID;
	private String certLocalPath;
	private String certPassword;
	private byte[] certData;
	
	public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getSdbMchID() {
		return sdbMchID;
	}
	public void setSdbMchID(String sdbMchID) {
		this.sdbMchID = sdbMchID;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getMchID() {
		return mchID;
	}
	public void setMchID(String mchID) {
		this.mchID = mchID;
	}
	public String getCertLocalPath() {
		return certLocalPath;
	}
	public void setCertLocalPath(String certLocalPath) {
		this.certLocalPath = certLocalPath;
	}
	public String getCertPassword() {
		return certPassword;
	}
	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}
    public byte[] getCertData() {
        return certData;
    }
    public void setCertData(byte[] certData) {
        this.certData = certData;
    }
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }
    @Override
    public int getHttpConnectTimeoutMs() {
        return 6*1000;
    }
    @Override
    public int getHttpReadTimeoutMs() {
        return 8*1000;
    }
	
}
