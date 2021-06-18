package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class FindByIdProductRequest implements ApplicationRequest {

    private final String identificationProduct;

    public FindByIdProductRequest(String identificationProduct) {
        this.identificationProduct = identificationProduct;
    }

    public String getIdentificationProduct() {
        return identificationProduct;
    }
}
