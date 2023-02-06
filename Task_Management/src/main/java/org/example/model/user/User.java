package org.example.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.model.BaseModel;

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
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
