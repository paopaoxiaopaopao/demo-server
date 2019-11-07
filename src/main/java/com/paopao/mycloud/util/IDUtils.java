package com.paopao.mycloud.util;

import java.util.UUID;

public class IDUtils {

	
	
	/**
	 * 获取一个uuid
	 * @return
	 */
	public static String getUuid() {
		
		return UUID.randomUUID().toString().replace("-", "");
	}
}
