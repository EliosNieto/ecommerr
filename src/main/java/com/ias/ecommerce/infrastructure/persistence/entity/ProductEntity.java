package com.ias.ecommerce.infrastructure.persistence.entity;

import com.ias.ecommerce.infrastructure.persistence.common.StateProduct;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 280, nullable = false)
    private String description;

    @Column(name = "base_price", nullable = false)
    private Double basePrice;

    @Column(name = "tax_rate", nullable = false)
    private Double taxRate;

    @Enumerated(EnumType.STRING)
    private StateProduct stateProduct;

    @Column(name = "inventory_quantity", nullable = false)
    private Integer inventoryQuantity;

    private LocalDate date;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public StateProduct getStateProduct() {
        return stateProduct;
    }

    public void setStateProduct(StateProduct stateProduct) {
        this.stateProduct = stateProduct;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice=" + basePrice +
                ", taxRate=" + taxRate +
                ", stateProduct=" + stateProduct +
                ", inventoryQuantity=" + inventoryQuantity +
                ", date=" + date +
                '}';
    }
}
