package com.ias.ecommerce.application.model.employee.crud;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Employee;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class AllEmployeeResponse implements ApplicationResponse {

    private final Collection<Employee> employees;

    public AllEmployeeResponse(Collection<Employee> employees) {
        this.employees = employees;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
