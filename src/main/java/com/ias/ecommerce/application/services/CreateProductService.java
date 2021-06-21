package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;
import com.ias.ecommerce.application.commons.NonEmptyInteger;
import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.commons.FilterEnum;
import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.domain.ProductStatus;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductExistsError;
import com.ias.ecommerce.application.model.product.CreateProductRequest;
import com.ias.ecommerce.application.model.product.CreateProductResponse;
import com.ias.ecommerce.application.ports.in.CreateProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreateProductService implements CreateProductUseCase {

    Logger LOGGER = LoggerFactory.getLogger(CreateProductService.class);

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public CreateProductResponse execute(CreateProductRequest request) {
        LOGGER.debug(request.toString());
        Product product = validateInput(request);

        Optional<Product> productFind = productRepository.getFindById(product.getProductId());

        if(productFind.isPresent()){
            throw new ProductExistsError(product.getProductId());
        }

        productRepository.save(product);

        return new CreateProductResponse(product);
    }

    private Product validateInput(CreateProductRequest request){
        IdentificationProduct identificationProduct = null;
        NonEmptyString name = null;
        NonEmptyString description = null;
        NonEmptyDecimal basePrice = null;
        NonEmptyDecimal taxRate = null;
        ProductStatus productStatus = null;
        NonEmptyInteger inventoryQuantity;

        try {
            identificationProduct = new IdentificationProduct(request.getIdProduct());
            name = new NonEmptyString(request.getName());
            description = new NonEmptyString(request.getDescription());
            basePrice = new NonEmptyDecimal(request.getBasePrice());
            taxRate = new NonEmptyDecimal(request.getTaxRate());
            inventoryQuantity = new NonEmptyInteger(request.getInventoryQuantity());

            productStatus = FilterEnum.filter(ProductStatus.class, request.getProductStatus());


            return new Product(identificationProduct,name,description, basePrice, taxRate, productStatus, inventoryQuantity);

        } catch(RuntimeException e) {
            LOGGER.info(e.getMessage());

            throw new InputDataError(e.getMessage());
        }
    }
}
