package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.jackson.annotations.readannotations.PersonPropertyOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonWriteAnnotationsTestSuite {

    @Test
    public void testPersonInclude() throws Exception{
        //Given
        PersonInclude person = new PersonInclude();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"id\":0}", json);
    }

    @Test
    public void testPersonGetter() throws IOException {
        //Given
        PersonGetter person = new PersonGetter();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writeValueAsString(person);
        System.out.println(json);

        //Then
        assertEquals("{\"id\":1}", json);
    }

    @Test
    public void testPersonAnyGetter() throws IOException{
        //Given
        PersonAnyGetter person = new PersonAnyGetter();
        Map<String, String> personDetails = person.getDetails();
        personDetails.put("id", "1");
        personDetails.put("name", "Dariusz");
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void testPersonPropertyOrder() throws IOException {
        //Given
        PersonPropertyOrder person = new PersonPropertyOrder();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void testJsonRawValue() throws IOException{
        //Given
        PersonRawValue person = new PersonRawValue();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void testJsonValue() throws IOException {
        //Given
        PersonValue person = new PersonValue();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void testJsonSerialize() throws JsonProcessingException {
        //Given
        PersonSerialize person = new PersonSerialize();
        ObjectMapper mapper = new ObjectMapper();

        //When
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);
    }
}