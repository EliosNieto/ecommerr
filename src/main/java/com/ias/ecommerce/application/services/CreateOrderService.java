package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;
import com.ias.ecommerce.application.commons.NonEmptyInteger;
import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.commons.StringUtils;
import com.ias.ecommerce.application.domain.*;
import com.ias.ecommerce.application.errors.ClientNotFound;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.orders.CreateOrderRequest;
import com.ias.ecommerce.application.model.orders.CreateOrderResponse;
import com.ias.ecommerce.application.ports.in.CreateOrderUseCase;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Order order = validRequestOrder(request);

        logger.info(order.toString());

        Optional<Order> optionalOrder = orderRepository.save(order);

        //si no existe la orden eror internal server
        return new CreateOrderResponse(optionalOrder.get());
    }

    private Order validRequestOrder(CreateOrderRequest request) {
        IdentificationNumber identificationNumber = null;
        NonEmptyDecimal total = null;


        try {
            identificationNumber = new IdentificationNumber(request.getClientId());
            Optional<Client> client = clientRepository.findById(identificationNumber);
            if (!client.isPresent()) {
                throw new ClientNotFound(identificationNumber);
            }

            List<OrderDetails> details = toOrderDetail(request.getDetails());
            Double totalOder = details.stream().mapToDouble(value -> value.getTotal().getValue()).sum();
            total = new NonEmptyDecimal(StringUtils.doubleToString(totalOder));

            return new Order(new IdentificationOrder(null),
                    client.get(), OrderStatus.Registrada, total, new NonEmptyDecimal("0.0"), total, details);
        } catch (RuntimeException e) {
            throw new InputDataError(e.getMessage());
        }
    }

    /**
     * convert to List<OrderDetails>
     * @param detailRequest
     * @return
     */
    private List<OrderDetails> toOrderDetail(List<CreateOrderRequest.DetailRequest> detailRequest){
        return detailRequest.stream().map(detailRequest1 -> {
            Product product = productExist(detailRequest1.getProductId());
            NonEmptyInteger amount = new NonEmptyInteger(detailRequest1.getAmount());
            double total = totalDetail(product.getBasePrice(), amount);
            return new OrderDetails(product,new IdentificationOrder(null), product.getBasePrice(),amount
                    ,new NonEmptyDecimal(StringUtils.doubleToString(total)));
        }).collect(Collectors.toList());
    }

    private Double totalDetail(NonEmptyDecimal value, NonEmptyInteger amount) {
        return value.getValue() * amount.getValue();
    }

    private Product productExist(String value) {
        IdentificationProduct identificationProduct = new IdentificationProduct(value);
        Optional<Product> product = productRepository.getFindById(identificationProduct);
        if (!product.isPresent()) {
            throw new ProductNotFound(identificationProduct);
        }
        return product.get();
    }

}
