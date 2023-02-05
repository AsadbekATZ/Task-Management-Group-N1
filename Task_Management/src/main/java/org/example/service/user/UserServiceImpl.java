package org.example.service.user;

import org.example.model.user.User;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.UUID;

public class UserServiceImpl implements UserService, UserRepository {
    @Override
    public int add(User user) {
        ArrayList<User> userList = getUserList();
        if(isEmailExists(userList, user.getEmail())) {
            return -1;
        }

        userList.add(user);
        writeToFile(userList);
        return 1;
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
}
