package com.ias.ecommerce.infrastructure.configuration;

import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;
import com.ias.ecommerce.application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeApplicationConfiguration {

    @Bean
    public AllEmployeeUseCase allEmployeeUseCase(EmployeeRepository employeeRepository){
        return new ListEmployeeService(employeeRepository);
    }

    @Bean
    public CreateEmployeeUseCase createEmployeeUseCase(EmployeeRepository employeeRepository){
        return new CreateEmployeeService(employeeRepository);
    }

    @Bean
    public UpdateEmployeeUseCase updateEmployeeUseCase(EmployeeRepository employeeRepository){
        return new UpdateEmployeeService(employeeRepository);
    }

    @Bean
    public DeleteEmployeeUseCase deleteEmployeeUseCase(EmployeeRepository employeeRepository){
        return new DeleteEmployeeService(employeeRepository);
    }

    @Bean
    public FindByIdEmployeeUseCase findByIdEmployeeUseCase(EmployeeRepository employeeRepository){
        return new FindByIdEmployeeService(employeeRepository);
    }
}
