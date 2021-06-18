package com.ias.ecommerce.application.domain;

public class OrderDetails {

    private final IdentificationProduct productId;
    private IdentificationOrder orderId;
    private Double value;
    private final Integer amount;
    private  Double total;

    public OrderDetails(IdentificationProduct productId, IdentificationOrder orderId, Double value, Integer amount, Double total) {
        this.productId = productId;
        this.orderId = orderId;
        this.value = value;
        this.amount = amount;
        this.total = total;
    }

    public IdentificationProduct getProductId() {
        return productId;
    }

    public IdentificationOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(IdentificationOrder orderId) {
        this.orderId = orderId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "productId=" + productId +
                ", orderId=" + orderId +
                ", value=" + value +
                ", amount=" + amount +
                ", total=" + total +
                '}';
    }
}
