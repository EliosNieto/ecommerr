package com.ias.ecommerce.application.model.employee.crud;

import com.ias.ecommerce.application.model.employee.EmployeeRequest;

public class UpdateEmployeeRequest extends EmployeeRequest {


    public UpdateEmployeeRequest(String identification, String names, String lastNames) {
        super(identification, names, lastNames);
    }
}
