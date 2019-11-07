package com.paopao.mycloud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {



    public static String changStr(String obj) {

        if (StringUtils.isBlank(obj)) {
            return null;
        }

        obj = obj.replace("%", "\\%");
        obj = obj.replace("\\", "\\\\");
        obj = obj.replace("+", "\\+");
        obj = obj.replace("_", "\\_");

        return obj;
    }

    /**
     * 
     * Method: getTimeStamp 
     * Description: 返回当前时间年月日时分秒毫秒 
     * param:  @return 参数说明 
     * Return: String 返回类型
     */
    public static String getTimeStamp() {
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");  
	    return sdf.format(date);
	}
       
    
}
