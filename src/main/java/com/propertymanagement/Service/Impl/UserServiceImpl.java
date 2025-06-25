package com.propertymanagement.Service.Impl;

import com.propertymanagement.Converter.UserConverter;
import com.propertymanagement.DTO.UserDto;
import com.propertymanagement.Exception.BusinessException;
import com.propertymanagement.Exception.ErrorModel;
import com.propertymanagement.Model.UserEntity;
import com.propertymanagement.Repository.UserRepo;
import com.propertymanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {

        List<UserEntity>list=userRepo.findByOwnerEmail(userDto.getOwnerEmail());
        if(!list.isEmpty())
        {
            List<ErrorModel> models=new ArrayList<>();
            ErrorModel error=new ErrorModel();
            error.setCode("Duplicate_Email");
            error.setMessage("Email already exists");
            models.add(error);

            throw new BusinessException(models);
        }
       UserEntity userEntity=userConverter.convertDtoToEntity(userDto);
        userRepo.save(userEntity);
        userDto=userConverter.convertEntityToDto(userEntity);

        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {

        List<UserEntity> users=userRepo.findByOwnerEmailAndPassword(email, password);
        if(users.isEmpty())
        {
            List<ErrorModel> list=new ArrayList<>();
            ErrorModel error=new ErrorModel();
            error.setCode("INVALID_CREDENTAILS");
            error.setMessage("Email or password is incorrect");

            list.add(error);

            throw new BusinessException(list);
        }
        UserDto userDto = userConverter.convertEntityToDto(users.get(0));
        return userDto;
    }
}
