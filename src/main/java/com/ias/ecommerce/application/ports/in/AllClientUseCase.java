package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.ListClientRequest;
import com.ias.ecommerce.application.model.client.ListClientResponse;

public interface AllClientUseCase extends ApplicationUseCase<ListClientRequest, ListClientResponse> {
}
