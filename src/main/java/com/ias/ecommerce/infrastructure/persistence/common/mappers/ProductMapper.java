package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.Product;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NomEmptyStringMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NonEmptyDecimalMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NonEmptyIntegerMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.ProductIdentificationMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductIdentificationMapper.class, NomEmptyStringMapper.class, NonEmptyDecimalMapper.class, NonEmptyIntegerMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source ="productId", target = "productId"),
            @Mapping(source ="name", target = "name"),
            @Mapping(source ="description", target = "description"),
            @Mapping(source ="basePrice", target = "basePrice"),
            @Mapping(source ="taxRate", target = "taxRate"),
            @Mapping(source ="stateProduct", target = "productStatus"),
            @Mapping(source ="inventoryQuantity", target = "inventoryQuantity"),
    })
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "date", ignore = true)
    })
    ProductEntity toProductEntity(Product product);
}
