package org.example.model.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.BaseModel;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseModel {
    private String name;
    private String description;
    private UUID assigneeId;
    private TaskType type;
    private TaskStatus status;

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assigneeId=" + assigneeId +
                ", type=" + type + " Task" +
                ", status=" + status +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
