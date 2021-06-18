package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.DeleteProductRequest;
import com.ias.ecommerce.application.model.product.DeleteProductResponse;

public interface DeleteProductUseCase extends ApplicationUseCase<DeleteProductRequest, DeleteProductResponse> {
}
