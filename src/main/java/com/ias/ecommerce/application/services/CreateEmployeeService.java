package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.errors.EmployeeExistsError;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.employee.CreateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.CreateEmployeeResponse;
import com.ias.ecommerce.application.ports.in.CreateEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreateEmployeeService implements CreateEmployeeUseCase {

    Logger logger = LoggerFactory.getLogger(CreateEmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public CreateEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public CreateEmployeeResponse execute(CreateEmployeeRequest request) {
        logger.info(request.toString());
        Employee employee = validateInputRequest(request);
        logger.info(employee.toString());
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getIdentificationNumber());

        if (optionalEmployee.isPresent()){
            logger.info(optionalEmployee.get().toString());
            throw new EmployeeExistsError(employee.getIdentificationNumber());
        }

        employeeRepository.save(employee);

        return new CreateEmployeeResponse(employee);
    }

    private Employee validateInputRequest(CreateEmployeeRequest request){
        IdentificationNumber identificationNumber = null;
        NonEmptyString names = null ;
        NonEmptyString lastNames = null;

        try {
            identificationNumber = new IdentificationNumber(request.getIdentification());
            names = new NonEmptyString(request.getNames());
            lastNames = new NonEmptyString(request.getLastNames());

            return new Employee(identificationNumber,names,lastNames);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
