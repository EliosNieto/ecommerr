package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationProduct;

import java.util.Map;

public class ProductExistsError extends ApplicationError {

    private final IdentificationProduct identificationProduct;

    public ProductExistsError(IdentificationProduct identificationProduct) {
        this.identificationProduct = identificationProduct;
    }

    @Override
    public String getMessage() {
        return "Code product already exists ";
    }

    @Override
    public String errorCode() {
        return "PRODUCT_ALREADY_EXISTS_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "idProduct", identificationProduct.getValue()
        );
    }
}
