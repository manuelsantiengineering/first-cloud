package com.msanti.authservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msanti.authservice.domain.AuthClientDetails;

public interface AuthClientRepository extends MongoRepository<AuthClientDetails, String> {

  Optional<AuthClientDetails> findByClientId(String clientId);
}
