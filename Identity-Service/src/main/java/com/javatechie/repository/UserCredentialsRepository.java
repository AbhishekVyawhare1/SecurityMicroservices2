package com.javatechie.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.entity.UserCredentials;

public interface UserCredentialsRepository extends MongoRepository<UserCredentials, String> {
    Optional<UserCredentials> findByName(String username);
}
