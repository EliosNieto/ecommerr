package com.ias.ecommerce.infrastructure.persistence.repository;

import com.ias.ecommerce.infrastructure.persistence.entity.OrderDetailsEntity;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderProductPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderDetailsJpa extends CrudRepository<OrderDetailsEntity, Integer> {
    @Transactional
    void deleteByOrderProductPKOrderIdAndOrderProductPKProductId(Integer orderId, Integer productId);
}
