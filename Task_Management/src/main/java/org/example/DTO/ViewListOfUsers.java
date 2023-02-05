package org.example.DTO;

import org.example.model.user.User;
import org.example.model.user.UserRole;
import org.example.repository.UserRepository;

public class ViewListOfUsers implements UserRepository {
    public void viewUserList(UserRole role){
        int cnt = 0;
        System.out.println("List of users in role of: " + role);
        for (User user : getUserList()) {
            if (user.getRole().equals(role)){
                System.out.println("*********" + cnt + "********");
                System.out.println("User ID: " + user.getId());
                System.out.println("User name: " + user.getName());
                System.out.println("User last name: " + user.getLastname());
                System.out.println("User email: " + user.getEmail());
                System.out.println("User created date: " + user.getCreatedDate());
                System.out.println("User updated date: " + user.getUpdateDate());
            }
        }
    }
}