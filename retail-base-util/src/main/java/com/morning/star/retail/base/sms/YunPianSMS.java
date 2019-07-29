package com.morning.star.retail.base.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ytx.org.apache.http.HttpEntity;
import ytx.org.apache.http.HttpResponse;
import ytx.org.apache.http.NameValuePair;
import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.client.entity.UrlEncodedFormEntity;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.conn.ClientConnectionManager;
import ytx.org.apache.http.conn.scheme.Scheme;
import ytx.org.apache.http.conn.scheme.SchemeRegistry;
import ytx.org.apache.http.conn.ssl.SSLSocketFactory;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.message.BasicNameValuePair;
import ytx.org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * 云片短信服务 API V2.0
 *
 * @author prin.wei
 */
@Component
public class YunPianSMS implements SMS {
    private static final Logger LOGGER = LoggerFactory.getLogger(YunPianSMS.class);
    private static String yunpian_apikey = "f31085aef1568285bd0c553381cca027";
    private static String yunpian_sendMessageUrl = "https://sms.yunpian.com/v2/sms/single_send.json";

    public boolean sendSMS(String phone, String content) {
        try {
            HttpClient httpclient = new SSLClient();
            HttpPost httpPost = new HttpPost(yunpian_sendMessageUrl);
            String result = null;
            //设置参数  
            Map<String, String> params = new HashMap<String, String>();//请求参数集合
            params.put("apikey", yunpian_apikey);
            params.put("text", content);
            params.put("mobile", phone);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpclient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }
            //处理结果
            LOGGER.info("YunPianMessageUtil\tyunpian_apikey:{},phone:{},result:{}", yunpian_apikey, phone, result);
            JSONObject jsonObj = JSON.parseObject(result);
            String code = jsonObj.getString("code");
            Validate.isTrue(!("22".equals(code) || "33".equals(code)), "发送短信验证码操作次数频繁，请稍等1小时后再操作");

            if ("0".equals(code)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LOGGER.info("YunPianMessageUtil\terr:" + e, e);
            System.out.println("" + e);
        }
        return true;
    }

    public static class SSLClient extends DefaultHttpClient {
        public SSLClient() throws Exception {
            super();
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = this.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
        }
    }

//    public static void main(String[] args) {
//        String message = String.format("您的验证码是%s。如非本人操作，请忽略本短信", "123456");
//
//        try {
//            new YunPianSMS().sendSMS("18779885539", message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
