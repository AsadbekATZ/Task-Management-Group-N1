package org.example.DTO;

import org.example.model.task.Task;
import org.example.model.task.TaskStatus;
import org.example.repository.TaskRepository;
import org.example.service.user.UserServiceImpl;

public class ViewOngoingTasksDto implements TaskRepository {
    UserServiceImpl userService = new UserServiceImpl();
    int cnt = 0;
    public void viewOngoingTask(){
        System.out.println("****Ongoing tasks****");
        for (Task task : getTaskList()) {
            if (task.getStatus().equals(TaskStatus.IN_PROGRESS)){
                System.out.println("########" + ++cnt + "########");
                System.out.println("Task name: " + task.getName());
                System.out.println("Task description: " + task.getDescription());
                System.out.println("Task assignee: " + userService.getById(task.getAssigneeId()).getName());
                System.out.println("####################");
            }
        }
    }
}
