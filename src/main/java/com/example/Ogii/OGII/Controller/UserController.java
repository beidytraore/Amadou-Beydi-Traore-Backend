package com.example.Ogii.OGII.Controller;


import com.example.Ogii.OGII.model.User;
import com.example.Ogii.OGII.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "getallLogin", method = RequestMethod.GET)

    public List<User> getAllLogin() {
        return userService.getAllLogin();
    }
    @RequestMapping(value = "addLogin",method = RequestMethod.POST)

    public String addLogin(@RequestBody User user) {
        return userService.addLogin(user);
    }
}


