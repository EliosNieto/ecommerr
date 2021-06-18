package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.crud.UpdateOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.UpdateOrderResponse;

public interface UpdateOrderUseCase extends ApplicationUseCase<UpdateOrderRequest, UpdateOrderResponse> {
}
