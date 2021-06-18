package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.model.client.crud.AllClientRequest;
import com.ias.ecommerce.application.model.client.crud.AllClientResponse;
import com.ias.ecommerce.application.ports.in.AllClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;

import java.util.Collection;
import java.util.Optional;

public class AllClientService implements AllClientUseCase {

    private final ClientRepository clientRepository;

    public AllClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public AllClientResponse execute(AllClientRequest request) {
        Optional<Collection<Client>> clientCollection =  clientRepository.getAll();

        return new AllClientResponse(clientCollection.get());
    }
}
