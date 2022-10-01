package edu.eci.escuelaing.ieti.userapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.escuelaing.ieti.userapi.entities.User;

public class UserServiceHashMap implements UserService {

    private HashMap<String,User> users;

    public UserServiceHashMap(){
        users = new HashMap<String,User>();
    }

    @Override
    public User create(User user) {
        if(users.containsKey(user.getId())){
            return users.get(user.getId());
        }else{
            users.put(user.getId(),user);
            return users.get(user.getId());
        }
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> usersFind = new ArrayList<>();
        usersFind.addAll(users.values());
        return usersFind;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
        
    }

    @Override
    public User update(User user, String userId) {
        User old = users.get(userId);
        if(users.replace(userId, old, user)){
            return user;
        }else{
            return old;
        }
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String name, String LastName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByEmail(String mail) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
