package com.ias.ecommerce.application.services.commons;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.employee.EmployeeRequest;

public abstract class EmployeeUtils {

    public static Employee validateRequest(EmployeeRequest request){

        IdentificationNumber identificationNumber = null;
        NonEmptyString names = null ;
        NonEmptyString lastNames = null;

        try {
            identificationNumber = new IdentificationNumber(request.getIdentification());
            names = new NonEmptyString(request.getNames());
            lastNames = new NonEmptyString(request.getLastNames());

            return new Employee(identificationNumber,names,lastNames);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }

    }
}
