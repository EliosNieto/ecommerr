package com.ias.ecommerce.application.model.client;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class UpdateClientRequest implements ApplicationRequest {
    private String identificationNumber;
    private final String names;
    private final String lastNames;

    public UpdateClientRequest(String names, String lastNames) {
        this.names = names;
        this.lastNames = lastNames;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }
}
