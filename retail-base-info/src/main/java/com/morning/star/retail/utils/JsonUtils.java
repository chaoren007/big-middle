package com.morning.star.retail.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonUtils {
	public static String arrayToJson(Object o) {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter()
		{
			@Override
			public boolean apply(Object source, String name, Object value)
			{
				return value == null;
			}
		});

		JSONArray json = JSONArray.fromObject(o, config);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		return str;
	}
	
	@SuppressWarnings("unchecked")
	public  static <T> List<T> jsonToArray(String str, Class<T> clazz) {
		JSONArray json = JSONArray.fromObject(str);
		@SuppressWarnings("deprecation")
		List<T> list = JSONArray.toList(json, clazz);
		return list;
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static <T> List<T> jsonToArray(String str, Class<T> clazz,Map<String, Class> map) {
		JSONArray json = JSONArray.fromObject(str);
		@SuppressWarnings("unchecked")
		List<T> list = JSONArray.toList(json, clazz, map);
		return list;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> jsonToMap(String json) {
		JSONObject jasonObject = JSONObject.fromObject(json);

		Map map = (Map)jasonObject;
		return map;
	}

	public static String beanToJson(Object o) {
		JSONObject json = JSONObject.fromObject(o);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		return str;
	}


}
