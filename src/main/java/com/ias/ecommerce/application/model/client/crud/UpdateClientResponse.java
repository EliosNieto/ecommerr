package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Client;
import org.springframework.http.HttpStatus;

public class UpdateClientResponse implements ApplicationResponse {

    private final Client client;

    public UpdateClientResponse(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
