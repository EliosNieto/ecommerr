package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Client;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class AllClientResponse implements ApplicationResponse {

    private final Collection<Client> clientCollection;

    public AllClientResponse(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
