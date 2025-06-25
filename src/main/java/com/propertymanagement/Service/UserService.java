package com.propertymanagement.Service;

import com.propertymanagement.DTO.UserDto;

public interface UserService {

    UserDto register(UserDto userDto);
    UserDto login(String email, String password);

}
