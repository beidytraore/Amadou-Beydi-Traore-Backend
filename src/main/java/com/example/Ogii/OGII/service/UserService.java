package com.example.Ogii.OGII.service;

import com.example.Ogii.OGII.Repository.UserRepository;
import com.example.Ogii.OGII.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllLogin() {
        try {
            List<User> users = userRepository.findAll();
            List<User> customUsers = new ArrayList<>();
            users.stream().forEach(e -> {
                User user = new User();
                BeanUtils.copyProperties(e, user);
                customUsers.add(user);
            });
            return customUsers;
        } catch (Exception e) {
            throw e;
        }
    }
    public String addLogin(User user) {
        try {
            if(!userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
                userRepository.save(user);
                return "User added Succesfully";
            }else {
                return "This user is already exists in the database";
            }
        }catch (Exception e) {
            throw e;
        }
    }


}