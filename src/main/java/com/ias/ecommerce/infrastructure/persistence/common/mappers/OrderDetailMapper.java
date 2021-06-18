package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.OrderDetails;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationOrderMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.ProductIdentificationMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderDetailsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = {IdentificationOrderMapper.class, ProductIdentificationMapper.class})
public interface OrderDetailMapper {

    @Mappings({
            @Mapping(source = "orderProductPK.orderId", target = "orderId"),
            @Mapping(source = "orderProductPK.productId", target = "productId"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "valueProduct", target = "value"),

    })
    OrderDetails toOrderDetails(OrderDetailsEntity orderDetailsEntity);
    Collection<OrderDetails> toOrderDetails(Iterable<OrderDetails> orderDetails);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "orderId", target = "orderProductPK.orderId"),
            @Mapping(target = "orderEntity", ignore = true),
            @Mapping(source = "productId", target = "productEntity.productId")
    })
    OrderDetailsEntity toOrderDetailsEntity(OrderDetails orderDetails);
}
