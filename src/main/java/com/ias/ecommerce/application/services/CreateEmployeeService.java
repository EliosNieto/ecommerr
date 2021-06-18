package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.errors.EmployeeExistsError;
import com.ias.ecommerce.application.model.employee.crud.CreateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.CreateEmployeeResponse;
import com.ias.ecommerce.application.ports.in.CreateEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;
import com.ias.ecommerce.application.services.commons.EmployeeUtils;
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
        Employee employee = EmployeeUtils.validateRequest(request);

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getIdentificationNumber());

        if (optionalEmployee.isPresent()){
            throw new EmployeeExistsError(employee.getIdentificationNumber());
        }

        employeeRepository.save(employee);

        return new CreateEmployeeResponse(employee);
    }
}
