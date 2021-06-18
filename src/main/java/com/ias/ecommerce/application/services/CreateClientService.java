package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.errors.ClientExistError;
import com.ias.ecommerce.application.model.client.crud.CreateClientRequest;
import com.ias.ecommerce.application.model.client.crud.CreateClientResponse;
import com.ias.ecommerce.application.ports.in.CreateClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.services.commons.ClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreateClientService implements CreateClientUseCase {

    Logger logger = LoggerFactory.getLogger(CreateClientService.class);

    private final ClientRepository clientRepository;

    public CreateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public CreateClientResponse execute(CreateClientRequest request) {
        logger.info(request.toString());
        Client client = ClientUtils.validateRequest(request);

        Optional<Client> optionalClient = clientRepository.findById(client.getIdentificationNumber());
        if(optionalClient.isPresent()){
            throw new ClientExistError(client.getIdentificationNumber());
        }

        clientRepository.save(client);

        return new CreateClientResponse(client);
    }


}
