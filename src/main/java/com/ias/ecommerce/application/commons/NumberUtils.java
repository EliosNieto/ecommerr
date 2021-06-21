package com.ias.ecommerce.application.commons;

public class NumberUtils {



    /**
     * verify that the value is greater
     * @param value
     * @param greaterThan
     * @return
     */
    public static boolean numberGreaterThan( int value, int greaterThan ){
        return value > greaterThan;
    }

    /**
     * erify that the value is greater
     * @param value
     * @param greaterThan
     * @return
     */
    public static boolean doubleGreaterThan( double value, int greaterThan ){
        return value > greaterThan;
    }

    /**
     * convert string to double
     * @param value
     * @return
     */
    public static double toDouble(String value){
        return Double.parseDouble(value);
    }

    public static Long toLong(String value){
        return Long.parseLong(value);
    }

    public static int toInt(String value){
        return Integer.parseInt(value);
    }

}
