package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.model.BaseModel;

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
        return  "name='" + name + '\'' +
                ", \nlastname='" + lastname + '\'' +
                ", \nemail='" + email + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nrole=" + role +
                ", \nid=" + id +
                ", \ncreatedDate=" + createdDate +
                ", \nupdateDate=";
    }
}
