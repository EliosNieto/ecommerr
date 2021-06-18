package com.ias.ecommerce.application.commons;

public class StringUtils {

    public static boolean nonBlank(String value) {
        String trimmed = value.trim();
        return trimmed.length() > 0;
    }

    public static boolean isValueNull(String value){
        return value == null;
    }
}
