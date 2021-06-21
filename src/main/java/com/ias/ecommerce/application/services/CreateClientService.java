package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.ClientExistError;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.client.CreateClientRequest;
import com.ias.ecommerce.application.model.client.CreateClientResponse;
import com.ias.ecommerce.application.ports.in.CreateClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
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
        Client client = validRequest(request);

        Optional<Client> optionalClient = clientRepository.findById(client.getIdentificationNumber());
        if(optionalClient.isPresent()){
            throw new ClientExistError(client.getIdentificationNumber());
        }

        clientRepository.save(client);

        return new CreateClientResponse(client);
    }

    private Client validRequest(CreateClientRequest request){
        IdentificationNumber identificationNumber;
        NonEmptyString names;
        NonEmptyString lastNames;
        try {
            identificationNumber = new IdentificationNumber(request.getIdentification());
            names = new NonEmptyString(request.getNames());
            lastNames = new NonEmptyString(request.getLastNames());
            return new Client(identificationNumber, names, lastNames);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }

}
