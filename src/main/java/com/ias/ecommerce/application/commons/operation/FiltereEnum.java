package com.ias.ecommerce.application.commons.operation;

public class FiltereEnum {

    public static <T extends Enum<T>> T filter(Class<T> t, String value){
        T result;
        try {
            result = Enum.valueOf(t,value);
        }catch (IllegalArgumentException e){
            System.out.println("----------------");
            throw new RuntimeException("Value is not status valid: "+value);
        }

        return result;
    }

}
