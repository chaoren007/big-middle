package com.morning.star.retail.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int code;


	/**
	 * 异常
	 * @param code
	 * @param msg
	 */
	public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }
	
	/**
	 * 异常
	 * @param code
	 * @param msg
	 * @param e
	 */
    public BizException(int code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
    }


	public int getCode() {
		return code;
	}

}
