package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.model.product.DeleteProductRequest;
import com.ias.ecommerce.application.model.product.DeleteProductResponse;
import com.ias.ecommerce.application.ports.in.DeleteProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteProductService implements DeleteProductUseCase {

    Logger logger = LoggerFactory.getLogger(DeleteProductService.class);

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DeleteProductResponse execute(DeleteProductRequest request) {
        logger.info(request.toString());
        IdentificationProduct identificationProduct = identificationProduct(request.getIdentificationProduct());
        productRepository.delete(identificationProduct);
        logger.info("Eliminado");
        return new DeleteProductResponse();
    }

    private IdentificationProduct identificationProduct(String value){
        return new IdentificationProduct(value);
    }
}
