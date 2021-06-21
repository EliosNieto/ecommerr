package com.ias.ecommerce.infrastructure.configuration;

import com.ias.ecommerce.application.ports.in.*;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import com.ias.ecommerce.application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationConfiguration {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository){
        return new CreateProductService(productRepository);
    }

    @Bean
    public AllProductUseCase allProductUseCase(ProductRepository productRepository){
        return new ListProductServices(productRepository);
    }

    @Bean
    public FindByIdProductUseCase findByIdProductUseCase(ProductRepository productRepository){
        return new FindByIdProductService(productRepository);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(ProductRepository productRepository){
        return new DeleteProductService(productRepository);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductRepository productRepository){
        return new UpdateProductService(productRepository);
    }

}
