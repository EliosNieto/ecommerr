package com.ias.ecommerce.application.services;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;
import com.ias.ecommerce.application.commons.NonEmptyInteger;
import com.ias.ecommerce.application.commons.NonEmptyString;
import com.ias.ecommerce.application.commons.operation.FiltereEnum;
import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.domain.ProductStatus;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.errors.ProductExistsError;
import com.ias.ecommerce.application.model.product.UpdateProductRequest;
import com.ias.ecommerce.application.model.product.UpdateProductResponse;
import com.ias.ecommerce.application.ports.in.UpdateProductUseCase;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class UpdateProductService implements UpdateProductUseCase {

    Logger logger = LoggerFactory.getLogger(UpdateProductService.class);

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public UpdateProductResponse execute(UpdateProductRequest request) {
        logger.info(request.toString());
        Product product = validateProduct(request);

        Optional<Product> productOptional = productRepository.getFindById(product.getProductId());
        if (!productOptional.isPresent()) {
            throw new ProductExistsError(product.getProductId());
        }

        productRepository.update(product);
        logger.info(product.toString());
        return new UpdateProductResponse(product);
    }

    private Product validateProduct(UpdateProductRequest request) {
        try {
            IdentificationProduct identificationProduct = new IdentificationProduct(request.getIdProduct());
            NonEmptyString name = new NonEmptyString(request.getName());
            NonEmptyString description = new NonEmptyString(request.getDescription());
            NonEmptyDecimal basePrice = new NonEmptyDecimal(request.getBasePrice());
            NonEmptyDecimal taxRate = new NonEmptyDecimal(request.getTaxRate());
            ProductStatus productStatus = null;
            NonEmptyInteger inventoryQuantity = new NonEmptyInteger(request.getInventoryQuantity());

            try {
                productStatus = FiltereEnum.filter(ProductStatus.class, request.getProductStatus());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            return new Product(identificationProduct, name, description, basePrice, taxRate, productStatus, inventoryQuantity);

        } catch (RuntimeException e) {
            throw new InputDataError(e.getMessage());
        }
    }
}
