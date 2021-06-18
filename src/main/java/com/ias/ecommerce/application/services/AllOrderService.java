package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.model.orders.crud.AllOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.AllOrderResponse;
import com.ias.ecommerce.application.ports.in.AllOrderUseCase;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Optional;

public class AllOrderService implements AllOrderUseCase {

    Logger logger = LoggerFactory.getLogger(AllOrderService.class);

    private final OrderRepository orderRepository;

    public AllOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public AllOrderResponse execute(AllOrderRequest request) {

        Optional<Collection<Order>> orders = orderRepository.getAll();
        orders.get().forEach(order -> logger.info(order.toString()));

        return new AllOrderResponse(orders.get());
    }
}
