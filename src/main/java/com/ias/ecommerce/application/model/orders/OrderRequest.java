package com.ias.ecommerce.application.model.orders;

import com.ias.ecommerce.application.commons.operation.ApplicationRequest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class OrderRequest implements ApplicationRequest {

    private String id;
    private String clientId;
    private List<DetailRequest> detailRequests;

    public OrderRequest(){}

    public OrderRequest(String clientId, List<DetailRequest> detailRequests) {
        this.clientId = clientId;
        this.detailRequests = detailRequests;
    }

    public OrderRequest(String id, String clientId, List<DetailRequest> detailRequests) {
        this.id = id;
        this.clientId = clientId;
        this.detailRequests = detailRequests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Collection<DetailRequest> getDetailRequests() {
        return detailRequests;
    }

    public void setDetailRequests(List<DetailRequest> detailRequests) {
        this.detailRequests = detailRequests;
    }

    public static class DetailRequest implements Serializable {

        private String productId;
        private String amount;

        public DetailRequest(){}


        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "DetailRequest{" +
                    "productId='" + productId + '\'' +
                    ", amount='" + amount + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "clientId=" + clientId +
                ", detailRequests=" + detailRequests +
                '}';
    }


}
