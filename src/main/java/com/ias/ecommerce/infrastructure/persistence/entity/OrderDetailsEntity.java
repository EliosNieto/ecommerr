package com.ias.ecommerce.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ORDER_PRODUCTS")
public class OrderDetailsEntity {

    @EmbeddedId
    private OrderProductPK orderProductPK;

    @Column(name = "value_product")
    private double valueProduct;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @MapsId(value = "orderId")
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false )
    private ProductEntity productEntity;

    public OrderProductPK getOrderProductPK() {
        return orderProductPK;
    }

    public void setOrderProductPK(OrderProductPK orderProductPK) {
        this.orderProductPK = orderProductPK;
    }

    public double getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(double valueProduct) {
        this.valueProduct = valueProduct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "orderProductPK=" + orderProductPK +
                ", valueProduct=" + valueProduct +
                ", amount=" + amount +
                ", total=" + total +
                ", productEntity=" + productEntity +
                '}';
    }
}
