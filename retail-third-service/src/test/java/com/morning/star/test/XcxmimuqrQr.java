package com.morning.star.test;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class XcxmimuqrQr {
	
	public void getAsscToken() {
		RestTemplate rest = new RestTemplate();
		String url = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid={key1}&secret={key2}";
		String resylt = rest.getForObject(url, String.class, "wx7632f63bed017f40", "075434cc7d15142cb01a3adbeed8c345");
		Map<String, Object> jsonToMap = JSON.parseObject(resylt);
		System.out.println(jsonToMap.get("access_token"));

	}

	@Test
	public void test(){
			Gson json = new Gson();
			String str = "{\"error_code\": 1000,\"black_list\": [{ \"package_name\": \"com.tcl.tv\",\"activity_name\": \"com.tcl.tv.TVActivity\"},{\"package_name\": \"com.tcl.browser\",\"activity_name\": \"com.tcl.browser.SiteMapActivity\"}]}";

	}

	@Test
	public void getImg() throws IOException {
		RestTemplate rest = new RestTemplate();
		String url = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid={key1}&secret={key2}";
		String resylt = rest.getForObject(url, String.class, "wx7632f63bed017f40", "075434cc7d15142cb01a3adbeed8c345");
		Map<String, Object> jsonToMap = JSON.parseObject(resylt);
		String access_token = (String) jsonToMap.get("access_token");
		
		
		String url0 = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+access_token;
		Map<String, Object> param = new HashMap<>();
		param.put("scene", "111");
		param.put("page", "");
		param.put("width", 420);
		param.put("auto_color", false);
		//param.put("line_color", line_color);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		ResponseEntity<byte[]> entity = rest.exchange(url0, HttpMethod.POST,
				new HttpEntity<Map<String, Object>>(param, headers), byte[].class, new Object[0]);
		byte[] result = entity.getBody();
		InputStream inputStream = new ByteArrayInputStream(result);

		File file = new File("D:/1.png");
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream outputStream = new FileOutputStream(file);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = inputStream.read(buf, 0, 1024)) != -1) {
			outputStream.write(buf, 0, len);
		}
		outputStream.flush();
	}
}
