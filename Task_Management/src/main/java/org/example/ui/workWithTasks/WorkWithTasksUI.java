package org.example.ui.workWithTasks;

import org.example.model.task.Task;
import org.example.model.task.TaskStatus;
import org.example.model.task.TaskType;
import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.service.task.TaskServiceImpl;
import org.example.service.user.UserServiceImpl;
import org.example.util.ScannerUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.UUID;

public class WorkWithTasksUI implements ScannerUtil {
    static UserServiceImpl userService = new UserServiceImpl();
    static TaskServiceImpl taskService = new TaskServiceImpl();
    public static void workWithTasks(User currentUser){
        String stepCode;
        while (true) {
            System.out.println("""
                    1. Add new task
                    2. Task list
                    0. Back""");
            stepCode = scannerStr.nextLine();
            switch (stepCode) {
                case "1" -> addTask();
                case "2" -> TaskOperationUI.taskOperation(taskSelector(currentUser.getRole()));
            }
        }
    }
    public static void addTask(){
        System.out.print("Enter task name: ");
        String taskName = scannerStr.nextLine();
        System.out.print("Enter task description: ");
        String taskDescription = scannerStr.nextLine();
        TaskType taskType;
        UUID assigneeId;
        System.out.println("""
                    1. Test task
                    2. FE Task
                    3. BE Task
                    4. BA Task
                    5. SM Task
                    6. QA Task""");
        System.out.print("Enter task type: ");
        String choose = scannerStr.nextLine();
        switch (choose){
            case "1" -> taskType = TaskType.TESTER;

            case "2" -> taskType = TaskType.FE_LEAD;

            case "3" -> taskType = TaskType.BE_LEAD;

            case "4" -> taskType = TaskType.BUSINESS_ANALYST;

            case "5" -> taskType = TaskType.SCRUM_MASTER;

            case "6" -> taskType = TaskType.QUALITY_ASSURANCE_EN;

            default -> {
                return;
            }
        }
        assigneeId = chooseAssignee(taskType);
        Task task = new Task(taskName, taskDescription, assigneeId, taskType, TaskStatus.ASSIGNED);
        System.out.println(taskService.add(task).getMessage());
    }
    public static UUID chooseAssignee(TaskType taskType){
        int cnt = 0;
        ArrayList<User> temp = new ArrayList<>();
        for (User user : userService.getUserList()) {
            if (taskType.name().equals(user.getRole().name())){
                int counter = countOfTasks(user.getId());
                System.out.println("************************");
                System.out.printf("%s. %s %s\n", cnt++, user.getName(), counter>0 ? "("+counter+")" : "");
                temp.add(user);
                System.out.println("************************");
            }
        }
        int choose = 0;
        try {
            choose = scannerInt.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Wrong input please try again!");
            scannerInt.nextLine();
        }
        if (choose < 1 && choose >= temp.size()){
            chooseAssignee(taskType);
        }
        return temp.get(choose-1).getId();
    }
    private static int countOfTasks(UUID id) {

        ArrayList<Task> tasks = taskService.getTaskList();
        int counter = 0;

        for (Task task : tasks) {
            if (task.getAssigneeId().equals(id)){
                counter++;
            }
        }
        return counter;
    }
    public static Task taskSelector(UserRole role){
        if (role.equals(UserRole.MANAGER)){
            int cnt = 0;
            for (Task task : taskService.getTaskList()) {
                System.out.println("********" + ++cnt + "*********");
                System.out.println(task);
                System.out.println("*************************");
                int choose = 0;
                try {
                    choose = scannerInt.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Wrong input please try again!");
                    scannerInt.nextLine();
                }
                if (choose < 1 && choose >= taskService.getTaskList().size()){
                    taskSelector(role);
                }
                return taskService.getTaskList().get(choose-1);
            }
        }else {
            int cnt = 0;
            for (Task task : taskService.getTaskList()) {
                if(task.getType().name().equals(role.name())){
                    System.out.println("********" + ++cnt + "*********");
                    System.out.println(task);
                    System.out.println("*************************");
                    int choose = 0;
                    try {
                        choose = scannerInt.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input please try again!");
                        scannerInt.nextLine();
                    }
                    if (choose < 1 && choose >= taskService.getTaskList().size()){
                        taskSelector(role);
                    }
                    return taskService.getTaskList().get(choose-1);
                }
            }
        }
        return null;
    }
}
