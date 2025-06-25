package com.propertymanagement.Repository;

import com.propertymanagement.Model.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<PropertyEntity, Long> {



}
