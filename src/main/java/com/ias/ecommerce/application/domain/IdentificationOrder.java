package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.commons.StringUtils;
import com.ias.ecommerce.application.commons.Validate;

import java.util.regex.Pattern;

public class IdentificationOrder {

    private Long value;
    private Pattern pattern = Pattern.compile("^\\d{1,19}$");

    public IdentificationOrder(String value) {
        validateValue(value);
    }

    private void validateValue(String value){
        if(StringUtils.isValueNull(value)) {
            this.value = 0L;
            return;
        }
        Validate.isTrue(StringUtils.nonBlank(value), "Identification order can not be empty");
        Validate.isTrue(pattern.matcher(value).matches(), "Invalid identification number:" + value);
        this.value = NumberUtils.toLong(value);
    }

    public Long getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "IdentificationOrder{" +
                "value=" + value +
                '}';
    }
}
