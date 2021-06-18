package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Product;
import org.springframework.http.HttpStatus;

public class CreateProductResponse implements ApplicationResponse {
    private final Product product;

    public CreateProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "CreateProductResponse{" +
                "product=" + product +
                '}';
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.CREATED;
    }
}
