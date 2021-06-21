package com.ias.ecommerce.infrastructure.persistence.repository;

import com.ias.ecommerce.infrastructure.persistence.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryJpa extends CrudRepository<EmployeeEntity, Long> {
}
