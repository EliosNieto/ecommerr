package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductNotFound;
import com.ias.ecommerce.application.model.product.FindByIdProductRequest;
import com.ias.ecommerce.application.model.product.FindByIdProductResponse;
import com.ias.ecommerce.application.ports.in.FindByIdProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;

import java.util.Optional;

public class FindByIdProductService implements FindByIdProductUseCase {

    private final ProductRepository productRepository;

    public FindByIdProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public FindByIdProductResponse execute(FindByIdProductRequest request) {
        IdentificationProduct identificationProduct = identificationProduct(request.getIdentificationProduct());
        Optional<Product> productOptional = this.productRepository.getFindById(identificationProduct);

        if (!productOptional.isPresent()){
            throw new ProductNotFound(identificationProduct);
        }

        return new FindByIdProductResponse(productOptional.get());
    }

    private IdentificationProduct identificationProduct(String value) {
        try {
            return new IdentificationProduct(value);

        }catch (RuntimeException e){
           throw  new InputDataError(e.getMessage());
        }
    }
}
