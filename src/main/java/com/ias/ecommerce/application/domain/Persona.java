package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NonEmptyString;

public abstract class Persona {

    private final IdentificationNumber identificationNumber;
    private final NonEmptyString names;
    private final NonEmptyString lastNames;

    public Persona(IdentificationNumber identificationNumber, NonEmptyString names, NonEmptyString lastNames) {
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.lastNames = lastNames;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public NonEmptyString getNames() {
        return names;
    }

    public NonEmptyString getLastNames() {
        return lastNames;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "identificationNumber=" + identificationNumber +
                ", names=" + names +
                ", last_names=" + lastNames +
                '}';
    }
}
