package com.msanti.authservice.config.mongodb.changelogs;


import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.msanti.authservice.domain.AuthClientDetails;
import com.msanti.authservice.domain.User;
import com.msanti.authservice.enums.Authorities;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashSet;
import java.util.Set;

@ChangeLog
public class InitialValuesChangeLog {

  @ChangeSet(order = "001", id = "insertBrowserClientDetails", author = "Tomatito Ragu")
  public void insertBrowserClientDetails(MongoTemplate mongoTemplate) {
    // We are creating a new AuthClientDetails on our MongoDB with a secret, 
    // scope and grant types to be able to get an access token based on user credentials.
    // That client secret is a hash generated from BCryptPasswordEncoder for the value 1234
    AuthClientDetails browserClientDetails = new AuthClientDetails();
    browserClientDetails.setClientId("browser");
    browserClientDetails.setClientSecret("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
    browserClientDetails.setScopes("ui");
    browserClientDetails.setGrantTypes("refresh_token,password");
    
    mongoTemplate.save(browserClientDetails);
  }

  @ChangeSet(order = "002", id = "insertUserToTestAuthentication", author = "Cebollin Salteado")
  public void insertUserToTestAuthentication(MongoTemplate mongoTemplate) {
    Set<Authorities> authorities = new HashSet<>();
    authorities.add(Authorities.ROLE_USER);
    
    User user = new User();
    user.setActivated(true);
    user.setAuthorities(authorities);
    user.setPassword("$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK");
    user.setUsername("randomuser");
    
    mongoTemplate.save(user);
  }

}