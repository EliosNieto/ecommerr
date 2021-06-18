package com.ias.ecommerce.application.model.employee.crud;

import com.ias.ecommerce.application.model.employee.EmployeeRequest;

public class CreateEmployeeRequest extends EmployeeRequest {

    public CreateEmployeeRequest(String identification, String names, String lastNames) {
        super(identification, names, lastNames);
    }

}
