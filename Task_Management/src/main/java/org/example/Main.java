package org.example;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;
import org.example.ui.MainUI;

import java.util.UUID;

public class Main {
    static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        MainUI.runMain();
    }
}