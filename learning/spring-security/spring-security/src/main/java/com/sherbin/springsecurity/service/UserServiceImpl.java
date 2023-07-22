package com.sherbin.springsecurity.service;

import com.sherbin.springsecurity.entity.User;
import com.sherbin.springsecurity.entity.VerificationToken;
import com.sherbin.springsecurity.model.UserModel;
import com.sherbin.springsecurity.repository.UserRepository;
import com.sherbin.springsecurity.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements  UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {

        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {

        VerificationToken verificationToken = new VerificationToken(user,token);

        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String ValidateVerificationToken(String token) {
        VerificationToken verificationToken= verificationTokenRepository.findByToken(token);

        if(verificationToken==null)
        {
            return "Invalid Token";
        }

        User user =verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if(verificationToken.getExpirationTime().getTime()-cal.getTime().getTime()<=0)
        {
            verificationTokenRepository.delete(verificationToken);
            return  "expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";

    }
}
