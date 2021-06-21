package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.ListProductRequest;
import com.ias.ecommerce.application.model.product.ListProductResponse;

public interface AllProductUseCase extends ApplicationUseCase<ListProductRequest, ListProductResponse> {
}
