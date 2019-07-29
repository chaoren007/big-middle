package com.morning.star.retail.pay.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * httpclient 工具类
 *
 * @author luobh
 * @date 2016年6月6日
 */
public class HttpClientUtil {

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int HTTP_CONNECT_TIMEOUT = 30000;
    private static final int HTTP_CONNECTION_REQUEST_TIMEOUT = 10000;
    private static final int HTTP_SOCKET_TIMEOUT = 30000;

    private static RequestConfig DEFAULT_HTTP_REQUEST_CONFIG = RequestConfig.custom()
            .setConnectTimeout(HTTP_CONNECT_TIMEOUT)
            .setConnectionRequestTimeout(HTTP_CONNECTION_REQUEST_TIMEOUT)
            .setSocketTimeout(HTTP_SOCKET_TIMEOUT)
            .build();

    /**
     * 提交普通表单
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String post(String url, Map<String, String> params)
            throws IOException {
        HttpPost post = postForm(url, params, DEFAULT_ENCODING);
        return invoke(post);
    }

    /**
     * 提交普通表单
     *
     * @param url
     * @param encoding
     * @param params
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String post(String url, String encoding, Map<String, String> params)
            throws IOException {
        HttpPost post = postForm(url, params, encoding);
        return invoke(post);
    }

    /**
     * get请求
     *
     * @param url
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String get(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        get.setConfig(DEFAULT_HTTP_REQUEST_CONFIG);
        return invoke(get);
    }

    /**
     * JSON post
     *
     * @param url
     * @param jsonReq
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String postJson(String url, String jsonReq) throws IOException {
        return postJson(url, DEFAULT_ENCODING, jsonReq);
    }

    /**
     * JSON post
     *
     * @param url
     * @param encoding
     * @param jsonReq
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String postJson(String url, String encoding, String jsonReq) throws IOException {
        HttpPost post = new HttpPost(url);
//		post.setConfig(DEFAULT_HTTP_REQUEST_CONFIG);
        StringEntity s = new StringEntity(jsonReq);
//		s.setContentEncoding(encoding);
        s.setContentType("application/json");
        post.addHeader("Content-Type", "application/json");
        post.setEntity(s);
        return invoke(post);
    }

    /**
     * xml post
     *
     * @param url
     * @param xmlReq
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String postXml(String url, String xmlReq) throws IOException {
        return postXml(url, DEFAULT_ENCODING, xmlReq);
    }

    /**
     * xml post
     *
     * @param url
     * @param encoding
     * @param xmlReq
     * @return
     * @throws IOException
     * @author luobh
     * @date 2016年6月6日
     */
    public static String postXml(String url, String encoding, String xmlReq) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setConfig(DEFAULT_HTTP_REQUEST_CONFIG);
        StringEntity s = new StringEntity(xmlReq);
        s.setContentEncoding(encoding);
        s.setContentType("text/xml");
        post.setEntity(s);
        return invoke(post);
    }

    private static String invoke(HttpUriRequest httpost) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse response;
        response = client.execute(httpost);
        String body = paseResponse(response);
        client.close();
        return body;
    }

    private static String paseResponse(HttpResponse response)
            throws IOException {
        HttpEntity entity = response.getEntity();
        ContentType contentType = ContentType.getOrDefault(entity);
        String body = EntityUtils.toString(entity, contentType.getCharset());
        if (response.getStatusLine().getStatusCode() < HttpStatus.SC_BAD_REQUEST) {
            return body;
        } else {
            throw new IOException("请求异常["
                    + response.getStatusLine().getStatusCode() + "]:" + body);
        }
    }

    private static HttpPost postForm(String url, Map<String, String> params, String encoding) {
        HttpPost post = new HttpPost(url);
        post.setConfig(DEFAULT_HTTP_REQUEST_CONFIG);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (MapUtils.isNotEmpty(params)) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, encoding));
        } catch (UnsupportedEncodingException e) {
            // 此处代码块不会进来
            throw new RuntimeException(e);
        }
        return post;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally { // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally { //使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 把数据对象转换成 name1=value1&name2=value2 形式的参数
     *
     * @param object 对象
     * @return
     */
    public static String convertURLParams(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for (Field field : fields) {
            sb.append(field.getName()).append("=").append(getFieldValue(field.getName(), object)).append("&");
        }
        if (sb != null) {
            return sb.substring(0, sb.lastIndexOf("&"));
        }
        return null;
    }

    /**
     * 获取属性值
     *
     * @param fieldName 属性名
     * @param object    对象
     * @return
     */
    private static Object getFieldValue(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[]{});
            return method.invoke(object, new Object[]{});
        } catch (Exception e) {
            return null;
        }
    }

}
