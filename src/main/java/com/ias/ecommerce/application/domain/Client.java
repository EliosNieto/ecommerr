package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NonEmptyString;

public class Client extends Persona {

    public Client(IdentificationNumber identificationNumber, NonEmptyString names, NonEmptyString lastNames){
        super(identificationNumber, names, lastNames);
    }

}

