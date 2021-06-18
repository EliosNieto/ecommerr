package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationProduct;

import java.util.Map;

public class ProductNotFound extends ApplicationError {

    private final IdentificationProduct identificationProduct;

    public ProductNotFound(IdentificationProduct identificationProduct) {
        this.identificationProduct = identificationProduct;
    }

    @Override
    public String errorCode() {
        return "PRODUCT_NOT_FOUND_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Product not found ";
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "idProduct",identificationProduct.getValue()
        );
    }
}
