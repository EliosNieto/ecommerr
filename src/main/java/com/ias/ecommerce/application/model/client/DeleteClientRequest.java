package com.ias.ecommerce.application.model.client;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class DeleteClientRequest implements ApplicationRequest {

    private final String value;

    public DeleteClientRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
