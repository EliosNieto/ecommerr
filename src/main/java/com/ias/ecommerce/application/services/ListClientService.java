package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.model.client.ListClientRequest;
import com.ias.ecommerce.application.model.client.ListClientResponse;
import com.ias.ecommerce.application.ports.in.AllClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;

import java.util.Collection;
import java.util.Optional;

public class ListClientService implements AllClientUseCase {

    private final ClientRepository clientRepository;

    public ListClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ListClientResponse execute(ListClientRequest request) {
        Optional<Collection<Client>> clientCollection =  clientRepository.getAll();

        return new ListClientResponse(clientCollection.get());
    }
}
