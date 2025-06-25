package com.propertymanagement.Repository;

import com.propertymanagement.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByOwnerEmailAndPassword(String email, String password);
    List<UserEntity> findByOwnerEmail(String email);
}
