package com.propertymanagement.Controller;

import com.propertymanagement.DTO.PropertyDto;
import com.propertymanagement.DTO.UserDto;
import com.propertymanagement.Service.UserService;
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
    public ResponseEntity<UserDto> saveId(@RequestBody UserDto dto)
    {
        try {
            UserDto dto1 = userService.register(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto1);
        }

        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
