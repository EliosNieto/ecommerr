package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class OrderStateError extends ApplicationError {

    private final String message;
    private final String estate;

    public OrderStateError(String message, String estate) {
        this.message = message;
        this.estate = estate;
    }

    @Override
    public String errorCode() {
        return "ORDER_ESTATE_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_ALLOWED;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of("Estate", estate);
    }
}
