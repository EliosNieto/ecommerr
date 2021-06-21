package com.ias.ecommerce.infrastructure.persistence.common.mappers;

import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationNumberMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.IdentificationOrderMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.adapter.NonEmptyDecimalMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = {IdentificationOrderMapper.class,
                                          IdentificationNumberMapper.class,
                                                   OrderDetailMapper.class,
                                               NonEmptyDecimalMapper.class,
        ClientMapper.class
})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "orderId", target = "id"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "totalOrder", target = "totalOrder"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "clientEntity", target = "client"),
            @Mapping(source = "detailsEntities", target = "details"),
    })
    Order toOrder(OrderEntity orderEntity);
    Collection<Order> toOrders(Iterable<OrderEntity> orders);

    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);
}
