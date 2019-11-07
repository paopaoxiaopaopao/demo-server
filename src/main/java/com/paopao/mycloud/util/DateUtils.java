package com.paopao.mycloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	
	/**
	 * 转化string类型的标准时间为date类型
	 * "Thu May 23 2019 10:29:57 GMT+0800 (中国标准时间) 00:00:00"
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByStr(String dateStr) throws ParseException {
		
		if(StringUtils.isBlank(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);		
		Date date = sdf.parse(dateStr);
		return date;
	}
}
