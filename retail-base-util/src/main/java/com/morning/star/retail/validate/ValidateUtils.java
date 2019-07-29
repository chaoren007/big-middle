package com.morning.star.retail.validate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;

/**
 * 共用校验组件
 * @author zhouwen
 */
public class ValidateUtils {

private static Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();
	
	/**
	 * 使用校验框架统一校验对象
	 * @param obj	需要校验的对象
	 * @return 校验结果
	 */
	public static <T> ValidationResult validateEntity(T obj){
		ValidationResult result = new ValidationResult();
		 Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
		 if(CollectionUtils.isNotEmpty(set) ){
			 Map<String,String> errorMsg = new HashMap<String,String>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			 }
			 result.setErrorMsg(errorMsg);
		 }
		 return result;
	}
	
	/**
	 * 使用校验框架统一按分组校验对象
	 * @param obj		需要校验的对象
	 * @param groups	·	··	
	 * @return
	 */
	public static <T> ValidationResult validateEntity(T obj,Class<?>... groups){
		ValidationResult result = new ValidationResult();
		 Set<ConstraintViolation<T>> set = validator.validate(obj,groups);
		 if( CollectionUtils.isNotEmpty(set) ){

			 result.setErrorCode(ValidationResult.FAIL);
			 Map<String,String> errorMsg = new HashMap<String,String>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			 }
			 result.setErrorMsg(errorMsg);
		 }
		 return result;
	}
	
	
	/**
	 * 校验某个属性是否异常
	 * @param obj			需校验对象
	 * @param propertyName	需校验的从参数
	 * @return
	 */
	public static <T> ValidationResult validateProperty(T obj,String propertyName){
		ValidationResult result = new ValidationResult();
		 Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName,Default.class);
		 if( CollectionUtils.isNotEmpty(set) ){
			 result.setErrorCode(ValidationResult.FAIL);
			 Map<String,String> errorMsg = new HashMap<String,String>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(propertyName, cv.getMessage());
			 }
			 result.setErrorMsg(errorMsg);
		 }
		 return result;
	}
}
