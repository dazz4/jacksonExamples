package com.json.jackson.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
    private Vehicle vehicle;

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

    @Test
    public void testCreateObjectNode() throws IOException {
        //Given
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode parentNode = objectMapper.createObjectNode();
        JsonNode childNode = objectMapper.readTree(JSONCAR);
        parentNode.set("car", childNode);
        parentNode.put("wheels", 4);

        //When
        String json = objectMapper.writeValueAsString(parentNode);
        Vehicle carJson = objectMapper.readValue(json, Vehicle.class);

        //Then
        System.out.println("Creating ObjectNode: " + json);
        assertEquals("Fiat", childNode.get("model").asText());
        assertEquals(5, childNode.get("gears").asInt());
        assertEquals("Fiat", carJson.getCar().getModel());
        assertEquals(5, carJson.getCar().getGears());
    }

}