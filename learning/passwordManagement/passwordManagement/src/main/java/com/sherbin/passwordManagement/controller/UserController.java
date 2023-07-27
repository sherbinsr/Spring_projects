package com.sherbin.passwordManagement.controller;

import com.sherbin.passwordManagement.dto.LoginDto;
import com.sherbin.passwordManagement.dto.UserDto;
import com.sherbin.passwordManagement.event.LoginMessage;
import com.sherbin.passwordManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody LoginDto loginDto)
    {
        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);
    }
}
