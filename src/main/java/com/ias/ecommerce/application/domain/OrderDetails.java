package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.NonEmptyDecimal;
import com.ias.ecommerce.application.commons.NonEmptyInteger;

public class OrderDetails {

    private final Product product;
    private final IdentificationOrder orderId;
    private final NonEmptyDecimal value;
    private final NonEmptyInteger amount;
    private final NonEmptyDecimal total;

    public OrderDetails(Product product, IdentificationOrder orderId, NonEmptyDecimal value, NonEmptyInteger amount, NonEmptyDecimal total) {
        this.product = product;
        this.orderId = orderId;
        this.value = value;
        this.amount = amount;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public IdentificationOrder getOrderId() {
        return orderId;
    }

    public NonEmptyDecimal getValue() {
        return value;
    }

    public NonEmptyInteger getAmount() {
        return amount;
    }

    public NonEmptyDecimal getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "product=" + product +
                ", orderId=" + orderId +
                ", value=" + value +
                ", amount=" + amount +
                ", total=" + total +
                '}';
    }
}
