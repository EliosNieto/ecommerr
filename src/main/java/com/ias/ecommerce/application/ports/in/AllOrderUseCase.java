package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.crud.AllOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.AllOrderResponse;

public interface AllOrderUseCase extends ApplicationUseCase<AllOrderRequest, AllOrderResponse> {
}
