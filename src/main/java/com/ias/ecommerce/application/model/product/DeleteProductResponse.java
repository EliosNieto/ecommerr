package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationResponse;
import org.springframework.http.HttpStatus;

public class DeleteProductResponse implements ApplicationResponse {

    @Override
    public HttpStatus statusResponse() {
        return HttpStatus.NO_CONTENT;
    }
}
