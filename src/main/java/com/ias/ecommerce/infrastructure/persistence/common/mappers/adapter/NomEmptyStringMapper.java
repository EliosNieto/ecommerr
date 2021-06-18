package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.commons.NonEmptyString;
import org.springframework.stereotype.Component;

@Component
public class NomEmptyStringMapper {
    public NonEmptyString map(String value){
        return new NonEmptyString(value);
    }


    public String map(NonEmptyString nonEmptyString){
        return nonEmptyString.getValue();
    }

}
