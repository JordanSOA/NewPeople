package fr.formation.people.services;

import fr.formation.people.dtos.AddressCreateDTO;
import fr.formation.people.dtos.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public void create(AddressCreateDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AddressDTO get(Long id) {
        return null;
    }

    @Override
    public List<AddressDTO> getAll() {
        return null;
    }
}
