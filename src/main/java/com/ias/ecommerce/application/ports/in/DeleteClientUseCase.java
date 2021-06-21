package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.DeleteClientRequest;
import com.ias.ecommerce.application.model.client.DeleteClientResponse;

public interface DeleteClientUseCase extends ApplicationUseCase<DeleteClientRequest, DeleteClientResponse> {
}
