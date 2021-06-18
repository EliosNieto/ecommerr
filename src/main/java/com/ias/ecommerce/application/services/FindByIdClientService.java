package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.model.client.crud.FindByClientResponse;
import com.ias.ecommerce.application.model.client.crud.FindByIdClientRequest;
import com.ias.ecommerce.application.ports.in.FindByIdClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;

import java.util.Optional;

public class FindByIdClientService implements FindByIdClientUseCase {

    private final ClientRepository clientRepository;

    public FindByIdClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public FindByClientResponse execute(FindByIdClientRequest request) {
        IdentificationNumber identificationNumber = new IdentificationNumber(request.getValue());

        Optional<Client> optionalClient = clientRepository.findById(identificationNumber);

        return new FindByClientResponse(optionalClient.get());
    }
}
