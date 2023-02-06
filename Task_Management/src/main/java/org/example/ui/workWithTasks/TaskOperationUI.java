package org.example.ui.workWithTasks;

import org.example.model.task.Task;
import org.example.model.task.TaskType;
import org.example.service.task.TaskServiceImpl;
import org.example.util.ScannerUtil;

import java.util.UUID;

import static org.example.ui.workWithTasks.WorkWithTasksUI.chooseAssignee;
import static org.example.ui.workWithTasks.WorkWithTasksUI.userService;

public class TaskOperationUI implements ScannerUtil {
    static TaskServiceImpl taskService = new TaskServiceImpl();
    public static void taskOperation(Task task){
        String stepCode;
        while (true) {
            System.out.println("""
                    1. Delete task
                    2. Change task name
                    3. Change task description
                    4. Change task assignee and type
                    0. Back""");
            stepCode = scannerStr.nextLine();
            switch (stepCode) {
                case "1" -> System.out.println(taskService.deleteTask(task).getMessage());
                case "2" -> {
                    String name = scannerStr.nextLine();
                    System.out.println(taskService.changeTaskName(task, name).getMessage());
                }
                case "3" -> {
                    String description = scannerStr.nextLine();
                    System.out.println(taskService.changeTaskDescription(task, description).getMessage());
                }
                case "4" -> {
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
                    taskService.changeTaskAssigneeAndType(task, userService.getById(assigneeId), taskType);
                }
            }
        }
    }
}
