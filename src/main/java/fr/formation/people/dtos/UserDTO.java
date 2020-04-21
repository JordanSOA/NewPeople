package fr.formation.people.dtos;

public class UserDTO {

    private String name;

    private String roleName;

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
