package com.ias.ecommerce.application.model.employee.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Employee;
import org.springframework.http.HttpStatus;

public class FindByIdEmployeeResponse implements ApplicationResponse {

    private final Employee employee;

    public FindByIdEmployeeResponse(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
