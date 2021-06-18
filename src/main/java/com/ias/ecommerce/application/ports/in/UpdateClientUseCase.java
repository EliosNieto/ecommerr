package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.client.crud.UpdateClientRequest;
import com.ias.ecommerce.application.model.client.crud.UpdateClientResponse;

public interface UpdateClientUseCase extends ApplicationUseCase<UpdateClientRequest, UpdateClientResponse>  {
}
