package org.example;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import java.util.UUID;

public class Main {
    static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
       User user = new User()
               .setEmail("test@gmail.com")
               .setName("Harry")
               .setLastname("Potter")
               .setRole(UserRole.USER)
               .setPassword("password");

//       userService.add(user);
        System.out.println(userService.getById(UUID.fromString("82356b21-781c-4733-8adf-c61a0ffd5cc8")));
    }
}