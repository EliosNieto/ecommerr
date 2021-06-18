package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.domain.OrderDetails;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.orders.crud.CreateOrderRequest;
import com.ias.ecommerce.application.model.orders.crud.CreateOrderResponse;
import com.ias.ecommerce.application.ports.in.CreateOrderUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import com.ias.ecommerce.application.services.commons.OrderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreateOrderService implements CreateOrderUseCase {

    private Logger logger = LoggerFactory.getLogger(CreateOrderService.class);

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public CreateOrderService(OrderRepository orderRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CreateOrderResponse execute(CreateOrderRequest request) {
        logger.info(request.toString());
        Order order = OrderUtils.validateRequest(request);

        Optional<Client> optionalClient = clientRepository.findById(order.getClientId());
        if (!optionalClient.isPresent()){
            throw new ClientNotFound(order.getClientId());
        }

        totalInvoice(order);


        logger.info(order.toString());

        Optional<Order> optionalOrder = orderRepository.save(order);

        //si no existe la orden eror internal server
        return new CreateOrderResponse(optionalOrder.get());
    }

    private void totalInvoice(Order order){
        double total = 0;
        for (OrderDetails orderDetails : order.getDetails()) {
            Optional<Product> product = productRepository.getFindById(orderDetails.getProductId());
            if(!product.isPresent()){
                throw new ProductNotFound(orderDetails.getProductId());
            }
            double value = product.get().getBasePrice().getValue();
            orderDetails.setValue(value);
            double totalLine = value * orderDetails.getAmount();
            orderDetails.setTotal(totalLine);
            total += totalLine;
        }
        order.setTotal(total);
    }


}
