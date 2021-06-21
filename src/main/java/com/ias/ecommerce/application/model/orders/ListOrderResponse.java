package com.ias.ecommerce.application.model.orders;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Order;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ListOrderResponse implements ApplicationResponse {

    private final Collection<Order> orders;

    public ListOrderResponse(Collection<Order> orders) {
        this.orders = orders;
    }


    public Collection<Order> getOrders() {
        return orders;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
