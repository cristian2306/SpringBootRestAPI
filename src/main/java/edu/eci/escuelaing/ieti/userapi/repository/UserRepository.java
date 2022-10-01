package edu.eci.escuelaing.ieti.userapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.escuelaing.ieti.userapi.entities.User;
  
  public interface UserRepository extends MongoRepository<User, String>{

    List<User> findByNameOrLastName(String name, String lastName);
    
    List<User> findByCreatedAtAfter(Date startDate);

    User findByEmail(String email);

  }
