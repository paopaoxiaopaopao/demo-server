package com.paopao.mycloud.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Util {

	private static Logger logger = LoggerFactory.getLogger(MD5Util.class);

	public static String md5Encode(String inStr) throws UnsupportedEncodingException {

		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			logger.error("获取MD5实例异常：", e);
			return "";
		}

		byte[] bytes = inStr.getBytes("UTF-8");
		byte[] md5digest = md5.digest(bytes);
		StringBuilder hexValue = new StringBuilder();
		for (int i = 0; i < md5digest.length; i++) {
			int val = ((int) md5digest[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

}
