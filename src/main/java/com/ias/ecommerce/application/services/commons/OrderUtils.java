package com.ias.ecommerce.application.services.commons;

import com.ias.ecommerce.application.commons.NumberUtils;
import com.ias.ecommerce.application.domain.*;
import com.ias.ecommerce.application.errors.InputDataError;
import com.ias.ecommerce.application.model.orders.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public abstract class OrderUtils {

    public static Order validateRequest(OrderRequest request) {
        IdentificationNumber identificationNumber = null;

        try {
            identificationNumber = new IdentificationNumber(request.getClientId());
            List<OrderDetails> detailsOrder = new ArrayList<>();

            final OrderDetails orderDetails = null;
            IdentificationProduct identificationProduct = null;

            for (OrderRequest.DetailRequest details : request.getDetailRequests()) {
                identificationProduct = new IdentificationProduct(details.getProductId());
                detailsOrder.add(
                        new OrderDetails(identificationProduct, new IdentificationOrder(null), 0D, NumberUtils.toInteger(details.getAmount()), 0D)
                );
            }

            return new Order(new IdentificationOrder(null), identificationNumber, OrderStatus.Registrada, 0D, 0F, 0D, detailsOrder);
        } catch (RuntimeException e) {
            throw new InputDataError(e.getMessage());
        }
    }

}
