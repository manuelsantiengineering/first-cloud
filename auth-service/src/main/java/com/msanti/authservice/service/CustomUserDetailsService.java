package com.msanti.authservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.msanti.authservice.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
  
  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
      this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return userRepository
              .findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
  }
}
