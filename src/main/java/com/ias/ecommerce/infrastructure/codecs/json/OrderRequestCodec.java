package com.ias.ecommerce.infrastructure.codecs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ias.ecommerce.application.domain.Order;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class OrderRequestCodec {
    public static class OrderSerializer extends JsonSerializer<Order> {

        @Override
        public void serialize(Order value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeNumberField("id", value.getId().getValue());
            gen.writeObjectField("client", value.getClient());
            gen.writeStringField("status", value.getStatus().name());
            gen.writeNumberField("total", value.getTotal().getValue());
            gen.writeNumberField("discount", value.getDiscount().getValue());
            gen.writeNumberField("totalOrder", value.getTotalOrder().getValue());
            gen.writeObjectField("details", value.getDetails());
            gen.writeEndObject();
        }
    }
}
