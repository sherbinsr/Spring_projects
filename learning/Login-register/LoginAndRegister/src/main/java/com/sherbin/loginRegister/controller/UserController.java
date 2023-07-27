package com.sherbin.loginRegister.controller;

import com.sherbin.loginRegister.dto.LoginDto;
import com.sherbin.loginRegister.dto.UserDto;
import com.sherbin.loginRegister.event.LoginMessage;
import com.sherbin.loginRegister.service.UserService;
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
