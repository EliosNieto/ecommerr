package com.ias.ecommerce.application.model.orders.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

public class DeleteOrderRequest implements ApplicationRequest {

    private final String value;

    public DeleteOrderRequest(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
