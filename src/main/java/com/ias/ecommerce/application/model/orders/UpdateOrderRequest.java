package com.ias.ecommerce.application.model.orders;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.io.Serializable;
import java.util.List;

public class UpdateOrderRequest implements ApplicationRequest {

    private final String idOrder;
    private final List<DetailRequest> detailRequests;

    public UpdateOrderRequest(String idOrder, List<DetailRequest> detailRequests) {
        this.idOrder = idOrder;
        this.detailRequests = detailRequests;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public List<DetailRequest> getDetailRequests() {
        return detailRequests;
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
