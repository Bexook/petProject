package com.example.petProject.service.model;

import com.example.petProject.model.entity.UserEntity;
import lombok.NonNull;

import java.util.List;


public interface UserService {


    UserEntity getUserById(@NonNull Long id);

    boolean registerUser(@NonNull UserEntity userEntity);

    void deleteById(Long id);

    UserEntity findByEmail(String email);

    List<UserEntity> findAll(boolean isActive);
}
