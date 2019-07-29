package com.morning.star.retail.admin;

import com.morning.star.retail.admin.util.WebBean;
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
	public ResponseEntity<WebBean<String>> illegalArgumentExceptionHandler(IllegalArgumentException e) {
		return ResponseEntity.ok().body(new WebBean<>(CODE.API_IS_ERROR.getIndex(),
			e.getMessage()));
	}

	@ExceptionHandler(value = ShiroException.class)
	@ResponseBody
	public ResponseEntity<WebBean<String>> shiroExceptionHandler(ShiroException e) {
		WebBean<String> result = null;
		if (e instanceof AuthenticationException) { // shiro认证异常
			result = new WebBean<>(Integer.valueOf(LoginAccountErrorCode.LOGIN_ACCOUNT_ERROR.getErrorCode()),
				LoginAccountErrorCode.LOGIN_ACCOUNT_ERROR.getErrorMsg());
		} else if (e instanceof AuthorizationException) { // shiro鉴权异常
			result = new WebBean<>(Integer.valueOf(AccessErrorCode.LOGIN_ACCOUNT_NO_ACCESS.getErrorCode()),
				AccessErrorCode.LOGIN_ACCOUNT_NO_ACCESS.getErrorMsg());
		} else if (e instanceof InvalidException) { // shiro失效异常
			result = new WebBean<>(Integer.valueOf(LoginAccountErrorCode.LOGIN_ACCOUNT_INVALID.getErrorCode()),
				LoginAccountErrorCode.LOGIN_ACCOUNT_INVALID.getErrorMsg());
		} else { // 其他shiro异常
			result = new WebBean<>(Integer.valueOf(RetailErrorCode.OTHER_SHIRO_ERROR.getErrorCode()),
				RetailErrorCode.OTHER_SHIRO_ERROR.getErrorMsg());
		}
		return ResponseEntity.ok().body(result);
	}

	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public ResponseEntity<WebBean<String>> retailExceptionHandler(BizException e) {
		return ResponseEntity.ok().body(new WebBean<>(e.getCode(), e.getMessage()));
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handle(Exception e) {
		return ResponseEntity.ok().body(WebBean.fail(e.getMessage()));
	}

}
