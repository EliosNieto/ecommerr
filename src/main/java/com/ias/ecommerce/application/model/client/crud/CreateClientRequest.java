package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.model.client.ClientRequest;

public class CreateClientRequest extends ClientRequest {

    public CreateClientRequest(String identificationNumber, String names, String lastName) {
        super(identificationNumber, names, lastName);
    }

}
