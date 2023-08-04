package com.sherbin.PasswordManagement.service;

import com.sherbin.PasswordManagement.dto.LoginDto;
import com.sherbin.PasswordManagement.entity.Users;
import com.sherbin.PasswordManagement.event.LoginMessage;
import com.sherbin.PasswordManagement.repository.UserDataRepository;
import com.sherbin.PasswordManagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UsersRepository usersRepository;



    @Autowired
    private PasswordEncoder passwordEncoder;

    int  userIdForAddingData;

    public  Users  newUser(Users users)
    {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);
    }
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public Users userById(int id)
    {
        Optional<Users>fetch = usersRepository.findById(id);
        Users user =null;
        if(fetch.isPresent()){
            user=fetch.get();
        }
        return user;
    }

    public  void adduserDataToCurrentUser(Users users)
    {
         usersRepository.save(users);

    }

    public LoginMessage loginUser(LoginDto loginDto)
    {
        String msg ="";
        Users users = usersRepository.findByEmailId(loginDto.getEmailId());
        Users userid =usersRepository.findIdByEmailId(loginDto.getEmailId());
        userIdForAddingData = userid.getUserId();
        if(users!=null)
        {
            String password=loginDto.getPassword();
            String encodedPassword =users.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password,encodedPassword);
            if(isPasswordRight)
            {
                Optional<Users> users1 = usersRepository.findOneByEmailIdAndPassword(loginDto.getEmailId(),encodedPassword);
                if(users1.isPresent())
                {
                    return new LoginMessage("Login Success", userid.getUserId(),true);

                }
                else
                {
                    return  new LoginMessage("Login Failed",0,false);
                }
            }
            else
            {
                return  new LoginMessage("PassWord Not Match",0,false);
            }

        }
        else
        {
            return  new LoginMessage("Email Not exists",0,false);
        }
    }
    public LoginMessage printUserId()
    {
        return new LoginMessage("OK",userIdForAddingData,true);
    }
}