package com.sherbin.springsecurity.service;

import com.sherbin.springsecurity.entity.User;
import com.sherbin.springsecurity.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   User registerUser(UserModel userModel);

   void saveVerificationTokenForUser(String token, User user);

   String ValidateVerificationToken(String token);
}
