package com.ias.ecommerce.application.model.orders.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;
import org.springframework.http.HttpStatus;

public class DeleteOrderResponse implements ApplicationResponse {

    private final IdentificationOrder order;

    public DeleteOrderResponse(IdentificationOrder order) {
        this.order = order;
    }

    public IdentificationOrder getOrder() {
        return order;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.NO_CONTENT;
    }
}
