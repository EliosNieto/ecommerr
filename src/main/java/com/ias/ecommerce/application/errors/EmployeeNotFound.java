package com.ias.ecommerce.application.errors;

import com.ias.ecommerce.application.commons.errors.ApplicationError;
import com.ias.ecommerce.application.commons.errors.HttpStatusCode;
import com.ias.ecommerce.application.domain.IdentificationNumber;

import java.util.Map;

public class EmployeeNotFound extends ApplicationError {

    private final IdentificationNumber identificationNumber;

    public EmployeeNotFound(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String errorCode() {
        return "EMPLOYEE_NOT_FOUND_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.NOT_FOUND;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "identification",identificationNumber.getValue()
        );
    }
}
