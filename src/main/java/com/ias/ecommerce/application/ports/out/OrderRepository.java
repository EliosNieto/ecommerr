package com.ias.ecommerce.application.ports.out;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> save(Order order);

    void delete(IdentificationOrder id);

    Optional<Order> update(Order order);

    Optional<Order> findById(IdentificationOrder id);

    Optional<Collection<Order>> getAll();

}
