package com.sherbin.PasswordManagement.controller;

import com.sherbin.PasswordManagement.dto.LoginDto;
import com.sherbin.PasswordManagement.entity.UserData;
import com.sherbin.PasswordManagement.entity.Users;
import com.sherbin.PasswordManagement.event.LoginMessage;
import com.sherbin.PasswordManagement.repository.UserDataRepository;
import com.sherbin.PasswordManagement.service.UserDataService;
import com.sherbin.PasswordManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
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

    @GetMapping("/loginalluser")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @PutMapping("user/{userId}")
    public String dataToCurrentUser(@PathVariable int userId,@RequestBody UserData userData)
    {
        Users users=userService.userById(userId);
        users.addData(userData);
        userService.adduserDataToCurrentUser(users);
       return "data added successfully";
    }
    @GetMapping("/userid")
     public ResponseEntity<?> printUser()
    {
        LoginMessage loginMessage = userService.printUserId();
        return ResponseEntity.ok(loginMessage);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto)
    {
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }

}
