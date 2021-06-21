package com.ias.ecommerce.infrastructure.persistence.repository;

import com.ias.ecommerce.infrastructure.persistence.entity.OrderDetailsEntity;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderProductPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface OrderDetailsJpa extends CrudRepository<OrderDetailsEntity, OrderProductPK> {

    @Transactional
    @Modifying
    @Query("delete from OrderDetailsEntity d where d.orderProductPK.orderId=?1 and d.orderProductPK.productId=?2")
    void deleteByOrderProductPKOrderIdAndOrderProductPKProductId(Long orderId, Long productId);

}
