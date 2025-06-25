package com.propertymanagement.Converter;

import com.propertymanagement.Model.PropertyDto;
import com.propertymanagement.Model.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDtoToEntity(PropertyDto dto)
    {
        PropertyEntity entity=new PropertyEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setOwnerName(dto.getOwnerName());
        entity.setOwnerEmail(dto.getOwnerEmail());
        entity.setPrice(dto.getPrice());
        entity.setAddress(dto.getAddress());

        return  entity;
    }

    public PropertyDto convertEntityToDto(PropertyEntity entity) {
        PropertyDto dto1 = new PropertyDto();
        dto1.setId(entity.getId());
        dto1.setTitle(entity.getTitle());
        dto1.setDescription(entity.getDescription());
        dto1.setOwnerName(entity.getOwnerName());
        dto1.setOwnerEmail(entity.getOwnerEmail());
        dto1.setPrice(entity.getPrice());
        dto1.setAddress(entity.getAddress());

        return dto1;
    }
}
