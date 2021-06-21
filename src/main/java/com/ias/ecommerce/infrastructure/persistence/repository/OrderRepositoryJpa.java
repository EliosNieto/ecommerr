package com.ias.ecommerce.infrastructure.persistence.repository;

import com.ias.ecommerce.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJpa extends CrudRepository<OrderEntity, Long> {


}
