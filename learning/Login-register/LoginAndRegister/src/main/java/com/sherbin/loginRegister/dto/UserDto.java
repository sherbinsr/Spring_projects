package com.sherbin.loginRegister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private Long userId;

    private  String userName;

    private  String emailId;

    private  String password;
}
