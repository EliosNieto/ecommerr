package com.ias.ecommerce.application.model.employee;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import org.springframework.http.HttpStatus;

public class DeleteEmployeeResponse implements ApplicationResponse {

    private final IdentificationNumber identificationNumber;

    public DeleteEmployeeResponse(IdentificationNumber identificationNumber) {
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
