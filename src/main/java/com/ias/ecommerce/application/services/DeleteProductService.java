package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.product.DeleteProductRequest;
import com.ias.ecommerce.application.model.product.DeleteProductResponse;
import com.ias.ecommerce.application.ports.in.DeleteProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class DeleteProductService implements DeleteProductUseCase {

    Logger logger = LoggerFactory.getLogger(DeleteProductService.class);

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DeleteProductResponse execute(DeleteProductRequest request) {
        IdentificationProduct identificationProduct = identificationProduct(request.getIdentificationProduct());

        Optional<Product> productOptional = productRepository.getFindById(identificationProduct);
        if(!productOptional.isPresent()){
            throw new ProductNotFound(identificationProduct);
        }



        productRepository.delete(identificationProduct);
        return new DeleteProductResponse();
    }

    private IdentificationProduct identificationProduct(String value) {
        try {
            return new IdentificationProduct(value);
        }catch (RuntimeException e){
            throw new InputDataError(e.getMessage());
        }
    }
}
