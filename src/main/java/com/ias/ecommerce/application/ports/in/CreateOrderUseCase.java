package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.crud.CreateOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.CreateOrderResponse;

public interface CreateOrderUseCase extends ApplicationUseCase<CreateOrderRequest, CreateOrderResponse> {
}
