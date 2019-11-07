package com.paopao.mycloud.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class SmnUtil {

	private static Logger logger = LoggerFactory.getLogger(SmnUtil.class);

	public static boolean confirmSubscription(String subscribeUrl) {
		JSONObject jsonObj = RestTemplateUtil.getForObject(subscribeUrl);
		if (jsonObj == null) {
			logger.error("confirmSubscription goes wrong , please check the subscribeUrl!");
			return false;
		}
		logger.info("response for confirmSubscription:" + jsonObj.toString());
		return true;
	}

}
