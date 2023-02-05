package org.example.service.user;

import org.example.DTO.UserLoginDto;
import org.example.model.user.User;
import org.example.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User> {
    boolean isEmailExists(ArrayList<User> userList, String email);
    UserLoginDto login(String email, String password);
    default boolean emailChecker(String email){
        String pattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        return email.matches(pattern);
    }
    default boolean passwordChecker(String password){
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }
}
