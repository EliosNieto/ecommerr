package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.OrderNotFound;
import com.ias.ecommerce.application.model.orders.FindByIdOrderRequest;
import com.ias.ecommerce.application.model.orders.FindByIdOrderResponse;
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
        IdentificationOrder identificationOrder = validateRequest(request);

        Optional<Order> optionalOrder = orderRepository.findById(identificationOrder);
        if (!optionalOrder.isPresent()){
            throw new OrderNotFound(identificationOrder);
        }

        return new FindByIdOrderResponse(optionalOrder.get());
    }

    private IdentificationOrder validateRequest(FindByIdOrderRequest request){
        try {
            return new IdentificationOrder(request.getValue());
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
