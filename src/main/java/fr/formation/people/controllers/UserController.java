package fr.formation.people.controllers;

import fr.formation.people.dtos.UserCreateDTO;
import fr.formation.people.dtos.UserDTO;
import fr.formation.people.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody @Valid UserCreateDTO dto){
        userService.create(dto);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable("id") Long id){
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getAll();
    }
}
