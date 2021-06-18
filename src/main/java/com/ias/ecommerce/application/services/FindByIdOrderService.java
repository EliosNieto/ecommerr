package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.model.orders.crud.FindByIdOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.FindByIdOrderResponse;
import com.ias.ecommerce.application.ports.in.FindByIdOrderUseCase;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class FindByIdOrderService implements FindByIdOrderUseCase {

    Logger logger = LoggerFactory.getLogger(FindByIdOrderService.class);

    private final OrderRepository orderRepository;

    public FindByIdOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public FindByIdOrderResponse execute(FindByIdOrderRequest request) {
        logger.info(request.toString());
        IdentificationOrder identificationOrder = new IdentificationOrder(request.getValue());

        Optional<Order> optionalOrder = orderRepository.findById(identificationOrder);

        return new FindByIdOrderResponse(optionalOrder.get());
    }
}
