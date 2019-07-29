package com.morning.star.retail.admin;

import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.*;
import com.morning.star.retail.shiro.exception.InvalidException;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	@ResponseBody
	public ResponseEntity<WebJsonBean> illegalArgumentExceptionHandler(IllegalArgumentException e) {
		return ResponseEntity.ok().body(new WebJsonBean(CODE.API_IS_ERROR.getIndex(),
			e.getMessage()));
	}

	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public ResponseEntity<WebJsonBean> nullPointerException(NullPointerException e) {
		return ResponseEntity.ok().body(new WebJsonBean(CODE.API_IS_ERROR.getIndex(),
			e.getMessage()));
	}

	@ExceptionHandler(value = ShiroException.class)
	@ResponseBody
	public ResponseEntity<WebJsonBean> shiroExceptionHandler(ShiroException e) {
		WebJsonBean result;
		if (e instanceof AuthenticationException) { // shiro认证异常
			result = new WebJsonBean(Integer.valueOf(LoginAccountErrorCode.LOGIN_ACCOUNT_ERROR.getErrorCode()),
				LoginAccountErrorCode.LOGIN_ACCOUNT_ERROR.getErrorMsg());
		} else if (e instanceof AuthorizationException) { // shiro鉴权异常
			result = new WebJsonBean(Integer.valueOf(AccessErrorCode.LOGIN_ACCOUNT_NO_ACCESS.getErrorCode()),
				AccessErrorCode.LOGIN_ACCOUNT_NO_ACCESS.getErrorMsg());
		} else if (e instanceof InvalidException) { // shiro失效异常
			result = new WebJsonBean(Integer.valueOf(LoginAccountErrorCode.LOGIN_ACCOUNT_INVALID.getErrorCode()),
				LoginAccountErrorCode.LOGIN_ACCOUNT_INVALID.getErrorMsg());
		} else { // 其他shiro异常
			result = new WebJsonBean(Integer.valueOf(RetailErrorCode.OTHER_SHIRO_ERROR.getErrorCode()),
				RetailErrorCode.OTHER_SHIRO_ERROR.getErrorMsg());
		}
		return ResponseEntity.ok().body(result);
	}

	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public ResponseEntity<WebJsonBean> retailExceptionHandler(BizException e) {
		return ResponseEntity.ok().body(new WebJsonBean(e.getCode(), e.getMessage()));
	}

}
