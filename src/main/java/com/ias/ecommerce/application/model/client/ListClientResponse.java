package com.ias.ecommerce.application.model.client;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Client;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ListClientResponse implements ApplicationResponse {

    private final Collection<Client> clients;

    public ListClientResponse(Collection<Client> clientCollection) {
        this.clients = clientCollection;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
