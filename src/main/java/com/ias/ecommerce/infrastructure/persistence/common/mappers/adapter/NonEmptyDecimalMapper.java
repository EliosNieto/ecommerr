package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;
import org.springframework.stereotype.Component;

@Component
public class NonEmptyDecimalMapper {

    public NonEmptyDecimal map(Double value){
        String valueMap = Double.toString(value);

        return new NonEmptyDecimal(valueMap);
    }


    public Double map(NonEmptyDecimal nonEmptyDecimal){
        return nonEmptyDecimal.getValue();
    }
}
