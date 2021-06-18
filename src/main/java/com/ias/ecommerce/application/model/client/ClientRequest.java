package com.ias.ecommerce.application.model.client;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class ClientRequest implements ApplicationRequest {

    private final String identification;
    private final String names;
    private final String lastNames;

    public ClientRequest(String identification, String names, String lastNames) {
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
        return "ClientRequest{" +
                "identification='" + identification + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
