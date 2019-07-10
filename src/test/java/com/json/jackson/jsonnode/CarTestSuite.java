package com.json.jackson.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTestSuite {

    @Autowired
    private Car car;

    private static final String JSONCAR = "{\"model\":\"Fiat\", \"gears\":5}";

    @Test
    public void testReadJsonNodeFromJSON() throws IOException {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        //When
        JsonNode jsonNode = objectMapper.readTree(JSONCAR);
        //Then
        assertEquals("Fiat", jsonNode.get("model").asText());
    }

    @Test
    public void testWriteJsonNodeToJSON() throws IOException {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(JSONCAR);
        //When
        String json = objectMapper.writeValueAsString(jsonNode);
        System.out.println(json);
        //Then
        assertEquals("{\"model\":\"Fiat\",\"gears\":5}", json);
    }

}