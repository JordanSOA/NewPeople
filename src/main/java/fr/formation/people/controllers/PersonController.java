package fr.formation.people.controllers;

import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;
import fr.formation.people.entities.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable("id") Long id){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName("Beber");
        personDTO.setLastName("Maddoff");
        return personDTO;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        return "Person with id: "+ id+" got deleted";
    }

    @PostMapping
    public void createPerson(@RequestBody  @Valid  PersonCreateDTO personCreateDTO){
        System.out.println(personCreateDTO.toString());
    }
}
