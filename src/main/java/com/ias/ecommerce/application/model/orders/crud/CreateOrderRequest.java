package com.ias.ecommerce.application.model.orders.crud;

import com.ias.ecommerce.application.model.orders.OrderRequest;

import java.util.Collection;
import java.util.List;

public class CreateOrderRequest extends OrderRequest {

    public CreateOrderRequest(String clientId, List<OrderRequest.DetailRequest> detailRequests) {
        super(clientId, detailRequests);
    }


}
