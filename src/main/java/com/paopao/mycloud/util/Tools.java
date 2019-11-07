package com.paopao.mycloud.util;


public class Tools {

    public static String clearTrim(Object obj) {

        String result = "";
        if (obj != null)
            result = obj.toString();
        if (result != null)
            result = result.trim();
        if ("null".equals(obj))
            return "";
        return result;
    }
}
