package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.client.CreateClientRequest;
import com.ias.ecommerce.application.model.client.UpdateClientRequest;
import com.ias.ecommerce.application.model.client.UpdateClientResponse;
import com.ias.ecommerce.application.ports.in.UpdateClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;

import java.util.Optional;

public class UpdateClientService implements UpdateClientUseCase {

    private final ClientRepository clientRepository;

    public UpdateClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UpdateClientResponse execute(UpdateClientRequest request) {
        Client client = validRequestCreate(request);
        Optional<Client> optionalClient = clientRepository.findById(client.getIdentificationNumber());
        if(!optionalClient.isPresent()){
            throw new ClientNotFound(client.getIdentificationNumber());
        }
        clientRepository.update(client);
        return new UpdateClientResponse(client);
    }

    private Client validRequestCreate(UpdateClientRequest request){
        IdentificationNumber identificationNumber = null;
        NonEmptyString names = null;
        NonEmptyString lastNames = null;
        try {
            identificationNumber = new IdentificationNumber(request.getIdentificationNumber());
            names = new NonEmptyString(request.getNames());
            lastNames = new NonEmptyString(request.getLastNames());
            return new Client(identificationNumber, names, lastNames);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }


}
