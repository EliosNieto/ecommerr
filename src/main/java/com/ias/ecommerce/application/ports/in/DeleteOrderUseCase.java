package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.DeleteOrderRequest;
import com.ias.ecommerce.application.model.orders.DeleteOrderResponse;

public interface DeleteOrderUseCase extends ApplicationUseCase<DeleteOrderRequest, DeleteOrderResponse> {
}
