package com.sherbin.PasswordManagement.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginMessage {

    String message;
    int userid;
    Boolean Status;
}
