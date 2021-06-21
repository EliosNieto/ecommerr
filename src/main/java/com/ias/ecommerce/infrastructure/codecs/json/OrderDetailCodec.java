package com.ias.ecommerce.infrastructure.codecs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ias.ecommerce.application.domain.Order;
import com.ias.ecommerce.application.domain.OrderDetails;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class OrderDetailCodec {
    public static class OrderDetailSerializer extends JsonSerializer<OrderDetails> {

        @Override
        public void serialize(OrderDetails value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeObjectFieldStart("product");
            gen.writeNumberField("idProduct", value.getProduct().getProductId().getValue());
            gen.writeStringField("name", value.getProduct().getName().getValue());
            gen.writeNumberField("basePrice", value.getProduct().getBasePrice().getValue());
            gen.writeEndObject();
            gen.writeNumberField("value", value.getValue().getValue());
            gen.writeNumberField("amount", value.getAmount().getValue());
            gen.writeNumberField("total", value.getTotal().getValue());
            gen.writeEndObject();
        }
    }

}
