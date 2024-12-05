package com.upiiz.securitydb.repository;

import com.upiiz.securitydb.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //Entiende - QueryMethod
    Optional<UserEntity>findUserEntityByUsername(String username);
}
