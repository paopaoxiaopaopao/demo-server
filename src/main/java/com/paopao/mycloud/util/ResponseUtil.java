package com.paopao.mycloud.util;

import com.paopao.mycloud.common.Response;

public class ResponseUtil {

	/**
	 * 接口报错 ，返回前台
	 * 
	 * @param errorMessage
	 * @return
	 */
	public static <T> Response<T> result(String status, String message) {

		Response<T> result = new Response<T>();

		result.setStatus(status);
		result.setMessage(message);
		result.setResult(null);

		return result;
	}

	/**
	 * 接口报错 ，返回前台
	 * 
	 * @param errorMessage
	 * @return
	 */
	public static <T> Response<T> result(String status, String message, T t) {

		Response<T> result = new Response<T>();

		result.setStatus(status);
		result.setMessage(message);
		result.setResult(t);

		return result;
	}
}
