package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.model.BaseModel;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User extends BaseModel {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastname(), getEmail(), getPassword(), getRole());
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return  "Name = '" + name + '\'' +
                ", \nLastname = '" + lastname + '\'' +
                ", \nEmail = '" + email + '\'' +
                ", \nPassword = '" + password + '\'' +
                ", \nRole = " + role +
                ", \nID = " + id +
                ", \nCreated Date = " + createdDate.format(formatter) +
                ", \nUpdate Date = ";
    }
}
