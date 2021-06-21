package com.ias.ecommerce.application.model.product;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class CreateProductRequest implements ApplicationRequest {

    private final String idProduct;
    private final String name;
    private final String description;
    private final String basePrice;
    private final String taxRate;
    private final String productStatus;
    private final String inventoryQuantity;

    public CreateProductRequest(String idProduct, String name, String description, String basePrice, String taxRate, String productStatus, String inventoryQuantity) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return Objects.equals(idProduct, that.idProduct) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(basePrice, that.basePrice) && Objects.equals(taxRate, that.taxRate) && Objects.equals(productStatus, that.productStatus) && Objects.equals(inventoryQuantity, that.inventoryQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, description, basePrice, taxRate, productStatus, inventoryQuantity);
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
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
