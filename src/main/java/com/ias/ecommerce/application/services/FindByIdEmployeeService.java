package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.EmployeeNotFound;
import com.ias.ecommerce.application.model.employee.FindByIdEmployeeRequest;
import com.ias.ecommerce.application.model.employee.FindByIdEmployeeResponse;
import com.ias.ecommerce.application.ports.in.FindByIdEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;

import java.util.Optional;

public class FindByIdEmployeeService implements FindByIdEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public FindByIdEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public FindByIdEmployeeResponse execute(FindByIdEmployeeRequest request) {
        IdentificationNumber identificationNumber = new IdentificationNumber(request.getValue());

        Optional<Employee> optionalEmployee = employeeRepository.findById(identificationNumber);

        if (!optionalEmployee.isPresent()){
            throw new EmployeeNotFound(identificationNumber);
        }

        return new FindByIdEmployeeResponse(optionalEmployee.get());
    }
}
