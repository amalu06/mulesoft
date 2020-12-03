package com.example.demo.controller;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.Userservice;
import com.example.demo.usermodel.UserModel;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Userservice userservice;



    @RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("userid") Integer userid, @RequestBody UserModel user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       userservice.updateUser(user, userid);
        return new ResponseEntity<String>(
                "User Updated Successfully", headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/allusers")
    public ResponseEntity<List<UserModel>> getAllUser1() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List<UserModel> user1 = userRepository.findAll();
        //return user1;
        return new ResponseEntity<List<UserModel>>(
                user1, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserModel user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        userservice.addUser(user);
        return new ResponseEntity<String>(
                "User Created", headers, HttpStatus.OK);
    }
}



