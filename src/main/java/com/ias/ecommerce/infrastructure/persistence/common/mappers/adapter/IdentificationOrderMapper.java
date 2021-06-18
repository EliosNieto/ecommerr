package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class IdentificationOrderMapper {

    public IdentificationOrder map(Integer value){
        String valueMapper = String.valueOf(value);
        return new IdentificationOrder(valueMapper);
    }

    public Integer map(IdentificationOrder identificationOrder){
        return identificationOrder.getValue();
    }
}
