package com.json.jackson.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonAnnotationsTestSuite {

    private static final String JSONUSER = "{\"name\":\"Dariusz\",\"email\":\"kaminski.darek@icloud.com\"}";

    @Test
    public void testJsonIgnore() throws IOException {
        //Given
        UserIgnore user = new UserIgnore(1L, "Dariusz", "kaminski.darek@icloud.com");
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Then
        assertEquals(JSONUSER, json);
    }

    @Test
    public void testJsonIgnoreProperties() throws JsonProcessingException {
        //Given
        PersonIgnoreProperties person = new PersonIgnoreProperties();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"lastName\":\"Kaminski\"}", json);
    }

    @Test
    public void testJsonIgnoreType() throws JsonProcessingException {
        //Given
        PersonIgnoreType person = new PersonIgnoreType();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"firstName\":\"Dariusz\",\"lastName\":\"Kaminski\"}", json);
    }

    @Test
    public void testJsonAutoDetect() throws JsonProcessingException{
        //Given
        PersonAutoDetect person = new PersonAutoDetect();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"id\":123,\"name\":\"Dariusz\"}", json);
    }

}