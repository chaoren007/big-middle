package com.morning.star.retail.admin.filter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 8429366735826798918L;

	private Long id;
	private String name;
	
	private Map<String, String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public String getTag(String key) {
		return tags == null ? null : tags.get(key);
	}

	public void setTag(String key, String value) {
		if(tags == null) {
			tags = new HashMap<>();
		}
		tags.put(key, value);
	}

}
