package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.AllProductRequest;
import com.ias.ecommerce.application.model.product.AllProductResponse;

public interface AllProductUseCase extends ApplicationUseCase<AllProductRequest, AllProductResponse> {
}
