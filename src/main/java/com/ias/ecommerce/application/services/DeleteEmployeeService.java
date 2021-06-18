package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.EmployeeNotFound;
import com.ias.ecommerce.application.model.employee.crud.DeleteEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.DeleteEmployeeResponse;
import com.ias.ecommerce.application.ports.in.DeleteEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;

import java.util.Optional;

public class DeleteEmployeeService implements DeleteEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DeleteEmployeeResponse execute(DeleteEmployeeRequest request) {

        IdentificationNumber identificationNumber = new IdentificationNumber(request.getValue());
        Optional<Employee> employee = employeeRepository.findById(identificationNumber);

        if(!employee.isPresent()){
            throw new EmployeeNotFound(identificationNumber);
        }
        employeeRepository.delete(identificationNumber);
        return new DeleteEmployeeResponse(identificationNumber);
    }
}
