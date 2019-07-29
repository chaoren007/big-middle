package com.morning.star.retail.shiro.exception;

import org.apache.shiro.ShiroException;

/**
 * @author ethan
 * 登录状态失效异常
 */
public class InvalidException extends ShiroException {
	public InvalidException() {
		super();
	}

	public InvalidException(String message) {
		super(message);
	}

	public InvalidException(Throwable cause) {
		super(cause);
	}

	public InvalidException(String message, Throwable cause) {
		super(message, cause);
	}
}
