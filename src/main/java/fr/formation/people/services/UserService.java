package fr.formation.people.services;

import fr.formation.people.dtos.UserCreateDTO;
import fr.formation.people.dtos.UserDTO;

import java.util.List;

public interface UserService {

    void create(UserCreateDTO dto);

    UserDTO get(Long id);

    List<UserDTO> getAll();

    void delete(Long id);
}
