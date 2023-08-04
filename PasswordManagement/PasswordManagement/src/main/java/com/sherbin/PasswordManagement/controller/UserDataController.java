package com.sherbin.PasswordManagement.controller;


import com.sherbin.PasswordManagement.entity.UserData;
import com.sherbin.PasswordManagement.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin(origins="http://localhost:4200/")
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
    @DeleteMapping("user/{userDataId}")
    public String deleteTask(@PathVariable int userDataId){

        userDataService.deleteTaskById(userDataId);

        return "Success";
    }




}
