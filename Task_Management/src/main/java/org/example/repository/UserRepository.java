package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.user.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.util.FileUtils.objectMapper;
import static org.example.util.FileUtils.userPath;

public interface UserRepository {
    File file = new File(userPath);
    default ArrayList<User> getUserList() {
        try {
            return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void writeToFile(ArrayList<User> userList) {
        try {
            objectMapper.writeValue(file, userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
