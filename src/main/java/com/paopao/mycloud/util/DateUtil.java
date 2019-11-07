package com.paopao.mycloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DateUtil 
 * Description: 日期相关类
 * Author: wujiyuan
 * Date: 2019年5月24日 上午10:42:10
 */
public class DateUtil {
    
    /**
     * 日期格式:yyyy-MM-dd
     */
    public static final String C_DATA_PATTON_YYYYMMDD = "yyyy-MM-dd";
    
    /**
     * 日期格式:yyyy-MM-dd
     */
    public static final String C_DATA_PATTON_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    /**
     * Method: getCurrentDateStr 
     * Description: 获取当前时间 格式 yyyy-MM-dd 
     * param:  @return 参数说明 
     * Return: String 返回类型
     */
    public static String getCurrentDateStr() {

        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        return format(currDate, C_DATA_PATTON_YYYYMMDDHHMMSS);
    }
    
    /**
     * Method: getCurrentDateStr 
     * Description: 获取当前时间 格式 yyyy-MM-dd HH:mm:ss
     * param:  @return 参数说明 
     * Return: String 返回类型
     */
    public static String getCurrentDateStrTime() {

        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        return format(currDate, C_DATA_PATTON_YYYYMMDD);
    }
    
    /**
     * Method: format 
     * Description: 格式化时间 Date转成String
     * param:  @param aTs_Datetime
     * param:  @param as_Pattern
     * param:  @return 参数说明 
     * Return: String 返回类型
     */
    public static String format(Date aTs_Datetime, String as_Pattern) {

        if (aTs_Datetime == null || as_Pattern == null) {
            return null;
        } else {
            SimpleDateFormat dateFromat = new SimpleDateFormat();
            dateFromat.applyPattern(as_Pattern);
            return dateFromat.format(aTs_Datetime);
        }
    }
    
    /**
     * Method: parseDate 
     * Description: 格式化时间 String转成Date
     * param:  @param strFormat
     * param:  @param dateValue
     * param:  @return 参数说明 
     * Return: Date 返回类型
     */
    public static Date parseDate(String strFormat, String dateValue) {

        String _strFormat = strFormat;
        if (dateValue == null) {
            return null;
        }
        if (_strFormat == null) {
            _strFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(_strFormat);
        Date newDate = null;
        try {
            newDate = dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            newDate = null;
        }
        return newDate;
    }
}
