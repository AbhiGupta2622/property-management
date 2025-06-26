package com.propertymanagement.Controller;

import com.propertymanagement.DTO.PropertyDto;
import com.propertymanagement.DTO.UserDto;
import com.propertymanagement.Exception.BusinessException;
import com.propertymanagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> saveId(@Valid  @RequestBody UserDto dto) throws BusinessException {
        UserDto dto1 = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto1);
    }



    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserDto dto) throws BusinessException {
        // This will throw BusinessException if user not found
        UserDto dto1 = userService.login(dto.getOwnerEmail(), dto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(dto1);
    }

}
//implement get api to fetch user details by passing user id
//how to invoke the rest api from java code
//what is the purpose of this project