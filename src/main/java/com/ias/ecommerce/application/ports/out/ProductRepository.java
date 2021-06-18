package com.ias.ecommerce.application.ports.out;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> getFindById(IdentificationProduct id);

    void save(Product product);

    Collection<Product> getAll();

    void delete(IdentificationProduct identificationProduct);

    Optional<Product> update(Product product);

}
