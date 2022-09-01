package edu.eci.escuelaing.ieti.userapi.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.escuelaing.ieti.userapi.dto.UserDto;
import edu.eci.escuelaing.ieti.userapi.entities.User;
import edu.eci.escuelaing.ieti.userapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        for(User user: users){
            usersDto.add(modelMapper.map(user, UserDto.class));
        }
        return new ResponseEntity<List<UserDto>>(usersDto, HttpStatus.ACCEPTED);
    }
   
    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
       User user = userService.findById(id);
       UserDto userDto = modelMapper.map(user,UserDto.class);
       return new ResponseEntity<>(userDto,HttpStatus.ACCEPTED);
    }
   
   
    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        userService.create(modelMapper.map(userDto, User.class));
        UserDto userDto2 = modelMapper.map(userService.findById(userDto.getId()),UserDto.class);
        return new ResponseEntity<>(userDto2,HttpStatus.ACCEPTED);
    }
   
    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        User newUser = userService.update(modelMapper.map(user,User.class),id);
        return new ResponseEntity<>(modelMapper.map(newUser,UserDto.class),HttpStatus.ACCEPTED);
    }
   
    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        userService.deleteById(id);
        if(userService.findById(id) == null){
            return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_MODIFIED);
        }
    
    }
}
    
