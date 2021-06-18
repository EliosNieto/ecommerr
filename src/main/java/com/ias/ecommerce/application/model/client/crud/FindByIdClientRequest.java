package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class FindByIdClientRequest implements ApplicationRequest {
    private final String value;

    public FindByIdClientRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
