package com.propertymanagement.Converter;

import com.propertymanagement.DTO.UserDto;
import com.propertymanagement.Model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDtoToEntity(UserDto userDto)
    {
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerEmail(userDto.getOwnerEmail());
        userEntity.setOwnerName(userDto.getOwnerName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setPhone(userDto.getPhone());
        return userEntity;
    }

    public UserDto convertEntityToDto(UserEntity userEntity)
    {
        UserDto userDto=new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        userDto.setOwnerName(userEntity.getOwnerName());
        userDto.setPhone(userEntity.getPhone());

        return userDto;
    }
}
