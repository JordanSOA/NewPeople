package fr.formation.people.controllers;

import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;
import fr.formation.people.entities.Person;
import fr.formation.people.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    // GET http://localhost:8082/persons/123
    // /{id} = path variable, variable de chemin
    // /123 = récupérer dans id grace qu mapping "@PathVariable"
    @GetMapping("/{id}")
    public PersonDTO get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}") // DELETE "/persons/1"
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    // @RequestBody = extraire et convertir le JSON du corps (body)
    // de la requete HTTP vers une instance de PersonCreateDto
    // @Valid : cascader la validation sur le DTO, permet si besoin
    // de ne pas valider un meme DTO
    @PostMapping // POST "/persons"
    public void create(@RequestBody @Valid PersonCreateDTO dto) {
        service.create(dto);
    }

    @GetMapping // GET "/persons" pas d'id, retourne toute la collection de ressources
    public List<PersonDTO> getAll() {
        return service.getAll();
    }
}
