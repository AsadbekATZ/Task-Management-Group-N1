package org.example.ui;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;
import org.example.util.ScannerUtil;

public class MainUI implements ScannerUtil {
    public static void runMain(){
        String stepCode;
        while(true){
            System.out.println("1. Register, 2. Login, 0. Exit");
            stepCode = scannerStr.nextLine();
            switch (stepCode){
                case "1" -> RegisterUI.register();
                case "2" -> LoginUI.login();
                case "0" -> {
                     return;
                }
            }
        }
    }
}
