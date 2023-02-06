package org.example.service.user;

import org.example.DTO.AssignRoleDto;
import org.example.DTO.ChangeRoleOfUserDto;
import org.example.DTO.RemoveUserDto;
import org.example.model.task.Task;
import org.example.model.task.TaskStatus;
import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.repository.TaskRepository;
import org.example.repository.UserRepository;

import java.util.ArrayList;

public class ManagerService implements UserRepository, TaskRepository {
    public AssignRoleDto assignRole(User user, UserRole userRole){
        ArrayList<User> userList = getUserList();
        for (Task task : getTaskList()) {
            if (task.getAssigneeId().equals(user.getId()) && !task.getStatus().equals(TaskStatus.DONE)){
                return new AssignRoleDto("This user has active task cannot remove this user!");
            }
        }
        for (User user1 : userList) {
            if (user1.getEmail().equals(user.getEmail())){
                user1.setRole(userRole);
                break;
            }
        }
        writeToFile(userList);
        return new AssignRoleDto(user.getName() + "'s role assigned to: " + userRole);
    }
    public RemoveUserDto removeUser(User user){
        for (Task task : getTaskList()) {
            if (task.getAssigneeId().equals(user.getId()) && !task.getStatus().equals(TaskStatus.DONE)){
                return new RemoveUserDto("This user has active task cannot remove this user!");
            }
        }
        ArrayList<User> userList = getUserList();
        userList.remove(user);
        writeToFile(userList);
        return new RemoveUserDto(user.getName() + " was successfully deleted!");
    }
}
