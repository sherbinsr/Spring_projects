package com.sherbin.PasswordManagement.service;

import com.sherbin.PasswordManagement.entity.UserData;
import com.sherbin.PasswordManagement.entity.Users;
import com.sherbin.PasswordManagement.repository.UserDataRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public UserData createData(UserData userData)
    {
        return userDataRepository.save(userData);
    }
    public  UserData dataById(int id)
    {
        return userDataRepository.findById(id)

                .orElseThrow(()->new EntityNotFoundException("Data Not Found with id:"+id));
    }
    public List<UserData>findDataByUserId(int id)
    {
        return userDataRepository.findUserDataByUserId(id);
    }

    public void deleteTaskById(int id){
        userDataRepository.deleteById(id);
    }
}
