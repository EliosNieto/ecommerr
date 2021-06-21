package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.domain.*;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.OrderNotFound;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.orders.UpdateOrderRequest;
import com.ias.ecommerce.application.model.orders.UpdateOrderResponse;
import com.ias.ecommerce.application.ports.in.UpdateOrderUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import com.ias.ecommerce.application.ports.out.ProductRepository;

import java.util.Optional;

public class UpdateOrderService implements UpdateOrderUseCase {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public UpdateOrderService(OrderRepository orderRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public UpdateOrderResponse execute(UpdateOrderRequest request) {

        IdentificationOrder identificationOrder = new IdentificationOrder(request.getIdOrder());
        Optional<Order> optionalOrder = orderRepository.findById(identificationOrder);

        if(!optionalOrder.isPresent()){
            throw new OrderNotFound(identificationOrder);
        }

        //toOrderDetails(request, optionalOrder.get());

        Optional<Order> order = orderRepository.update(optionalOrder.get());

        return new UpdateOrderResponse(order.get());
    }

/*
    private void toOrderDetails(UpdateOrderRequest request, Order order){
        IdentificationProduct identificationProduct;
        double total = 0;
        for (OrderRequest.DetailRequest detailRequest : request.getDetailRequests()) {

            identificationProduct = new IdentificationProduct(detailRequest.getProductId());
            Optional<Product> product = productRepository.getFindById(identificationProduct);
            if(!product.isPresent()){
                throw new ProductNotFound(identificationProduct);
            }

            double value = product.get().getBasePrice().getValue();
            int amount = NumberUtils.toInt(detailRequest.getAmount());
            double totalLine = value * amount;
            total += totalLine;

            order.getDetails().add(new OrderDetails(identificationProduct,order.getId(),value, amount ,totalLine));
        }
        order.setTotal(total);
    }*/


}
