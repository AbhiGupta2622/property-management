package com.propertymanagement.Service;

import com.propertymanagement.Model.PropertyDto;
import com.propertymanagement.Model.PropertyEntity;

import java.util.List;

public interface PropertyService {

    public List<PropertyDto> getALl();
    public PropertyDto getById(long id);
    public PropertyDto saveId(PropertyDto dto);
    public PropertyDto editId(PropertyDto dto, long id);

    public void delId(long id);

}
