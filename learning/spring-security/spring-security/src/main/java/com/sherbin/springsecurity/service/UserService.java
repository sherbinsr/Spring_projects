package com.sherbin.springsecurity.service;

import com.sherbin.springsecurity.entity.User;
import com.sherbin.springsecurity.entity.VerificationToken;
import com.sherbin.springsecurity.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
   User registerUser(UserModel userModel);

   void saveVerificationTokenForUser(String token, User user);

   String ValidateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
