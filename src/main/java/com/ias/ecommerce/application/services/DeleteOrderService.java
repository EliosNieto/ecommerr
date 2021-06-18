package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.domain.OrderStatus;
import com.ias.ecommerce.application.errors.OrderNotFound;
import com.ias.ecommerce.application.errors.OrderStateError;
import com.ias.ecommerce.application.model.orders.crud.DeleteOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.DeleteOrderResponse;
import com.ias.ecommerce.application.ports.in.DeleteOrderUseCase;
import com.ias.ecommerce.application.ports.out.OrderRepository;

import java.util.Optional;

public class DeleteOrderService implements DeleteOrderUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public DeleteOrderResponse execute(DeleteOrderRequest request) {

        IdentificationOrder identificationOrder = new IdentificationOrder(request.getValue());
        Optional<Order> optionalOrder = orderRepository.findById(identificationOrder);

        if(!optionalOrder.isPresent()){
            throw new OrderNotFound(identificationOrder);
        }

        if(!optionalOrder.get().getStatus().equals(OrderStatus.Registrada)){
            throw new OrderStateError("Delete not permitted for state: "+optionalOrder.get().getStatus());
        }

        orderRepository.delete(optionalOrder.get().getId());

        return new DeleteOrderResponse(identificationOrder);
    }
}
