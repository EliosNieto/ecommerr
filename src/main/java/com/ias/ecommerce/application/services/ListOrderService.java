package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.model.orders.ListOrderRequest;
import com.ias.ecommerce.application.model.orders.ListOrderResponse;
import com.ias.ecommerce.application.ports.in.AllOrderUseCase;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Optional;

public class ListOrderService implements AllOrderUseCase {

    Logger logger = LoggerFactory.getLogger(ListOrderService.class);

    private final OrderRepository orderRepository;

    public ListOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ListOrderResponse execute(ListOrderRequest request) {
        Optional<Collection<Order>> orders = orderRepository.getAll();
        return new ListOrderResponse(orders.get());
    }
}
