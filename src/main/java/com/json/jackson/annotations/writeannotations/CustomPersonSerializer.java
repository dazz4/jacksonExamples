package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomPersonSerializer extends JsonSerializer<PersonSerialize> {

    @Override
    public void serialize(PersonSerialize value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        gen.writeStartObject();
        gen.writeStringField("username", value.getName());
        gen.writeNumberField("personId", value.getId());
        gen.writeEndObject();
        gen.close();
    }
}
