package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.CreateProductRequest;
import com.ias.ecommerce.application.model.product.CreateProductResponse;

public interface CreateProductUseCase extends ApplicationUseCase<CreateProductRequest, CreateProductResponse> {
}
