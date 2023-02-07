package org.example.ui;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.UserServiceImpl;
import org.example.util.ScannerUtil;

public class RegisterUI implements ScannerUtil {
    static UserServiceImpl userService = new UserServiceImpl();
    public static void register(){
        System.out.print("Enter your name: ");
        String name = scannerStr.nextLine();
        System.out.print("Enter your last name: ");
        String lastname = scannerStr.nextLine();
        System.out.print("Enter your email: ");
        String email = scannerStr.nextLine();
        System.out.print("Enter your password: ");
        String password = scannerStr.nextLine();
        User user = new User(name, lastname, email, password, UserRole.USER);
        System.out.println(userService.add(user).getMessage());
    }
}
