package com.json.jackson.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
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

    @Test
    public void testJsonSetter() throws JsonProcessingException {
        //Given
        PersonSetter person = new PersonSetter();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"name\":\"Dariusz\",\"id\":0}", json);
    }

    @Test
    public void testJsonAnySetter() throws IOException {
        //Given
        String json = "{\"id\":123,\"name\":\"Dariusz\"}";
        ObjectMapper mapper = new ObjectMapper();

        //When
        PersonAnySetter person = mapper.readValue(json, PersonAnySetter.class);

        //Then
        assertEquals("Dariusz", person.get("name"));
        assertEquals(123, person.get("id"));
    }

    @Test
    public void testJsonCreator() throws IOException{
        //Given
        String json = "{\"id\":123,\"name\":\"Dariusz\"}";
        ObjectMapper mapper = new ObjectMapper();

        //When
        PersonCreator person = mapper.readValue(json, PersonCreator.class);

        //Then
        assertEquals(123L, person.getId());
        assertEquals("Dariusz", person.getName());
    }

    @Test
    public void testJacksonInject() throws IOException{
        //Given
        String json = "{\"id\":123,\"name\":\"Dariusz\"}";
        InjectableValues inject = new InjectableValues.Std().addValue(String.class, "dazz4-server");

        //When
        PersonInject person = new ObjectMapper().reader(inject)
                .forType(PersonInject.class)
                .readValue(json);

        //Then
        assertEquals("dazz4-server", person.getSource());
    }

    @Test
    public void testPersonDeserializer() throws IOException{
        //Given
        String json = "{\"id\":123,\"name\":\"Dariusz\"}";
        ObjectMapper mapper = new ObjectMapper();

        //When
        PersonDeserialize person = mapper.readValue(json, PersonDeserialize.class);

        //Then
        assertEquals("Username: Dariusz", person.getName());
    }
}