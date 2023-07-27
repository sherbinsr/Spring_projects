package com.sherbin.loginRegister.service;

import com.sherbin.loginRegister.dto.LoginDto;
import com.sherbin.loginRegister.dto.UserDto;
import com.sherbin.loginRegister.entity.Users;
import com.sherbin.loginRegister.event.LoginMessage;
import com.sherbin.loginRegister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        Users users = new Users(

                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmailId(),
                this.passwordEncoder.encode(userDto.getPassword())
        );

        userRepository.save(users);

        return users.getUserName();

    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {
        String msg ="";
        Users users = userRepository.findByEmailId(loginDto.getEmailId());
        if(users!=null)
        {
            String password =loginDto.getPassword();
            String encodedPassword =users.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password,encodedPassword);
            if(isPasswordRight)
            {
                Optional<Users> users1 = userRepository.findOneByEmailIdAndPassword(loginDto.getEmailId(),encodedPassword);
                        if(users1.isPresent())
                        {
                            return new LoginMessage("Login Success",true);
                        }
                        else
                        {
                            return  new LoginMessage("Login Failed",false);
                        }
            }
            else
            {
                return  new LoginMessage("PassWord Not Match",false);
            }

        }
        else
        {
            return  new LoginMessage("Email Not exists",false);
        }
    }
}
