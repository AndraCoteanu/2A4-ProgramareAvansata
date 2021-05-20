package com.example.lab11.controllers;

import com.example.lab11.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.lab11.services.UserService;

import java.util.List;

/**
 * <h3> Clasa UserController </h3>
 * <p> Clasa se foloseste de metodele din UserService pentru a defini metode pentru requesturi HTTP. </p>
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public User putUserName(@PathVariable short id, @RequestParam String name) {
        return userService.changeName(id, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable short id) {
        userService.deleteUser(id);
    }
}
