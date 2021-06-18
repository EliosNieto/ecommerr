package com.ias.ecommerce.application.domain;

import com.ias.ecommerce.application.commons.*;

import static com.ias.ecommerce.application.commons.NumberUtils.numberGreaterThan;

public class Product {

    private final IdentificationProduct productId;
    private final NonEmptyString name;
    private final NonEmptyString description;
    private final NonEmptyDecimal basePrice;
    private final NonEmptyDecimal taxRate;
    private final ProductStatus productStatus;
    private final NonEmptyInteger inventoryQuantity;

    private final int NAME_LENGTH = 100;
    private final int DESCRIPTION_LENGTH = 280;
    private final int LENGTH_MIN_DECIMAL = -1;
    private final int LENGTH_MAX_DECIMAL = 1;

    public Product(IdentificationProduct productId, NonEmptyString name, NonEmptyString description,
                   NonEmptyDecimal basePrice, NonEmptyDecimal taxRate, ProductStatus productStatus,
                   NonEmptyInteger inventoryQuantity ) {
        Validate.notNull(productId, "ProductId can not be null");
        Validate.notNull(name, "Name can not be null");
        Validate.notNull(description, "Description can not be null");
        Validate.isTrue(!numberGreaterThan(name.getValue().length(), NAME_LENGTH),"Name maximum "+NAME_LENGTH+" characters");
        Validate.isTrue(!numberGreaterThan(description.getValue().length(), DESCRIPTION_LENGTH),"Description maximum "+DESCRIPTION_LENGTH+" characters");

        Validate.notNull(basePrice, "basePrice can not be null");
        Validate.isTrue(NumberUtils.doubleGreaterThan(basePrice.getValue(), LENGTH_MIN_DECIMAL), "basePrice value greater than or equal to 0");

        Validate.notNull(taxRate, "TaxRate can not be null");
        Validate.isTrue(NumberUtils.doubleGreaterThan(taxRate.getValue(), LENGTH_MIN_DECIMAL), "TaxRate value greater than or equal to 0");
        Validate.isTrue(!NumberUtils.doubleGreaterThan(taxRate.getValue(), LENGTH_MAX_DECIMAL), "TaxRate value greater than or equal to 1");


        this.productId = productId;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
        this.productStatus = productStatus;
        this.inventoryQuantity = inventoryQuantity;
    }

    public IdentificationProduct getProductId() {
        return productId;
    }

    public NonEmptyString getName() {
        return name;
    }

    public NonEmptyString getDescription() {
        return description;
    }

    public NonEmptyDecimal getBasePrice() {
        return basePrice;
    }

    public NonEmptyDecimal getTaxRate() {
        return taxRate;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public NonEmptyInteger getInventoryQuantity() {
        return inventoryQuantity;
    }
}
