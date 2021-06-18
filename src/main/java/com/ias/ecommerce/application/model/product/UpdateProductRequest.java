package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class UpdateProductRequest implements ApplicationRequest {

    private final String idProduct;
    private final String name;
    private final String description;
    private final String basePrice;
    private final String taxRate;
    private final String productStatus;
    private final String inventoryQuantity;

    public UpdateProductRequest(String idProduct, String name, String description, String basePrice, String taxRate, String productStatus, String inventoryQuantity) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.productStatus = productStatus;
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getIdProduct() {
        return idProduct;
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
                "idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", inventoryQuantity='" + inventoryQuantity + '\'' +
                '}';
    }
}
