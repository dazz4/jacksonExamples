package com.json.jackson.jsonparser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTestSuite {
    public static final String JSON = "{\"name\":\"Dariusz Kaminski\", \"email\":\"kaminski.darek@icloud.com\"}";

    @Autowired
    private Customer customer;

    @Test
    public void testJsonParser() throws IOException {
        JsonFactory factory = new JsonFactory();
        try {
            JsonParser parser = factory.createParser(JSON);

            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();
                System.out.println("jsonToken =" + jsonToken);
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonParserEquals() throws IOException {
        JsonFactory factory = new JsonFactory();
        try {
            JsonParser parser = factory.createParser(JSON);

            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldName = parser.getCurrentName();
                    System.out.println(fieldName);

                    jsonToken = parser.nextToken();

                    if ("name".equals(fieldName)) {
                        customer.setName(parser.getValueAsString());
                    } else if ("email".equals(fieldName)) {
                        customer.setEmail(parser.getValueAsString());
                    }
                }

            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        assertEquals("Dariusz Kaminski", customer.getName());
        assertEquals("kaminski.darek@icloud.com", customer.getEmail());
    }
}