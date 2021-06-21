package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.EmployeeNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.employee.UpdateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.UpdateEmployeeResponse;
import com.ias.ecommerce.application.ports.in.UpdateEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;

import java.util.Optional;

public class UpdateEmployeeService implements UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UpdateEmployeeResponse execute(UpdateEmployeeRequest request) {

        Employee employee = validateRequest(request);

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getIdentificationNumber());
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFound(employee.getIdentificationNumber());
        }

        employeeRepository.update(employee);
        return new UpdateEmployeeResponse(employee);
    }

    private Employee validateRequest(UpdateEmployeeRequest request){
        IdentificationNumber identificationNumber = null;
        NonEmptyString name = null;
        NonEmptyString lastNames = null;
        try {
            identificationNumber = new IdentificationNumber(request.getId());
            name = new NonEmptyString(request.getNames());
            lastNames = new NonEmptyString(request.getLastNames());
            return new Employee(identificationNumber,name, lastNames);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
