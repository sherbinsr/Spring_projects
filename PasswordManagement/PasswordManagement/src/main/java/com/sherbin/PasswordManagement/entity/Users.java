package com.sherbin.PasswordManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;

    private  String userName;

    private  String emailId;

    private String password;


    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL,fetch =FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<UserData> userDataList;

    public Users(String userName, String emailId, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
    }

    public  void  addData(UserData userData)
    {
        if(userDataList==null)
            userDataList = new ArrayList<>();
        userData.setUsers(this);
        userDataList.add(userData);

    }
}
