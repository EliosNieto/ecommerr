package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationNumber;

import java.util.Map;

public class ClientExistError extends ApplicationError {

    private final IdentificationNumber identificationNumber;

    public ClientExistError(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.CONFLICT;
    }

    @Override
    public String getMessage() {
        return "Client already exists exception";
    }

    @Override
    public String errorCode() {
        return "CLIENT_ALREADY_EXISTS_ERROR";
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "identification",identificationNumber.getValue()
        );
    }
}
