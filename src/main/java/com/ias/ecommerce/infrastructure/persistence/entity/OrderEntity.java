package com.ias.ecommerce.infrastructure.persistence.entity;

import com.ias.ecommerce.application.domain.OrderStatus;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "total_order", nullable = false)
    private double totalOrder;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> detailsEntities;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<OrderDetailsEntity> getDetailsEntities() {
        return detailsEntities;
    }

    public void setDetailsEntities(List<OrderDetailsEntity> detailsEntities) {
        this.detailsEntities = detailsEntities;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", status=" + status +
                ", total=" + total +
                ", discount=" + discount +
                ", totalOrder=" + totalOrder +
                ", clientEntity=" + clientEntity +
                ", detailsEntities=" + detailsEntities +
                '}';
    }
}
