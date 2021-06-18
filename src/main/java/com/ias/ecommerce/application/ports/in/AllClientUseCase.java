package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.crud.AllClientRequest;
import com.ias.ecommerce.application.model.client.crud.AllClientResponse;

public interface AllClientUseCase extends ApplicationUseCase<AllClientRequest, AllClientResponse> {
}
