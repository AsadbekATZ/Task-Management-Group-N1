package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public interface FileUtils {
    ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.INDENT_OUTPUT, true);

    String userPath = "C:\\my\\PDP\\Taks_Management\\src\\main\\resources\\users.json";
    String tasksPath = "C:\\my\\PDP\\Taks_Management\\src\\main\\resources\\tasks.json";
}
