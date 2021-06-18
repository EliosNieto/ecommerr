package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.crud.DeleteClientRequest;
import com.ias.ecommerce.application.model.orders.crud.DeleteOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.DeleteOrderResponse;

public interface DeleteOrderUseCase extends ApplicationUseCase<DeleteOrderRequest, DeleteOrderResponse> {
}
