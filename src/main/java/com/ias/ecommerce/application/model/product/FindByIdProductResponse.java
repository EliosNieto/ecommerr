package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import com.ias.ecommerce.application.domain.Product;
import org.springframework.http.HttpStatus;

public class FindByIdProductResponse implements ApplicationResponse {

    private final Product product;

    public FindByIdProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.OK;
    }
}
