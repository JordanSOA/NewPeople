package fr.formation.people.services;

import fr.formation.people.dtos.UserCreateDTO;
import fr.formation.people.dtos.UserDTO;
import fr.formation.people.entities.Role;
import fr.formation.people.entities.User;
import fr.formation.people.repositories.RoleRepository;
import fr.formation.people.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    //@Transient
    public void create(UserCreateDTO dto) {
        User user = new User();
        user.setUsername(dto.getName());
        user.setPassword(dto.getPassword());
        //Role role = roleRepository.findByStatus();
        Role defaultRole = roleRepository.findByDefaultRole(true);
        user.setRole(defaultRole);
        userRepository.save(user);
    }

    @Override
    public UserDTO get(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getUsername());
        userDTO.setRoleName(user.getRole().getCode());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();
        List<UserDTO> allUsers = new ArrayList<>();
        all.stream().forEach(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getUsername());
            userDTO.setRoleName(user.getRole().getCode());
            allUsers.add(userDTO);

        });
        return allUsers;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getByName(String username) {
        User byUsername = userRepository.findByUsername(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(byUsername.getUsername());
        userDTO.setRoleName(byUsername.getRole().getCode());
        return userDTO;
    }
}
