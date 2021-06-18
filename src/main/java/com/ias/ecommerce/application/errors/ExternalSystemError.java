package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;

import java.util.Map;

public class ExternalSystemError extends ApplicationError {
    @Override
    public String errorCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return null;
    }

    @Override
    public Map<String, Object> metadata() {
        return super.metadata();
    }
}
