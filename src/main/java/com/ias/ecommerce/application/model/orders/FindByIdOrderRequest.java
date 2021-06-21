package com.ias.ecommerce.application.model.orders;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class FindByIdOrderRequest implements ApplicationRequest {

    private final String value;

    public FindByIdOrderRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FindByIdOrderRequest{" +
                "value='" + value + '\'' +
                '}';
    }
}
