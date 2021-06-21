package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;

import java.util.List;
import java.util.UUID;

public class Order {

    private IdentificationOrder id;
    private Client client;
    private final OrderStatus status;
    private NonEmptyDecimal total;
    private NonEmptyDecimal discount;
    private NonEmptyDecimal totalOrder;
    private List<OrderDetails> details;

    public Order(IdentificationOrder id, Client client, OrderStatus status, NonEmptyDecimal total, NonEmptyDecimal discount, NonEmptyDecimal totalOrder, List<OrderDetails> details) {
        this.id = id;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public NonEmptyDecimal getTotal() {
        return total;
    }

    public void setTotal(NonEmptyDecimal total) {
        this.total = total;
    }

    public NonEmptyDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(NonEmptyDecimal discount) {
        this.discount = discount;
    }

    public NonEmptyDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(NonEmptyDecimal totalOrder) {
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
                ", client=" + client +
                ", status=" + status +
                ", total=" + total +
                ", discount=" + discount +
                ", totalOrder=" + totalOrder +
                ", details=" + details +
                '}';
    }

}
