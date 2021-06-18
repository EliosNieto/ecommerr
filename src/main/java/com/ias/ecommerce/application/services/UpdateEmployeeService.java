package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.errors.EmployeeNotFound;
import com.ias.ecommerce.application.model.employee.crud.UpdateEmployeeRequest;
import com.ias.ecommerce.application.model.employee.crud.UpdateEmployeeResponse;
import com.ias.ecommerce.application.ports.in.UpdateEmployeeUseCase;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;
import com.ias.ecommerce.application.services.commons.EmployeeUtils;

import java.util.Optional;

public class UpdateEmployeeService implements UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UpdateEmployeeResponse execute(UpdateEmployeeRequest request) {

        Employee employee = EmployeeUtils.validateRequest(request);

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getIdentificationNumber());
        if(!optionalEmployee.isPresent()){
            throw new EmployeeNotFound(employee.getIdentificationNumber());
        }

        employeeRepository.update(employee);
        return new UpdateEmployeeResponse(employee);
    }
}
