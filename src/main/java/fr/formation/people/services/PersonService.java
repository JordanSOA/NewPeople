package fr.formation.people.services;

import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;

import java.util.List;

public interface PersonService {

    void create(PersonCreateDTO dto);

    void delete(Long id);

    PersonDTO get(Long id);

    List<PersonDTO> getAll();
}
