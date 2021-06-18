package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.commons.NonEmptyInteger;
import org.springframework.stereotype.Component;

@Component
public class NonEmptyIntegerMapper {

    public NonEmptyInteger map ( Integer value ){
        String valueMap = Integer.toString(value);
        return new NonEmptyInteger(valueMap);
    }

    public Integer map (NonEmptyInteger nonEmptyInteger){
        return nonEmptyInteger.getValue();
    }

}
