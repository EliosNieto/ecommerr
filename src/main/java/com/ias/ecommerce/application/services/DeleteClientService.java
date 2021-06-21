package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.client.DeleteClientRequest;
import com.ias.ecommerce.application.model.client.DeleteClientResponse;
import com.ias.ecommerce.application.ports.in.DeleteClientUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;

import java.util.Optional;

public class DeleteClientService implements DeleteClientUseCase {

    private final ClientRepository clientRepository;

    public DeleteClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public DeleteClientResponse execute(DeleteClientRequest request) {
        IdentificationNumber identificationNumber = validRequest(request);
        Optional<Client> optionalClient = clientRepository.findById(identificationNumber);
        if(!optionalClient.isPresent()){
            throw new ClientNotFound(identificationNumber);
        }
        clientRepository.delete(identificationNumber);
        return new DeleteClientResponse(identificationNumber);
    }

    private IdentificationNumber validRequest(DeleteClientRequest request){
        try {
            return new IdentificationNumber(request.getValue());
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }


}
