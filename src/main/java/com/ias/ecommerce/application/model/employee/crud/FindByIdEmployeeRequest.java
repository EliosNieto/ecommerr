package com.ias.ecommerce.application.model.employee.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class FindByIdEmployeeRequest implements ApplicationRequest {

    private final String value;

    public FindByIdEmployeeRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
