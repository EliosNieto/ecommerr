package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;
import com.ias.ecommerce.application.domain.IdentificationProduct;

public class DeleteProductRequest implements ApplicationRequest {
    private final String identificationProduct;

    public DeleteProductRequest(String identificationProduct) {
        this.identificationProduct = identificationProduct;
    }

    public String getIdentificationProduct() {
        return identificationProduct;
    }
}
