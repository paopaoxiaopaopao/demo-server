package com.paopao.mycloud.exception;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException() {
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
