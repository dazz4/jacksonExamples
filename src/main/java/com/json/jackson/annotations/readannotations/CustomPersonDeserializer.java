package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomPersonDeserializer extends JsonDeserializer<PersonDeserialize> {

    @Override
    public PersonDeserialize deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        PersonDeserialize person = new PersonDeserialize();

        while (!p.isClosed()) {
            JsonToken token = p.nextToken();

            if (JsonToken.FIELD_NAME.equals(token)) {
                String fieldName = p.getCurrentName();

                token = p.nextToken();

                if ("id".equals(fieldName)) {
                    person.setId(p.getValueAsLong());
                } else if ("name".equals(fieldName)) {
                    person.setName("Username: " + p.getValueAsString());
                }

            }

        }

        return person;
    }
}
