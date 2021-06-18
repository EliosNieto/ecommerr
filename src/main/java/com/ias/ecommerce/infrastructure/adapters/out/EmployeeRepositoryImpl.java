package com.ias.ecommerce.infrastructure.adapters.out;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.application.domain.IdentificationNumber;
import com.ias.ecommerce.application.ports.out.EmployeeRepository;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.EmployeeMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.EmployeeEntity;
import com.ias.ecommerce.infrastructure.persistence.repository.EmployeeRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);

    private final EmployeeRepositoryJpa employeeRepositoryJpa;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeRepositoryImpl(EmployeeRepositoryJpa employeeRepositoryJpa, EmployeeMapper employeeMapper) {
        this.employeeRepositoryJpa = employeeRepositoryJpa;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public void save(Employee employee) {
        logger.info(employee.toString());
        EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employee);
        logger.info(employeeEntity.toString());
        employeeRepositoryJpa.save(employeeEntity);
    }

    @Override
    public void delete(IdentificationNumber identificationNumber) {
        employeeRepositoryJpa.deleteById(identificationNumber.getValue());
    }

    @Override
    public void update(Employee employee) {
        EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employee);
        employeeRepositoryJpa.save(employeeEntity);
    }

    @Override
    public Optional<Collection<Employee>> getAll() {
        Iterable<EmployeeEntity> employees = employeeRepositoryJpa.findAll();
        Collection<Employee> employeeCollection = employeeMapper.toEmployees(employees);
        return Optional.of(employeeCollection);
    }

    @Override
    public Optional<Employee> findById(IdentificationNumber id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepositoryJpa.findById(id.getValue());
        if(!employeeEntity.isPresent()){
            return Optional.empty();
        }
        return employeeEntity.map(employeeEntity1 -> employeeMapper.toEmployee(employeeEntity1));
    }
}
