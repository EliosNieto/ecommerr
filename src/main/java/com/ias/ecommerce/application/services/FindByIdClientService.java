package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.client.FindByClientResponse;
import com.ias.ecommerce.application.model.client.FindByIdClientRequest;
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
        IdentificationNumber identificationNumber = validateRequest(request);

        Optional<Client> optionalClient = clientRepository.findById(identificationNumber);
        if (!optionalClient.isPresent()){
            throw new ClientNotFound(identificationNumber);
        }

        return new FindByClientResponse(optionalClient.get());
    }

    private IdentificationNumber validateRequest(FindByIdClientRequest request){
        try {
            return new IdentificationNumber(request.getValue());
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
