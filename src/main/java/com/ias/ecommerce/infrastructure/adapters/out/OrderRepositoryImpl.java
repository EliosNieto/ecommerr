package com.ias.ecommerce.infrastructure.adapters.out;

import com.ias.ecommerce.application.domain.IdentificationOrder;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.ports.out.ClientRepository;
import com.ias.ecommerce.application.ports.out.OrderRepository;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.OrderDetailMapper;
import com.ias.ecommerce.infrastructure.persistence.common.mappers.OrderMapper;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderDetailsEntity;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderEntity;
import com.ias.ecommerce.infrastructure.persistence.entity.OrderProductPK;
import com.ias.ecommerce.infrastructure.persistence.entity.ProductEntity;
import com.ias.ecommerce.infrastructure.persistence.repository.ClientRepositoryJpa;
import com.ias.ecommerce.infrastructure.persistence.repository.OrderDetailsJpa;
import com.ias.ecommerce.infrastructure.persistence.repository.OrderRepositoryJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private Logger logger = LoggerFactory.getLogger(OrderRepositoryImpl.class);

    private final OrderRepositoryJpa orderRepositoryJpa;
    private final ClientRepositoryJpa clientRepository;
    private final OrderDetailsJpa orderDetailsJpa;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;

    public OrderRepositoryImpl(OrderRepositoryJpa orderRepositoryJpa, ClientRepositoryJpa clientRepository, OrderDetailsJpa orderDetailsJpa, OrderMapper orderMapper, OrderDetailMapper orderDetailMapper) {
        this.orderRepositoryJpa = orderRepositoryJpa;
        this.clientRepository = clientRepository;
        this.orderDetailsJpa = orderDetailsJpa;
        this.orderMapper = orderMapper;
        this.orderDetailMapper = orderDetailMapper;
    }

    @Override
    public Optional<Order> save(Order order) {
        orderDetailMapper.toOrderDetails(order.getDetails());
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        OrderEntity finalOrderEntity = orderEntity;
        orderEntity.getDetailsEntities().forEach(
                orderDetailsEntity -> orderDetailsEntity.setOrderEntity(finalOrderEntity));
        logger.info(orderEntity.toString());
        orderEntity = orderRepositoryJpa.save(orderEntity);
        return Optional.of(orderMapper.toOrder(orderEntity));
    }

    @Override
    public void delete(IdentificationOrder id) {
        orderRepositoryJpa.deleteById(id.getValue());
    }

    @Override
    public Optional<Order> update(Order order) {
        logger.info(order.toString());
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        logger.info(orderEntity.toString());
        OrderDetailsEntity detailsEntity = orderEntity.getDetailsEntities().get(0);
        logger.info(detailsEntity.toString());
        orderDetailsJpa.deleteByOrderProductPKOrderIdAndOrderProductPKProductId(
                detailsEntity.getOrderProductPK().getOrderId(),
                detailsEntity.getOrderProductPK().getProductId());
        orderRepositoryJpa.save(orderEntity);
        return Optional.of(orderMapper.toOrder(orderEntity));

        /*
        OrderEntity orderEntity = orderRepositoryJpa.findById(4l).get();
        OrderEntity orderEntity2 = orderMapper.toOrderEntity(order);

        orderEntity2.setClientEntity(clientRepository.findById(1082959591l).get());
        //orderEntity.getDetailsEntities().get(0).setAmount(10);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(11l);

        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setAmount(20);
        orderDetailsEntity.setValueProduct(9);
        orderDetailsEntity.setOrderEntity(orderEntity);
        orderDetailsEntity.setOrderProductPK(new OrderProductPK(4l,11l));
        orderDetailsEntity.setProductEntity(productEntity);
        orderDetailsEntity.setTotal(30D);
        orderEntity.getDetailsEntities().add(orderDetailsEntity);

        logger.info("+++++++++++++++++++++++");
        logger.info(orderEntity.toString());
        logger.info(orderEntity2.toString());
        logger.info("+++++++++++++++++++++++");

        orderEntity.getDetailsEntities().forEach(orderDetailsEntity1 -> logger.info(orderDetailsEntity1.toString()));

        OrderEntity orderEntit = orderRepositoryJpa.save(orderEntity2);



        return Optional.of(orderMapper.toOrder(orderEntit));

        logger.info(order.toString());
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        logger.info(orderEntity.toString());
        OrderEntity finalOrderEntity = orderEntity;
        logger.info("save");
        orderEntity.getDetailsEntities().forEach(orderDetailsEntity -> logger.info(orderDetailsEntity.toString()));
        orderEntity = orderRepositoryJpa.save(orderEntity);
        return Optional.of(orderMapper.toOrder(orderEntity));

         */
    }

    @Override
    public Optional<Order> findById(IdentificationOrder id) {
        Optional<OrderEntity> orderEntity = orderRepositoryJpa.findById(id.getValue());
        return orderEntity.map(orderEntity1 -> orderMapper.toOrder(orderEntity1));
    }

    @Override
    public Optional<Collection<Order>> getAll() {
        Iterable<OrderEntity> orderEntities = orderRepositoryJpa.findAll();
        orderEntities.forEach(orderEntity -> logger.info(orderEntity.toString()));
        Collection<Order> orders = orderMapper.toOrders(orderEntities);
        return Optional.of(orders);
    }


}
