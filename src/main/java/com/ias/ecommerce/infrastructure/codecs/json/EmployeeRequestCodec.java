package com.ias.ecommerce.infrastructure.codecs.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ias.ecommerce.application.domain.Employee;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class EmployeeRequestCodec {

    public static class EmployeeSerializer extends JsonSerializer<Employee> {

        @Override
        public void serialize(Employee value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeNumberField("identification", value.getIdentificationNumber().getValue());
            gen.writeStringField("names", value.getNames().getValue());
            gen.writeStringField("lastNames", value.getLastNames().getValue());
            gen.writeEndObject();
        }
    }

}
