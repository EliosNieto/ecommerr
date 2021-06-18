package com.ias.ecommerce.application.model.orders.crud;

import com.ias.ecommerce.application.model.orders.OrderRequest;

import java.util.List;

public class UpdateOrderRequest extends OrderRequest {

    public UpdateOrderRequest(String id, String clientId, List<DetailRequest> detailRequests) {
        super(id, clientId, detailRequests);
    }
}
