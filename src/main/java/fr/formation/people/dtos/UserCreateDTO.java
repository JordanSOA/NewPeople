package fr.formation.people.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class UserCreateDTO {

    @Size(min = 1, max = 254)
    @NotEmpty
    @Email
    private String name;

    @Size(min = 8, max = 20)
    @NotEmpty
    private String password;

    public UserCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCreateDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
