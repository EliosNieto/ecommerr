package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.UpdateOrderRequest;
import com.ias.ecommerce.application.model.orders.UpdateOrderResponse;

public interface UpdateOrderUseCase extends ApplicationUseCase<UpdateOrderRequest, UpdateOrderResponse> {
}
