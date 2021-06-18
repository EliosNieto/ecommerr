package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.model.client.crud.UpdateClientRequest;
import com.ias.ecommerce.application.model.client.crud.UpdateClientResponse;
import com.ias.ecommerce.application.ports.in.UpdateClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.services.commons.ClientUtils;

import java.util.Optional;

public class UpdateClientService implements UpdateClientUseCase {

    private final ClientRepository clientRepository;

    public UpdateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UpdateClientResponse execute(UpdateClientRequest request) {
        Client client = ClientUtils.validateRequest(request);
        Optional<Client> optionalClient = clientRepository.findById(client.getIdentificationNumber());
        if(!optionalClient.isPresent()){
            throw new ClientNotFound(client.getIdentificationNumber());
        }
        clientRepository.update(client);
        return new UpdateClientResponse(client);
    }


}
