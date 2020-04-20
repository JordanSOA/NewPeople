package fr.formation.people.services;

import fr.formation.people.dtos.UserCreateDTO;
import fr.formation.people.dtos.UserDTO;
import fr.formation.people.entities.Role;
import fr.formation.people.entities.User;
import fr.formation.people.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    //@Transient
    public void create(UserCreateDTO dto) {
        User user = new User();
        user.setUsername(dto.getName());
        user.setPassword(dto.getPassword());
        /*
        Role role = new Role();
        role.setCode("USER");
        user.setRole(role); SAVE ?
        */
        userRepository.save(user);
    }

    @Override
    public UserDTO get(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getUsername());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();
        List<UserDTO> allUsers = new ArrayList<>();
        all.stream().forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getUsername());
            allUsers.add(userDTO);

        });
        return allUsers;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
