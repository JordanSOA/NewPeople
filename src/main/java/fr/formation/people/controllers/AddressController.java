package fr.formation.people.controllers;

import fr.formation.people.dtos.AddressCreateDTO;
import fr.formation.people.dtos.AddressDTO;
import fr.formation.people.services.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses") // http://localhost:8082/addresses
@CrossOrigin
public class AddressController {

    // Inject une instance de AddressServiceImpl.
    // AddressServiceImpl doit etre annotée @Service
    // @Autowired ou par constructeur
    private final AddressService service;

    // Injection par constructeur, permet de marquer
    // le champ service comme final (non réassignable)
    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping // POST "/addresses" avec un JSON dans le corps de la requête
    public void create(@RequestBody @Valid AddressCreateDTO dto) {
        service.create(dto);
    }

    @DeleteMapping("/{id}") // DELETE "/addresses/1" ou 1 correspond à l'id d'une adresse existante en bdd
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}") // GET "/addresses/1" ou 1 correspond à l'id d'une adresse existante en bdd
    public AddressDTO get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping // GET "/addresses" pas d'id, retourne toute la collection de ressources
    public List<AddressDTO> getAll() {
        return service.getAll();
    }
}
