package com.msanti.authservice.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.msanti.authservice.enums.Authorities;

@Document
public class User implements UserDetails {

  private static final long serialVersionUID = 6086666119671673029L;

  @Id
  private String id;

  @Indexed(unique = true)
  private String username;

  private String password;

  private boolean activated;

  private String activationKey;

  private String resetPasswordKey;

  private Set<Authorities> authorities = new HashSet<>();

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  @Override
  public String getPassword() {
      return password;
  }

  @Override
  public String getUsername() {
      return username;
  }

  @Override
  public List<GrantedAuthority> getAuthorities() {
      return new ArrayList<>(authorities);
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  @Override
  public boolean isAccountNonExpired() {
      return true;
  }

  @Override
  public boolean isAccountNonLocked() {
      return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
      return true;
  }

  @Override
  public boolean isEnabled() {
      return activated;
  }

  public boolean isActivated() {
      return activated;
  }

  public void setActivated(boolean activated) {
      this.activated = activated;
  }

  public String getActivationKey() {
      return activationKey;
  }

  public void setActivationKey(String activationKey) {
      this.activationKey = activationKey;
  }

  public String getResetPasswordKey() {
      return resetPasswordKey;
  }

  public void setResetPasswordKey(String resetPasswordKey) {
      this.resetPasswordKey = resetPasswordKey;
  }

  public void setAuthorities(Set<Authorities> authorities) {
      this.authorities = authorities;
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) 
      { 
        return false;  
      }
      User user = (User) obj;
      return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
      return Objects.hash(id);
  }

}
