package edu.eci.escuelaing.ieti.userapi.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.SetOperators.SetUnion;
import org.springframework.stereotype.Service;

import edu.eci.escuelaing.ieti.userapi.entities.User;
import edu.eci.escuelaing.ieti.userapi.repository.UserRepository;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
        
    }

    @Override
    public User update(User user, String userId) {
        userRepository.save(user);
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String name, String LastName) {
        return userRepository.findByNameOrLastName(name,LastName);
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return userRepository.findByCreatedAtAfter(startDate);
    }

    @Override
    public User findByEmail(String mail) {
        return userRepository.findByEmail(mail);
    }

}
