package com.ias.ecommerce.application.commons;

import java.util.regex.Pattern;

import static com.ias.ecommerce.application.commons.StringUtils.nonBlank;

public class NonEmptyDecimal {

    private final double value;

    private final Pattern pattern = Pattern.compile("(\\+|-)?([0-9]+(\\.[0-9]+))");

    public NonEmptyDecimal(String value) {
        Validate.notNull(value, "NonEmptyDecimal can not be null");
        Validate.isTrue(nonBlank(value), "NonEmptyDecimal can not be empty");
        Validate.isTrue(pattern.matcher(value).matches(), "Invalid NonEmptyDecimal decimal: "+value);


        this.value = NumberUtils.toDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyDecimal{" +
                "value=" + value +
                '}';
    }
}
