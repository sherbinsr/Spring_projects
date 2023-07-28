package com.sherbin.PasswordManagement.controller;

import com.sherbin.PasswordManagement.entity.UserData;
import com.sherbin.PasswordManagement.entity.Users;
import com.sherbin.PasswordManagement.repository.UserDataRepository;
import com.sherbin.PasswordManagement.service.UserDataService;
import com.sherbin.PasswordManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDataService userDataService;


    @PostMapping("/user")
    public Users addUser(@RequestBody Users users)
    {
        return userService.newUser(users);
    }

//    @GetMapping("/user/{id}")
//    public  Users UserById(@PathVariable int id)
//    {
//        return userService.userById(id);
//    }
    @PutMapping("/{userId}/data")
    public String dataToCurrentUser(@PathVariable int userId,@RequestBody UserData userData)
    {
        Users users=userService.userById(userId);
        users.addData(userData);
        userService.adduserDataToCurrentUser(users);
       return "data added successfully";
    }



}
