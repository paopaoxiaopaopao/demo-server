package com.paopao.mycloud.common;

import java.io.Serializable;

/**
 * @author pp
 *
 * @param <T>
 */
public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7011292652266997778L;

	public static final String SUCCESS = "success";

	public static final String FAILED = "failed";

	/**
	 * success或者failed
	 */
	private String status;

	/**
	 * 返回信息简述
	 */
	private String message;

	/**
	 * 返回结果集
	 */
	private T result;

	public Response() {

	}

	public Response(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(String status, String message, T result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
