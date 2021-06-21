package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.FindByIdOrderRequest;
import com.ias.ecommerce.application.model.orders.FindByIdOrderResponse;

public interface FindByIdOrderUseCase extends ApplicationUseCase<FindByIdOrderRequest, FindByIdOrderResponse> {
}
