package com.ias.ecommerce.application.ports.in;

import com.ias.ecommerce.application.commons.operation.ApplicationUseCase;
import com.ias.ecommerce.application.model.product.FindByIdProductRequest;
import com.ias.ecommerce.application.model.product.FindByIdProductResponse;

public interface FindByIdProductUseCase extends ApplicationUseCase<FindByIdProductRequest, FindByIdProductResponse> {
}
