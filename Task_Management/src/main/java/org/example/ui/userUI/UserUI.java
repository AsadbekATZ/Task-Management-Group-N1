package org.example.ui.userUI;

import org.example.model.user.User;
import org.example.ui.workWithTasks.WorkWithTasksUI;
import org.example.ui.workWithUsers.WorkWithUsersUI;
import org.example.util.ScannerUtil;

public class UserUI implements ScannerUtil {

    public static void userWindow(User currentUser) {
        String stepCode;
        while (true){
            System.out.println("""
                    1. See my tasks
                    2. My Info
                    0. Back""");
            stepCode = scannerStr.nextLine();
            switch (stepCode){
                case "1" -> WorkWithTasksUI.workWithTasks(currentUser);
                case "2" -> System.out.println("******** Your account information ********\n" + currentUser);
                case "0" -> {
                    return;
                }
            }
        }
    }
}

