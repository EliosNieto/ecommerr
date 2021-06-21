package com.ias.ecommerce.application.model.employee;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class UpdateEmployeeRequest implements ApplicationRequest {

    private String id;
    private final String names;
    private final String lastNames;

    public UpdateEmployeeRequest(String names, String lastNames) {
        this.names = names;
        this.lastNames = lastNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }
}
