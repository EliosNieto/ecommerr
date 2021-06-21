package com.ias.ecommerce.application.model.employee;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class CreateEmployeeRequest implements ApplicationRequest {

    private final String identification;
    private final String names;
    private final String lastNames;

    public CreateEmployeeRequest(String identification, String names, String lastNames) {
        this.identification = identification;
        this.names = names;
        this.lastNames = lastNames;
    }

    public String getIdentification() {
        return identification;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    @Override
    public String toString() {
        return "CreateEmployeeRequest{" +
                "identification='" + identification + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
