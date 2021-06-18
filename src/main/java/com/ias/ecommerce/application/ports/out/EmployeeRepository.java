package com.ias.ecommerce.application.ports.out;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {

    void save (Employee employee);

    void delete(IdentificationNumber identificationNumber);

    void update(Employee employee);

    Optional<Collection<Employee>> getAll();

    Optional<Employee> findById(IdentificationNumber id);
}
