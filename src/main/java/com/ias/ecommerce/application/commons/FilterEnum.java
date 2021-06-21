package com.ias.ecommerce.application.commons;

public class FilterEnum {

    public static <T extends Enum<T>> T filter(Class<T> t, String value){
        T result;
        try {
            result = Enum.valueOf(t,value);
        }catch (RuntimeException e){
            throw new IllegalArgumentException("status not is valid: "+value);
        }
        return result;
    }

}
