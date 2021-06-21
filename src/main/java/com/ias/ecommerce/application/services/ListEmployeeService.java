package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.model.employee.ListEmployeeRequest;
import com.ias.ecommerce.application.model.employee.ListEmployeeResponse;
import com.ias.ecommerce.application.ports.in.AllEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;

import java.util.Collection;
import java.util.Optional;

public class ListEmployeeService implements AllEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public ListEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ListEmployeeResponse execute(ListEmployeeRequest request) {
        Optional<Collection<Employee>> employees = employeeRepository.getAll();
        return new ListEmployeeResponse(employees.get());
    }
}
