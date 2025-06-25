package com.propertymanagement.Service.Impl;

import com.propertymanagement.Converter.UserConverter;
import com.propertymanagement.DTO.UserDto;
import com.propertymanagement.Model.UserEntity;
import com.propertymanagement.Repository.UserRepo;
import com.propertymanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {

       UserEntity userEntity=userConverter.convertDtoToEntity(userDto);
        userRepo.save(userEntity);
        userDto=userConverter.convertEntityToDto(userEntity);

        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        return null;
    }
}
