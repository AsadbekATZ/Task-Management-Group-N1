package org.example.ui.userUI;

import org.example.model.task.Task;
import org.example.model.user.User;
import org.example.repository.TaskRepository;
import org.example.service.user.ManagerService;
import org.example.ui.workWithTasks.WorkWithTasksUI;
import org.example.ui.workWithUsers.WorkWithUsersUI;
import org.example.util.ScannerUtil;

public class ManagerUI implements ScannerUtil{
    static ManagerService managerService = new ManagerService();
    public static void managerWindow(User currentUser) {
        String stepCode;
        while (true){
            System.out.println("""
                    1. Work with task list
                    2. Work with user list
                    0. Back""");
            stepCode = scannerStr.nextLine();
            switch (stepCode){
                case "1" -> WorkWithTasksUI.workWithTasks(currentUser);
                case "2" -> WorkWithUsersUI.workWithUsers();
                case "0" -> {
                    return;
                }
            }
        }
    }
}
