package fr.formation.people.services;

import fr.formation.people.dtos.AddressCreateDTO;
import fr.formation.people.dtos.AddressDTO;
import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;

import java.util.List;

public interface AddressService {

    void create(AddressCreateDTO dto);

    void delete(Long id);

    AddressDTO get(Long id);

    List<AddressDTO> getAll();

    List<AddressDTO> getAllSearchCity(String city);
}
