package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationOrder;

import java.util.Map;

public class OrderNotFound extends ApplicationError {

    private final IdentificationOrder identificationOrder;

    public OrderNotFound(IdentificationOrder identificationOrder) {
        this.identificationOrder = identificationOrder;
    }

    @Override
    public String errorCode() {
        return "ORDER_NOT_FOUND_ERROR";
    }

    @Override
    public String getMessage() {
        return "order id not found: "+identificationOrder.getValue();
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "id", identificationOrder.getValue()
        );
    }
}
