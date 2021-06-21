package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.orders.ListOrderRequest;
import com.ias.ecommerce.application.model.orders.ListOrderResponse;

public interface AllOrderUseCase extends ApplicationUseCase<ListOrderRequest, ListOrderResponse> {
}
