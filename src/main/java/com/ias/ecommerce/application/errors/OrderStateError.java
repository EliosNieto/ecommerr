package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;

public class OrderStateError extends ApplicationError {

    private final String message;

    public OrderStateError(String message) {
        this.message = message;
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
}
