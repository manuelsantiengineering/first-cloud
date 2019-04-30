package com.msanti.authservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msanti.authservice.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
  Optional<User> findByUsername(String username);  
}
