package com.json.jackson.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String userJson = "{\"name\" :  \"Kamil\", \"age\" : 35}";

        User user = objectMapper.readValue(userJson, User.class);

        assertEquals("Kamil", user.getName());
        assertEquals(35, user.getAge());
    }

    @Test
    public void testObjectMapperFromStringArray() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        String userJson = "[{\"name\":\"Kamil\", \"age\":\"null\"}, {\"name\":\"Dariusz\", \"age\":\"null\"}]";

        User[] user = objectMapper.readValue(userJson, User[].class);

        assertEquals("Kamil", user[0].getName());
        assertEquals("Dariusz", user[1].getName());
    }

    @Test
    public void testUserDeserializer() throws IOException {
        String userJson = "{\"name\":\"Kamil\", \"age\":\"35\"}";

        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer(User.class));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);

        User user = objectMapper.readValue(userJson, User.class);
        System.out.println(user.getName() + " " + user.getAge());
    }

    @Test
    public void testWriteValue() throws FileNotFoundException {
        List<User> users = new LinkedList<>();
        users.add(new User(1L,"Kamil", 35));

        ObjectMapper mapper = new ObjectMapper();

        try {

            String userJson = mapper.writeValueAsString(users.get(0));
            System.out.println(userJson);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUserSerializer() throws JsonProcessingException {
        UserSerializer userSerializer = new UserSerializer(User.class);
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(User.class, userSerializer);
        objectMapper.registerModule(module);

        User user = new User();
        user.setName("Dariusz");
        user.setAge(25);

        String userJson = objectMapper.writeValueAsString(user);
        System.out.println(userJson);
    }
}