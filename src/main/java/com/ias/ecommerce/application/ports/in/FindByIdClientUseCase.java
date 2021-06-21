package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.FindByClientResponse;
import com.ias.ecommerce.application.model.client.FindByIdClientRequest;

public interface FindByIdClientUseCase extends ApplicationUseCase<FindByIdClientRequest, FindByClientResponse> {
}
