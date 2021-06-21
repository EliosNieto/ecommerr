package com.ias.ecommerce.application.commons;

import java.util.regex.Pattern;

public class NonEmptyInteger {

    private Integer value;

    private final Pattern pattern = Pattern.compile("^[+-]?[0-9]{1,9}(?:.[0-9]{1,2})?$");

    public NonEmptyInteger(String value) {
        Validate.notNull(value, "NonEmptyInteger can not null");
        Validate.isTrue(StringUtils.nonBlank(value),"NonEmptyInteger can not empty");
        Validate.isTrue(pattern.matcher(value).matches(), "NonEmptyInteger value is not number");

        this.value = NumberUtils.toInt(value);
    }


    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyInteger{" +
                "value=" + value +
                '}';
    }
}
