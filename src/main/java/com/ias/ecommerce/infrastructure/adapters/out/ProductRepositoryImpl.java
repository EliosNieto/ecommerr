package com.ias.ecommerce.infrastructure.adapters.out;

import com.ias.ecommerce.application.domain.IdentificationProduct;
import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.application.ports.out.ProductRepository;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.ProductMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.ProductEntity;
import com.ias.ecommerce.infrastructure.persistence.repository.ProductRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private final ProductRepositoryJpa productRepositoryJpa;
    private final ProductMapper productMapper;

    @Autowired
    public ProductRepositoryImpl(ProductRepositoryJpa productRepositoryJpa, ProductMapper productMapper) {
        this.productRepositoryJpa = productRepositoryJpa;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> getFindById(IdentificationProduct id) {
        Optional<ProductEntity> productEntity = productRepositoryJpa.findById(id.getValue());
        if(productEntity.isPresent()){
            return productEntity.map(productEntity1 -> productMapper.toProduct(productEntity1));
        }
        return Optional.empty();
    }

    @Override
    public void save(Product product) {
        logger.info(product.toString());
        ProductEntity productEntity = productMapper.toProductEntity(product);
        logger.info(productEntity.toString());
        productRepositoryJpa.save(productEntity);
    }

    @Override
    public Collection<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productRepositoryJpa.findAll();

        List<Product> products = productMapper.toProducts(productEntities);

        products.forEach(System.out::println);
        return productMapper.toProducts(productEntities);
    }

    @Override
    public Optional<Product> update(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        productEntity = productRepositoryJpa.save(productEntity);
        return Optional.of(productMapper.toProduct(productEntity));
    }

    @Override
    public void delete(IdentificationProduct identificationProduct) {
        logger.info(identificationProduct.toString());
        productRepositoryJpa.deleteById(identificationProduct.getValue());
    }
}
