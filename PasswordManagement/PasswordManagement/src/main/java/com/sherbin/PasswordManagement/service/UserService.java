package com.sherbin.PasswordManagement.service;

import com.sherbin.PasswordManagement.entity.Users;
import com.sherbin.PasswordManagement.repository.UserDataRepository;
import com.sherbin.PasswordManagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UsersRepository usersRepository;



    @Autowired
    private PasswordEncoder passwordEncoder;

    public  Users  newUser(Users users)
    {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.save(users);
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


}
