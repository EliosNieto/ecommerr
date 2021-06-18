package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.commons.Validate;

import java.util.Objects;
import java.util.regex.Pattern;

import static com.ias.ecommerce.application.commons.StringUtils.nonBlank;

public class IdentificationProduct {
    private final int value;

    private final Pattern pattern = Pattern.compile("-?\\d+");
    private final int VALUE_MIN = 1;

    public IdentificationProduct(String value) {
        Validate.notNull(value, "IdentificationProduct can not be null");
        Validate.isTrue(nonBlank(value), "IdentificationProduct can not be empty");
        Validate.isTrue(pattern.matcher(value).matches(), "Invalid IdentificationProduct number: "+value);
        Validate.isTrue(NumberUtils.numberGreaterThan(Integer.parseInt(value), VALUE_MIN),"IdentificationProduct must be greater to "+VALUE_MIN);
        this.value = NumberUtils.toInteger(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationProduct that = (IdentificationProduct) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "IdentifactionProduct{" +
                "value=" + value +
                '}';
    }
}
