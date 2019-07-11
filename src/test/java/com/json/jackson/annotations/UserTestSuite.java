package com.json.jackson.annotations;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    private static final String JSONUSER = "{\"name\":\"Dariusz\",\"email\":\"kaminski.darek@icloud.com\"}";

    @Test
    public void testJsonIgnore() throws IOException {
        //Given
        User user = new User(1L, "Dariusz", "kaminski.darek@icloud.com");
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(user);

        //Then
        assertEquals(JSONUSER, json);
    }

}