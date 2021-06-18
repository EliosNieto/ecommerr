package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.model.product.AllProductRequest;
import com.ias.ecommerce.application.model.product.AllProductResponse;
import com.ias.ecommerce.application.ports.in.AllProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;

import java.util.List;

public class AllProductServices implements AllProductUseCase {

    private final ProductRepository productRepository;

    public AllProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public AllProductResponse execute(AllProductRequest request) {
        List<Product> products = (List<Product>) productRepository.getAll();
        System.out.println("----------------------");
        products.forEach(System.out::println);
        return new AllProductResponse(products);
    }
}
