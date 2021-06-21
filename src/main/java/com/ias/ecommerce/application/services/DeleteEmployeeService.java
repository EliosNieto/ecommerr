package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.EmployeeNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.employee.DeleteEmployeeRequest;
import com.ias.ecommerce.application.model.employee.DeleteEmployeeResponse;
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

        IdentificationNumber identificationNumber = validateRequest(request);
        Optional<Employee> employee = employeeRepository.findById(identificationNumber);

        if(!employee.isPresent()){
            throw new EmployeeNotFound(identificationNumber);
        }
        employeeRepository.delete(identificationNumber);
        return new DeleteEmployeeResponse(identificationNumber);
    }

    private IdentificationNumber validateRequest(DeleteEmployeeRequest request){
        try {
            return new IdentificationNumber(request.getValue());
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
