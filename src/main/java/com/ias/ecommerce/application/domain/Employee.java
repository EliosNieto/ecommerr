package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NonEmptyString;

public class Employee extends Persona{

    public Employee(IdentificationNumber identificationNumber, NonEmptyString names, NonEmptyString lastNames) {
        super(identificationNumber, names, lastNames);
    }
}
