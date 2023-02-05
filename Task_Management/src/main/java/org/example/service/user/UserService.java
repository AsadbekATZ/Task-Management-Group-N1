package org.example.service.user;

import org.example.model.user.User;
import org.example.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User> {
    boolean isEmailExists(ArrayList<User> userList, String email);
}
