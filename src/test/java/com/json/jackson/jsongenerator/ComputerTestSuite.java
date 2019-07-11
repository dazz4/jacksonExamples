package com.json.jackson.jsongenerator;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputerTestSuite {

    @Autowired
    private Computer computer;

    @Test
    public void testJsonGenerator() throws IOException {
        //Given
        Path path = Paths.get("src/main/resources/Computer.json");

        computer.setCpu("i7");
        computer.setGpu("geforce");
        computer.setRam(32);

        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(path.toFile(), JsonEncoding.UTF8);

        generator.writeStartObject();
        generator.writeStringField("cpu", computer.getCpu());
        generator.writeStringField("gpu", computer.getGpu());
        generator.writeNumberField("ram", computer.getRam());
        generator.writeEndObject();
        generator.close();

        //When
        String json = Files.readString(path);

        //Then
        assertEquals("{\"cpu\":\"i7\",\"gpu\":\"geforce\",\"ram\":32}", json);
    }

}