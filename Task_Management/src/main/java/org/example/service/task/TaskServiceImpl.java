package org.example.service.task;

import org.example.DTO.AddDto;
import org.example.DTO.AssignTaskDto;
import org.example.DTO.EditTaskDto;
import org.example.model.task.Task;
import org.example.model.task.TaskStatus;
import org.example.model.task.TaskType;
import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class TaskServiceImpl implements TaskService, TaskRepository {
    @Override
    public AddDto add(Task task) {
        ArrayList<Task> taskList = getTaskList();
        if (isTaskNameBlank(task)){
            return new AddDto("Task name cannot be blank!");
        }else if (isTaskDescriptionBlank(task)){
            return new AddDto("Task description cannot be blank!");
        }
        task.setStatus(TaskStatus.CREATED);
        taskList.add(task);
        writeToTaskList(taskList);
        return new AddDto("Task status: " + task.getStatus());
    }

    @Override
    public Task getById(UUID id) {
        for (Task task : getTaskList()) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean isTaskNameBlank(Task task) {
        return task.getName().isBlank();
    }

    @Override
    public boolean isTaskDescriptionBlank(Task task) {
        return task.getDescription().isBlank();
    }

    @Override
    public AssignTaskDto assignTask(Task task, User user) {
        if (!task.getStatus().equals(TaskStatus.CREATED) && !task.getStatus().equals(TaskStatus.DONE)){
            return new AssignTaskDto("This task is already assigned!");
        }
        if (task.getType().equals(TaskType.BA_TASK)) {
            if(user.getRole().equals(UserRole.BUSINESS_ANALYST)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        if (task.getType().equals(TaskType.SM_TASK)) {
            if(user.getRole().equals(UserRole.SCRUM_MASTER)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        if (task.getType().equals(TaskType.QA_TASK)) {
            if(user.getRole().equals(UserRole.QUALITY_ASSURANCE_EN)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        if (task.getType().equals(TaskType.FE_TASK)) {
            if(user.getRole().equals(UserRole.FE_LEAD) || user.getRole().equals(UserRole.FRONTEND_DEV)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        if (task.getType().equals(TaskType.BE_TASK)) {
            if(user.getRole().equals(UserRole.BACKEND_DEV) || user.getRole().equals(UserRole.BE_LEAD)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        if (task.getType().equals(TaskType.TEST)) {
            if(user.getRole().equals(UserRole.TESTER)){
                task.setStatus(TaskStatus.ASSIGNED);
                task.setAssigneeId(user.getId());
                return new AssignTaskDto("Successfully assigned to: " + user.getName());
            }
        }
        return new AssignTaskDto("Task type and user role don't match!");
    }
    public void changeTaskAssigneeAndType(Task task, User user, TaskType type){
        task.setType(type);
        task.setUpdateDate(LocalDateTime.now());
        System.out.println(assignTask(task, user).getMessage());
    }
    public EditTaskDto DeleteTask(ArrayList<Task> taskList, Task task, TaskStatus status){
        taskList.remove(task);
        return new EditTaskDto("Task successfully removed");
    }
    public EditTaskDto changeTaskName(Task task, String name){
        task.setName(name);
        task.setUpdateDate(LocalDateTime.now());
        return new EditTaskDto("Task name changed successfully");
    }
    public EditTaskDto changeTaskDescription(Task task, String description){
        task.setDescription(description);
        task.setUpdateDate(LocalDateTime.now());
        return new EditTaskDto("Task description changed successfully");
    }
}
