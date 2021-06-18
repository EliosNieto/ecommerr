package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.commons.StringUtils;
import com.ias.ecommerce.application.commons.Validate;

import java.util.Objects;
import java.util.regex.Pattern;

public class IdentificationNumber {
    private final Integer value;

    private final Pattern pattern = Pattern.compile("^\\d{8,20}$");

    public IdentificationNumber(String value) {
        Validate.notNull(value, "IdentificationNumber can not be null");
        Validate.isTrue(StringUtils.nonBlank(value), "IdentificationNumber can not be empty");
        Validate.isTrue(pattern.matcher(value).matches(), "Invalid identification number: " + value);
        this.value = NumberUtils.toInteger(value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationNumber that = (IdentificationNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "IdentificationNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
