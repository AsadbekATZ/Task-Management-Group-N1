package org.example.service.user;

import org.example.DTO.AddDto;
import org.example.DTO.UserLoginDto;
import org.example.model.user.User;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

public class UserServiceImpl implements UserService, UserRepository {
    @Override
    public AddDto add(User user) {
        String message;
        ArrayList<User> userList = getUserList();
        if(isEmailExists(userList, user.getEmail())) {
            return new AddDto("Email Already Exists!");
        } else if (!passwordChecker(user.getPassword())) {
           return new AddDto("Invalid password!");
        } else if (!emailChecker(user.getEmail())) {
            return new AddDto("Invalid email address!");
        }

        userList.add(user);
        writeToFile(userList);
        return new AddDto("User successfully added!");
    }

    @Override
    public User getById(UUID id) {
        for (User user : getUserList()) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isEmailExists(ArrayList<User> userList, String email) {
        for (User user:userList) {
            if(user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserLoginDto login(String email, String password) {
        for (User user : getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return new UserLoginDto("Successfully signed in!\n*****Current User: "
                + user + "*****", user);
            }
        }
        return new UserLoginDto("User Not Found!", null);
    }

    @Override
    public boolean emailChecker(String email) {
        return UserService.super.emailChecker(email);
    }

    @Override
    public boolean passwordChecker(String password) {
        return UserService.super.passwordChecker(password);
    }
}
