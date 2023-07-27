package com.sherbin.passwordManagement.service;

import com.sherbin.passwordManagement.dto.LoginDto;
import com.sherbin.passwordManagement.dto.UserDto;
import com.sherbin.passwordManagement.event.LoginMessage;

public interface UserService {
    String addUser(UserDto userDto);
    LoginMessage loginUser(LoginDto loginDto);
}
