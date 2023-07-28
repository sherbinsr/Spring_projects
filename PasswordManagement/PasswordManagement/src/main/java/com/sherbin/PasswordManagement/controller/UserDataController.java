package com.sherbin.PasswordManagement.controller;


import com.sherbin.PasswordManagement.entity.UserData;
import com.sherbin.PasswordManagement.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/data")
    public UserData createData(@RequestBody UserData userData)
    {
        return  userDataService.createData(userData);
    }
   @GetMapping("/data/{id}")
    public  UserData dataById(@PathVariable int id)
   {
       return userDataService.dataById(id);
   }

   @GetMapping("/user/{id}")
   public List<UserData> getDataByUserId(@PathVariable int id)
   {
       return userDataService.findDataByUserId(id);
   }
    @DeleteMapping("delete/{id}")
    public String deleteTask(@PathVariable int id){

        userDataService.deleteTaskById(id);

        return "Success";
    }




}
