package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.UpdateProductRequest;
import com.ias.ecommerce.application.model.product.UpdateProductResponse;

public interface UpdateProductUseCase extends ApplicationUseCase<UpdateProductRequest, UpdateProductResponse> {
}
