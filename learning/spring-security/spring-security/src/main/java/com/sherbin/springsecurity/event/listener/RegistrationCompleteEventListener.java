package com.sherbin.springsecurity.event.listener;

import com.sherbin.springsecurity.entity.User;
import com.sherbin.springsecurity.event.RegistrationCompleteEvent;
import com.sherbin.springsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.UUID;
@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification token for the user with link
        //send the mail to user
        User user =event.getUser();
        String  token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        String url =event.getApplicationUrl()+"/VerifyRegistration?token="+token;
        //sending  verification link
        log.info("click the link to verify you accout:"+url);
    }
}
