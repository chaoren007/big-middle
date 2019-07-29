package com.morning.star.retail.base.service;

import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.bean.AdminLoginContent;

public interface ImportService {
	
	/**
	 * 批量导入文件，每次处理一条不考虑事物一致性
	 * @param file	导入的文件
	 * @param type	导入文件的类型
	 */
	public void importDataForOnce(MultipartFile file,AdminLoginContent userInfo);
	
	/**
	 * 批量导入文件，每次处理一条不考虑事物一致性
	 * @param file
	 * @param type
	 */
	public void importDataForBatch(MultipartFile file,AdminLoginContent userInfo);

}
