package com.sherbin.loginRegister.service;

import com.sherbin.loginRegister.dto.LoginDto;
import com.sherbin.loginRegister.dto.UserDto;
import com.sherbin.loginRegister.event.LoginMessage;

public interface UserService {
    String addUser(UserDto userDto);
    LoginMessage loginUser(LoginDto loginDto);
}
