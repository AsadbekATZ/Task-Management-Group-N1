package org.example.service.task;

import org.example.DTO.AssignTaskDto;
import org.example.model.task.Task;
import org.example.model.user.User;
import org.example.service.BaseService;

public interface TaskService extends BaseService<Task> {
    boolean isTaskNameBlank(Task task);
    boolean isTaskDescriptionBlank(Task task);
    AssignTaskDto assignTask(Task task, User user);
}
