package com.ias.ecommerce.infrastructure.codecs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ias.ecommerce.application.domain.Product;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductRequestCodec {

    public static class ProductSerialize extends JsonSerializer<Product> {

        @Override
        public void serialize(Product value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeNumberField("idProduct", value.getProductId().getValue());
            gen.writeStringField("name", value.getName().getValue());
            gen.writeStringField("description", value.getDescription().getValue());
            gen.writeNumberField("basePrice", value.getBasePrice().getValue());
            gen.writeNumberField("taxRate", value.getTaxRate().getValue());
            gen.writeStringField("productStatus", value.getProductStatus().name());
            gen.writeNumberField("inventoryQuantity", value.getInventoryQuantity().getValue());
            gen.writeEndObject();
        }
    }
}
