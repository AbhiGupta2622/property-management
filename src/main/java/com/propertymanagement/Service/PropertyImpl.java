package com.propertymanagement.Service;

import com.propertymanagement.Converter.PropertyConverter;
import com.propertymanagement.Model.PropertyDto;
import com.propertymanagement.Model.PropertyEntity;
import com.propertymanagement.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyImpl implements PropertyService{

    @Autowired
    public PropertyRepo propertyRepo;

    @Autowired
    public PropertyConverter propertyConverter;

    @Override
    public List<PropertyDto> getALl() {
        List<PropertyEntity>list= propertyRepo.findAll();

        List<PropertyDto>dtoList=new ArrayList<>();

        for (PropertyEntity entity : list) {
            PropertyDto dto = propertyConverter.convertEntityToDto(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public PropertyDto getById(long id) {
        PropertyEntity entity= propertyRepo.findById(id).orElse(null);
        PropertyDto dto=propertyConverter.convertEntityToDto(entity);
        return dto;
    }

    @Override
    public PropertyDto saveId(PropertyDto dto) {

   //     DTO->ENTITY to save the entity to DB beacuse dto cnnot be saved to db only entity will be saved

      PropertyEntity entity=  propertyConverter.convertDtoToEntity(dto);
      propertyRepo.save(entity);

        //ENTITY->DTO this is becuase we want ot show dto to outside world not the main entity class that is why we are returning dto1

       PropertyDto dto1 =  propertyConverter.convertEntityToDto(entity);
        return dto1;
    }

    @Override
    public PropertyDto editId(PropertyDto dto, long id) {
        PropertyEntity entity1=propertyConverter.convertDtoToEntity(dto);
        entity1.setId(id);
        PropertyEntity entity2= propertyRepo.save(entity1);
       return propertyConverter.convertEntityToDto(entity2);

    }

    @Override
    public void delId(long id) {
      propertyRepo.deleteById(id);
    }
}
