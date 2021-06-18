package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.model.employee.crud.AllEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.AllEmployeeResponse;
import com.ias.ecommerce.application.ports.in.AllEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;

import java.util.Collection;
import java.util.Optional;

public class AllEmployeeService implements AllEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public AllEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public AllEmployeeResponse execute(AllEmployeeRequest request) {
        Optional<Collection<Employee>> employees = employeeRepository.getAll();
        return new AllEmployeeResponse(employees.get());
    }
}
