package com.ias.ecommerce.application.model.client;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class CreateClientRequest implements ApplicationRequest {

    private final String identification;
    private final String names;
    private final String lastNames;

    public CreateClientRequest(String identification, String names, String lastNames) {
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
}
