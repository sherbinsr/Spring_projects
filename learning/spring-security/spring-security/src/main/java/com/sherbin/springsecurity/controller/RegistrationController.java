package com.sherbin.springsecurity.controller;

import com.sherbin.springsecurity.entity.User;
import com.sherbin.springsecurity.event.RegistrationCompleteEvent;
import com.sherbin.springsecurity.model.UserModel;
import com.sherbin.springsecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request)
    {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Success";
    }
    @GetMapping("/verifyregistration")
   public  String verifyRegistration(@RequestParam("token") String token)
   {
       String result = userService.ValidateVerificationToken(token);

       if(result.equalsIgnoreCase("valid"))
       {
           return "user verified Successfull";
       }
       return "Bad User";
   }
    private String applicationUrl(HttpServletRequest request) {

        return  "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
