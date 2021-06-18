package com.ias.ecommerce.application.domain;

import java.util.List;
import java.util.UUID;

public class Order {

    private IdentificationOrder id;
    private IdentificationNumber clientId;
    private final OrderStatus status;
    private Double total;
    private Float discount;
    private Double totalOrder;
    private List<OrderDetails> details;

    public Order(IdentificationOrder id, IdentificationNumber clientId, OrderStatus status, Double total, Float discount, Double totalOrder, List<OrderDetails> details) {
        this.id = id;
        this.clientId = clientId;
        this.status = status;
        this.total = total;
        this.discount = discount;
        this.totalOrder = totalOrder;
        this.details = details;
    }

    public IdentificationOrder getId() {
        return id;
    }

    public void setId(IdentificationOrder id) {
        this.id = id;
    }

    public IdentificationNumber getClientId() {
        return clientId;
    }

    public void setClientId(IdentificationNumber clientId) {
        this.clientId = clientId;
    }

    public OrderStatus getStatus() {
        return status;
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

    public Double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public List<OrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", status=" + status +
                ", total=" + total +
                ", discount=" + discount +
                ", totalOrder=" + totalOrder +
                ", details=" + details +
                '}';
    }

}
