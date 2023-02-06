package org.example.DTO;

import org.example.model.user.User;
import org.example.repository.UserRepository;

public class ViewMyInfoDto implements UserRepository {
    public void myInfo(User currentUser){
        for (User user : getUserList()) {
            if (user.getId().equals(currentUser.getId())){
                System.out.println("Your name: " + user.getName());
                System.out.println("Your last name: " + user.getLastname());
                System.out.println("Your email: " + user.getEmail());
                System.out.println("Your role: " + user.getRole());
                System.out.println("Your account is created in: " + user.getCreatedDate());
                System.out.println("Your account is updated in: " + user.getUpdateDate());
                System.out.println("Your account ID: " + user.getId());
                break;
            }
        }
    }
}
