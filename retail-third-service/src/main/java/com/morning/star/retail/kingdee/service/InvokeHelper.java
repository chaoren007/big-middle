package com.morning.star.retail.kingdee.service;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2018/11/14 10:33
 **/

import com.morning.star.retail.dto.LoginDTO;
import com.morning.star.retail.utils.Json;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class InvokeHelper {
    public static String POST_K3CloudURL = "http://193.112.135.214/k3cloud/";

    @Value("${kingdee.dbId}")
    private  String  dbId;
    @Value("${kingdee.user}")
    private  String  user;
    @Value("${kingdee.pwd}")
    private  String  pwd;
    @Value("${kingdee.lang}")
    private  int lang;
    /**
     * 缓存
     */
    private static String CookieVal = null;

    private static Map map = new HashMap();
    static {
        map.put("Save",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save.common.kdsvc");
        map.put("View",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.View.common.kdsvc");
        map.put("Submit",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Submit.common.kdsvc");
        map.put("Audit",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Audit.common.kdsvc");
        map.put("UnAudit",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.UnAudit.common.kdsvc");
        map.put("StatusConvert",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.StatusConvert.common.kdsvc");
        map.put("Delete",
                "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Delete.common.kdsvc");
    }

    /**
     *
     * @param url
     * @param paras
     * @return
     * @throws Exception
     */
    private static HttpURLConnection initUrlConn(String url, JSONArray paras)
            throws Exception {
        URL postUrl = new URL(POST_K3CloudURL.concat(url));
        HttpURLConnection connection = (HttpURLConnection) postUrl
                .openConnection();
        if (CookieVal != null) {
            connection.setRequestProperty("Cookie", CookieVal);
        }
        //POST请求
        if (!connection.getDoOutput()) {
            connection.setDoOutput(true);
        }
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        DataOutputStream out = new DataOutputStream(
                connection.getOutputStream());

        UUID uuid = UUID.randomUUID();
        int hashCode = uuid.toString().hashCode();

        JSONObject jObj = new JSONObject();

        jObj.put("format", 1);
        jObj.put("useragent", "ApiClient");
        jObj.put("rid", hashCode);
        jObj.put("parameters", chinaToUnicode(paras.toString()));
        jObj.put("timestamp", new Date().toString());
        jObj.put("v", "1.0");

        out.writeBytes(jObj.toString());
        out.flush();
        out.close();

        return connection;
    }

    /**
     * 登陆
     * @return
     * @throws Exception
     */
    public  LoginDTO login()
            throws Exception {
        LoginDTO login = null;
        String sUrl = "Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc";
        JSONArray jParas = new JSONArray();
        // 帐套Id、用户名、密码、语言编码
        jParas.put(dbId);
        jParas.put(user);
        jParas.put(pwd);
        jParas.put(lang);

        HttpURLConnection connection = initUrlConn(sUrl, jParas);

        String key = null;
        for (int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++) {
            if (key.equalsIgnoreCase("Set-Cookie")) {
                String tempCookieVal = connection.getHeaderField(i);
                if (tempCookieVal.startsWith("kdservice-sessionid")) {
                    CookieVal = tempCookieVal;
                    break;
                }
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        System.out.println("============================= ");
        System.out.println("登陆中........");
        System.out.println("============================= ");
        while ((line = reader.readLine()) != null) {
            String sResult = new String(line.getBytes(), "utf-8");
            login = Json.jsonToDTO(sResult, LoginDTO.class);
        }
        reader.close();
        connection.disconnect();
        return login;
    }

    /**
     * 保存
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  save(String formId, String content) throws Exception {
        return Invoke("Save", formId, content);
    }

    /**
     * 查看
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  view(String formId, String content) throws Exception {
        return Invoke("View", formId, content);
    }

    /**
     * 提交
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  submit(String formId, String content) throws Exception {
        return Invoke("Submit", formId, content);
    }

    /**
     * 审核
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  audit(String formId, String content) throws Exception {
        return Invoke("Audit", formId, content);
    }

    /**
     * 反审核
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  unAudit(String formId, String content) throws Exception {
        return Invoke("UnAudit", formId, content);
    }

    /**
     * StatusConvert
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  statusConvert(String formId, String content)
            throws Exception {
        return Invoke("StatusConvert", formId, content);
    }

    /**
     * Delete
     * @param formId
     * @param content
     * @throws Exception
     */
    public  String  delete(String formId, String content)
            throws Exception {
        return Invoke("Delete", formId, content);
    }

    private  String Invoke(String deal, String formId, String content)
            throws Exception {

        String sResult = "";
        String sUrl = map.get(deal).toString();
        JSONArray jParas = new JSONArray();
        jParas.put(formId);
        jParas.put(content);

        HttpURLConnection connectionInvoke = initUrlConn(sUrl, jParas);

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connectionInvoke.getInputStream()));

        String line;
        System.out.println("============================= ");
        System.out.println("Invoke.........");
        System.out.println("============================= ");
        while ((line = reader.readLine()) != null) {
            sResult = new String(line.getBytes(), "utf-8");
        }
        reader.close();
        connectionInvoke.disconnect();
        return sResult;
    }

    /**
     * 把中文转成Unicode码
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            // 汉字范围 \u4e00-\u9fa5 (中文)
            if (chr1 >= 19968 && chr1 <= 171941) {
                result += "\\u" + Integer.toHexString(chr1);
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }
}

  
  
   