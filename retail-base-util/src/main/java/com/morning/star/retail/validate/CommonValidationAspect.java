package com.morning.star.retail.validate;

import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.collections.MapUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 新零售共用校验组件
 *
 * @author zhouwen
 */
@Aspect
@Component
public class CommonValidationAspect {

	@Around("@annotation(validate)")
	public Object validate(ProceedingJoinPoint joinPoint, Validate validate) throws Throwable {
		return handleValidate(joinPoint, validate);
	}


	/**
	 * 执行切面around
	 *
	 * @param joinPoint
	 * @param
	 * @return
	 * @throws Throwable
	 */
	private Object handleValidate(ProceedingJoinPoint joinPoint, Validate validate)
		throws Throwable {
		try {
			if (validate != null) {
				Object[] args = joinPoint.getArgs();
				if (args != null) {
					for (Object arg : args) {
						if (arg != null) {  // 不检验null参数

							if (arg instanceof List) {
								for (Object o : (List) arg) {
									validateArg(o, validate, joinPoint);
								}
							} else {
								validateArg(arg, validate, joinPoint);
							}
						}
					}
				}
			}
		} catch (Exception exp) {
			// 记录信息并抛出异常 这里处理所有的异常，以免干扰方法正常进行
			throw exp;
		}

		// 进行方法
		Object object = joinPoint.proceed(joinPoint.getArgs());
		return object;

	}


	private void validateArg(Object arg, Validate validate, ProceedingJoinPoint joinPoint) {
		//执行校验
		ValidationResult result = ValidateUtils.validateEntity(arg, validate.groups());
		//校验不通过默认抛出异常
		if (result.getErrorCode() != ValidationResult.SUCCESS && validate.exception()) {
			String errorMeg = "参数错误;  ";
			if (result.getErrorMsg() != null && MapUtils.isNotEmpty(result.getErrorMsg())) {
				for (Map.Entry<String, String> entry : result.getErrorMsg().entrySet()) {
					String str = null;
					try {
						str = getMessage(entry.getValue());
					} catch (Exception e) {
						str = entry.getKey() + " - " + entry.getValue();
					}
					errorMeg += (str + ";");
				}
			}

			throw new IllegalArgumentException(errorMeg);
		}
	}


	private static ResourceBundle BUNDLE = null;

	static {
		try {
			BUNDLE = PropertyResourceBundle.getBundle("message");
		} catch (Exception e) {
		}
	}

	private static String getMessage(String key) {
		if (BUNDLE == null) {
			throw new MissingResourceException("message file not found", CommonValidationAspect.class.getName(), key);
		}
		return BUNDLE.getString(key);
	}

	public static void main(String[] args) {
		System.out.println(getMessage("aaaaaa"));
	}
}
