package com.ias.ecommerce.infrastructure.persistence.repository;

import com.ias.ecommerce.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJpa extends CrudRepository<ProductEntity, Long> {

}
