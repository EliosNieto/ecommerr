package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.OrderDetails;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationOrderMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NonEmptyDecimalMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NonEmptyIntegerMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.ProductIdentificationMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderDetailsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = {IdentificationOrderMapper.class,
                                         ProductIdentificationMapper.class,
                                                       ProductMapper.class,
                                               NonEmptyIntegerMapper.class,
                                         ProductIdentificationMapper.class,
        NonEmptyDecimalMapper.class})
public interface OrderDetailMapper {

    @Mappings({
            @Mapping(source = "orderProductPK.orderId", target = "orderId"),
            @Mapping(source = "productEntity", target = "product"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "valueProduct", target = "value"),

    })
    OrderDetails toOrderDetails(OrderDetailsEntity orderDetailsEntity);


    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "product.productId", target = "orderProductPK.productId")})
    OrderDetailsEntity toOrderDetailsEntity(OrderDetails orderDetails);
    Collection<OrderDetails> toOrderDetails(Iterable<OrderDetails> orderDetails);
}
