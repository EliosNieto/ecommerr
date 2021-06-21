package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class UpdateProductRequest implements ApplicationRequest {

    private String productId;
    private final String name;
    private final String description;
    private final String basePrice;
    private final String taxRate;
    private final String productStatus;
    private final String inventoryQuantity;

    public UpdateProductRequest(String name, String description, String basePrice, String taxRate, String productStatus, String inventoryQuantity) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.productStatus = productStatus;
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public String getInventoryQuantity() {
        return inventoryQuantity;
    }

    @Override
    public String toString() {
        return "UpdateProductRequest{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", inventoryQuantity='" + inventoryQuantity + '\'' +
                '}';
    }
}
