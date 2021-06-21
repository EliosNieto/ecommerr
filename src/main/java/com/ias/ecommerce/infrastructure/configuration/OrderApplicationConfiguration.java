package com.ias.ecommerce.infrastructure.configuration;

import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import com.ias.ecommerce.application.services.*;
import com.ias.ecommerce.infrastructure.adapters.out.OrderRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApplicationConfiguration {

    @Bean
    public CreateOrderUseCase createOrderUseCase(
            OrderRepositoryImpl orderRepository,
            ProductRepository productRepository,
            ClientRepository clientRepository){
        return new CreateOrderService(orderRepository,clientRepository,productRepository);
    }

    @Bean
    public DeleteOrderUseCase deleteOrderUseCase(OrderRepositoryImpl orderRepository){
        return new DeleteOrderService(orderRepository);
    }

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(OrderRepositoryImpl orderRepository,
                                                 ProductRepository productRepository,
                                                 ClientRepository clientRepository){
        return new UpdateOrderService(orderRepository,clientRepository,productRepository);
    }

    @Bean
    public FindByIdOrderUseCase findByIdOrderUseCase(OrderRepositoryImpl orderRepository){
        return new FindByIdOrderService(orderRepository);
    }

    @Bean
    public AllOrderUseCase allOrderUseCase(OrderRepositoryImpl orderRepository){
        return new ListOrderService(orderRepository);
    }
}
