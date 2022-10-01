package edu.eci.escuelaing.ieti.userapi.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import edu.eci.escuelaing.ieti.userapi.dto.UserDto;
import edu.eci.escuelaing.ieti.userapi.entities.enums.RoleEnum;

@Document
public class User {

    @Id
    private String id;
    private String name;
    @Indexed( unique = true)
    private String email;
    private String lastName;
    private Date createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.createdAt = userDto.getCreatedAt();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        roles = new ArrayList<>();
        roles.add(RoleEnum.USER);
    }

    public void toEntity(UserDto user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        System.out.println("PASSWORD-------------------\n"+user.getPassword());
        if (user.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        }
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [createdAt=" + createdAt + ", email=" + email + ", id=" + id + ", lastName=" + lastName + ", name="
                + name + ", passwordHash=" + passwordHash + ", roles=" + roles + "]";
    }

    

    

}
