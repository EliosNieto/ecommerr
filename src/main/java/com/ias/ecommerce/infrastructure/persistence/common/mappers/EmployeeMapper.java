package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.Employee;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationNumberMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NomEmptyStringMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

@Mapper(componentModel = "spring", uses ={IdentificationNumberMapper.class, NomEmptyStringMapper.class})
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "identificationNumber"),
            @Mapping(source = "names", target = "names"),
            @Mapping(source = "lastNames", target = "lastNames")
    })
    Employee toEmployee(EmployeeEntity employeeEntity);
    Collection<Employee> toEmployees(Iterable<EmployeeEntity> employeeEntities);

    @InheritInverseConfiguration
    EmployeeEntity toEmployeeEntity(Employee employee);
}
