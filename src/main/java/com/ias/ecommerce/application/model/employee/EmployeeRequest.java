package com.ias.ecommerce.application.model.employee;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public abstract class EmployeeRequest implements ApplicationRequest {

    protected String identification;
    protected String names;
    protected String lastNames;

    public EmployeeRequest(String identification, String names, String lastNames) {
        this.identification = identification;
        this.names = names;
        this.lastNames = lastNames;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "identification='" + identification + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
