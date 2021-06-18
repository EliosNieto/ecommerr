package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.crud.FindByIdOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.FindByIdOrderResponse;

public interface FindByIdOrderUseCase extends ApplicationUseCase<FindByIdOrderRequest, FindByIdOrderResponse> {
}
