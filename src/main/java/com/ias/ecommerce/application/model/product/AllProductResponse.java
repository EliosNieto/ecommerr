package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

public class AllProductResponse implements ApplicationResponse {

    private final List<Product> products;

    public AllProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "AllProductResponse{" +
                "products=" + products +
                '}';
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
