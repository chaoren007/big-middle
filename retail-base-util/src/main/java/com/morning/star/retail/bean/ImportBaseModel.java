package com.morning.star.retail.bean;

/**
 * 
 * @author zhouwen
 */
public class ImportBaseModel{

    

    
    /**
     * 错误编码
     */
    private int index;
	/**
	 * 错误描述
	 */
    private String key;
    /**
     * 
     */
    private String tags;

    
    /**
     * 错误代码基类
     */
    ImportBaseModel(int index,String key,String tags)
    {
    	this.index=index;
    	this.key=key;
    	this.tags=tags;
    }

    /**
     * 生成导入模板
     * @param index
     * @param key
     * @param tags
     * @return
     */
    public static ImportBaseModel gernateModel(int index,String key,String tags){
    	ImportBaseModel model = new ImportBaseModel(index,key,tags);
    	return model;
    }
    
   
    
    
    //getter and setter
    
	public void setIndex(int index) {
		this.index = index;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getIndex() {
		return index;
	}

	public String getKey() {
		return key;
	}

	public String getTags() {
		return tags;
	}
}
