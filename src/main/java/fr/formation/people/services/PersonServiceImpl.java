package fr.formation.people.services;


import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public void create(PersonCreateDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PersonDTO get(Long id) {
        return null;
    }

    @Override
    public List<PersonDTO> getAll() {
        return null;
    }
}
