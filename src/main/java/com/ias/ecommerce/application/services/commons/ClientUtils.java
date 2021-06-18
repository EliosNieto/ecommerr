package com.ias.ecommerce.application.services.commons;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.client.ClientRequest;

public abstract class ClientUtils {

    public static Client validateRequest(ClientRequest request){

        IdentificationNumber identificationNumber = null;
        NonEmptyString names = null;
        NonEmptyString last_names = null;

        try {
            identificationNumber = new IdentificationNumber(request.getIdentification());
            names = new NonEmptyString(request.getNames());
            last_names = new NonEmptyString(request.getLastNames());

            return new Client(identificationNumber, names, last_names);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
