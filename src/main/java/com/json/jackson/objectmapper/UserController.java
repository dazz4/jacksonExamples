package com.json.jackson.objectmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = GET, value = "getUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = POST, value = "addUser")
    public void addNewUser(@RequestParam String name, @RequestParam int age) {
        User u = new User();
        u.setName(name);
        u.setAge(age);
        userRepository.save(u);
    }
}
