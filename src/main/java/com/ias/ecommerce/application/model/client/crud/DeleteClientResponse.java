package com.ias.ecommerce.application.model.client.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import org.springframework.http.HttpStatus;

public class DeleteClientResponse implements ApplicationResponse {

    private final IdentificationNumber identificationNumber;

    public DeleteClientResponse(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.NO_CONTENT;
    }
}
