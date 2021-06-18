package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationNumber;

import java.util.Map;

public class EmployeeExistsError extends ApplicationError {

    private final IdentificationNumber identificationNumber;

    public EmployeeExistsError(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String errorCode() {
        return "PRODUCT_ALREADY_EXISTS_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.CONFLICT;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "idenfication",identificationNumber.getValue()
        );
    }
}
