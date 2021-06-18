package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.domain.IdentificationNumber;
import org.springframework.stereotype.Component;

@Component
public class IdentificationNumberMapper {

    public IdentificationNumber map(Integer value){
        String valueMapper = String.valueOf(value);
        return new IdentificationNumber(valueMapper);
    }

    public Integer map (IdentificationNumber identificationNumber){
        return identificationNumber.getValue();
    }
}
