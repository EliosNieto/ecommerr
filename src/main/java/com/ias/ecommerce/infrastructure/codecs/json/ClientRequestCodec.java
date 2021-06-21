package com.ias.ecommerce.infrastructure.codecs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ias.ecommerce.application.domain.Client;
import com.ias.ecommerce.application.domain.Employee;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ClientRequestCodec {

    public static class ClientSerializer extends JsonSerializer<Client> {

        @Override
        public void serialize(Client value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeNumberField("identification", value.getIdentificationNumber().getValue());
            gen.writeStringField("names", value.getNames().getValue());
            gen.writeStringField("lastNames", value.getLastNames().getValue());
            gen.writeEndObject();
        }
    }
}
