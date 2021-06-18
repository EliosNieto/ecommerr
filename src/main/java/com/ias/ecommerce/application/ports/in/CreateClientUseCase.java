package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.crud.CreateClientRequest;
import com.ias.ecommerce.application.model.client.crud.CreateClientResponse;

public interface CreateClientUseCase extends ApplicationUseCase<CreateClientRequest, CreateClientResponse> {
}
