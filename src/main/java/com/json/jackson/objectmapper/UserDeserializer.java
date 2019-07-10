package com.json.jackson.objectmapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {

    public UserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        User user = new User();
        while (!p.isClosed()) {
            JsonToken jsonToken = p.nextToken();

            System.out.println(jsonToken);
            System.out.println(p.currentName());

            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                String fieldName = p.getCurrentName();

                jsonToken = p.nextToken();

                if ("name".equals(fieldName)) {
                    user.setName(p.getValueAsString());
                } else if ("age".equals(fieldName)) {
                    user.setAge(p.getValueAsInt());
                }
            }
        }
        return user;
    }
}
