package org.example.DTO;

import org.example.model.user.User;

public class UserLoginDto extends BaseDto{
    public User currentUser;

    public UserLoginDto(String message, User currentUser) {
        super(message);
        this.currentUser = currentUser;
    }
}
