package com.ias.ecommerce.application.model.orders.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Order;
import org.springframework.http.HttpStatus;

public class UpdateOrderResponse implements ApplicationResponse {

    private final Order order;

    public UpdateOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
