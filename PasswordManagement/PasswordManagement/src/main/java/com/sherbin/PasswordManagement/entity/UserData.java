package com.sherbin.PasswordManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userDataId;

    private  String sourceName;

    private  String userNames;

    private  String passwords;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private Users users;

    public UserData(String userNames, String passwords, String sourceName) {
        this.userNames = userNames;
        this.passwords = passwords;
        this.sourceName  =sourceName;
    }
}
