package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.usermodel.UserModel;

import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    UserRepository userRepository;

    public UserModel getUserById(Integer userid){
        Optional<UserModel> user = userRepository.findById(userid);
        if (user.isPresent()){
            return user.get();
        }
        return new UserModel();
    }

    public void updateUser(UserModel userData,int userid){
        Optional<UserModel> existingUser = userRepository.findById(userid);
        if (existingUser.isPresent()){
            UserModel user = existingUser.get();
            user.setFullname(userData.getFullname());
            user.setPassword(userData.getPassword());
            userRepository.save(user);
        }
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }
}


