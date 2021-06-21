package com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import org.springframework.stereotype.Component;

@Component
public class ProductIdentificationMapper {

    public IdentificationProduct map(Long value){
        String valueIdentification = String.valueOf(value);

        return new IdentificationProduct(valueIdentification);
    }

    public Long map(IdentificationProduct identificationProduct){
        return identificationProduct.getValue();
    }


}
