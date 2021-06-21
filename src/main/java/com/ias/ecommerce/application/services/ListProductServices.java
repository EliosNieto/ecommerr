package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.model.product.ListProductRequest;
import com.ias.ecommerce.application.model.product.ListProductResponse;
import com.ias.ecommerce.application.ports.in.AllProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;

import java.util.List;

public class ListProductServices implements AllProductUseCase {

    private final ProductRepository productRepository;

    public ListProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ListProductResponse execute(ListProductRequest request) {
        List<Product> products = (List<Product>) productRepository.getAll();
        System.out.println("----------------------");
        products.forEach(System.out::println);
        return new ListProductResponse(products);
    }
}
