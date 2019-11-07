package com.paopao.mycloud.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

/**
 * restful远程调用工具
 * 
 * @author pp
 *
 */
public class RestTemplateUtil {

	private static Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

	private static final MediaType DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON_UTF8;

	/**
	 * get方式获取返回实体 无参
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> ResponseEntity<JSONObject> getForEntity(String url) {
		return getForEntity(url, null);
	}

	/**
	 * get方式获取响应体 无参
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> JSONObject getForObject(String url) {
		return getForObject(url, null);
	}

	/**
	 * get方式获取返回实体 带入参
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> ResponseEntity<JSONObject> getForEntity(String url, Map<String, Object> params) {

		RestTemplate rt = new RestTemplate();
		if (StringUtils.isBlank(url)) {
			logger.error("url为空！");
			return null;
		}
		ResponseEntity<JSONObject> responseEntity;
		if (params == null) {
			responseEntity = rt.getForEntity(url, JSONObject.class);
		} else {
			responseEntity = rt.getForEntity(url, JSONObject.class, params);
		}
		return responseEntity;
	}

	/**
	 * get方式获取响应体带入参
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> JSONObject getForObject(String url, Map<String, Object> params) {

		RestTemplate rt = new RestTemplate();
		if (StringUtils.isBlank(url)) {
			logger.error("url为空！");
			return null;
		}
		JSONObject jsonObj;
		if (params == null) {
			jsonObj = rt.getForObject(url, JSONObject.class);
		} else {
			jsonObj = rt.getForObject(url, JSONObject.class, params);
		}
		return jsonObj;
	}

	/**
	 * 返回对象为ResponseEntity,包含响应体和响应头信息等
	 * 
	 * @param <T>
	 * 
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息Map
	 * @param params
	 *            请求参数Map
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> ResponseEntity<JSONObject> postForEntity(String url, T params) throws URISyntaxException {
		return postForEntity(url, null, null, params);
	}

	/**
	 * 返回对象为ResponseEntity,包含响应体和响应头信息等
	 * 
	 * @param <T>
	 * 
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息Map
	 * @param params
	 *            请求参数Map
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> ResponseEntity<JSONObject> postForEntity(String url, MultiValueMap<String, String> headers,
			T params) throws URISyntaxException {
		return postForEntity(url, null, headers, params);
	}

	/**
	 * 返回对象为ResponseEntity,包含响应体和响应头信息等
	 * 
	 * @param <T>
	 * 
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息Map
	 * @param contentType
	 *            请求类型
	 * @param params
	 *            请求参数Map
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> ResponseEntity<JSONObject> postForEntity(String url, MediaType contentType,
			MultiValueMap<String, String> headers, T params) throws URISyntaxException {

		RestTemplate rt = new RestTemplate();
		URI uri = new URI(url);
		BodyBuilder bodyBuilder = RequestEntity.post(uri);
		if (contentType == null) {
			contentType = DEFAULT_MEDIA_TYPE;
		}
		bodyBuilder.contentType(contentType);

		// 将头信息写入request中
		if (headers != null && !headers.isEmpty()) {
			for (Entry<String, List<String>> e : headers.entrySet()) {
				bodyBuilder.header(e.getKey(), e.getValue().toArray(new String[e.getValue().size()]));
			}
		}

		// 将参数写入requestBody
		RequestEntity<T> requestEntity = bodyBuilder.body(params);
		ResponseEntity<JSONObject> responseEntity = rt.postForEntity(url, requestEntity, JSONObject.class);

		return responseEntity;
	}

	/**
	 * 使用默认json格式 返回对象为JSONObject,只有响应体
	 * 
	 * @param <T>
	 * 
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息Map
	 * @param params
	 *            请求参数Map
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> JSONObject postForObject(String url, MultiValueMap<String, String> headers, T params)
			throws URISyntaxException {

		return postForObject(url, null, headers, params);
	}

	/**
	 * 返回对象为JSONObject,只有响应体
	 * 
	 * @param <T>
	 * 
	 * @param url
	 *            请求地址
	 * @param headers
	 *            请求头信息Map
	 * @param contentType
	 *            请求类型
	 * @param params
	 *            请求参数Map
	 * @return
	 * @throws URISyntaxException
	 */
	public static <T> JSONObject postForObject(String url, MediaType contentType, MultiValueMap<String, String> headers,
			T params) throws URISyntaxException {

		RestTemplate rt = new RestTemplate();
		URI uri = new URI(url);
		BodyBuilder bodyBuilder = RequestEntity.post(uri);
		if (contentType == null) {
			contentType = DEFAULT_MEDIA_TYPE;
		}
		bodyBuilder.contentType(contentType);

		// 将头信息写入request中
		if (headers != null && !headers.isEmpty()) {
			for (Entry<String, List<String>> e : headers.entrySet()) {
				bodyBuilder.header(e.getKey(), e.getValue().toArray(new String[e.getValue().size()]));
			}
		}

		// 将参数写入requestBody
		RequestEntity<T> requestEntity = bodyBuilder.body(params);
		JSONObject jsonObj = rt.postForObject(url, requestEntity, JSONObject.class);

		return jsonObj;
	}

}
