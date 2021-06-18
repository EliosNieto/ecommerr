package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.errors.InputDataError;

import java.util.Arrays;
import java.util.Optional;

public enum ProductStatus {
    BORRADOR,
    PUBLICADO;

    public static ProductStatus getProductStatus(String value) {
        Optional<ProductStatus> productStatusOptional = Arrays.stream(ProductStatus.values())
                .filter(productStatus -> productStatus.name().equals(value)).findAny();

        if(!productStatusOptional.isPresent()){
            System.out.println("------------------");
            throw new IllegalArgumentException();
        }
        return productStatusOptional.get();
    }

}
