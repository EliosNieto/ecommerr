package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;
import com.ias.ecommerce.application.model.client.ClientRequest;

public class UpdateClientRequest extends ClientRequest {
    public UpdateClientRequest(String identificationNumber, String names, String lastNames) {
        super(identificationNumber, names, lastNames);
    }
}
