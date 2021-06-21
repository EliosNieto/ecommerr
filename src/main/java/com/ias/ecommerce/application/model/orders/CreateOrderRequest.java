package com.ias.ecommerce.application.model.orders;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.io.Serializable;
import java.util.List;

public class CreateOrderRequest implements ApplicationRequest {

    private final String clientId;
    private final List<DetailRequest> details;

    public CreateOrderRequest(String clientId, List<DetailRequest> detailRequests) {
        this.clientId = clientId;
        this.details = detailRequests;
    }

    public String getClientId() {
        return clientId;
    }

    public List<DetailRequest> getDetails() {
        return details;
    }

    public static class DetailRequest implements Serializable {

        private final String productId;
        private final String amount;

        public DetailRequest(String productId, String amount) {
            this.productId = productId;
            this.amount = amount;
        }

        public String getProductId() {
            return productId;
        }

        public String getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "DetailRequest{" +
                    "productId='" + productId + '\'' +
                    ", amount='" + amount + '\'' +
                    '}';
        }
    }

}
