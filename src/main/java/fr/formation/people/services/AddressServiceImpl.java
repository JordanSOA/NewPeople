package fr.formation.people.services;

import fr.formation.people.dtos.AddressCreateDTO;
import fr.formation.people.dtos.AddressDTO;
import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;
import fr.formation.people.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void create(AddressCreateDTO dto) {
        // Grace a la validation dans le controller
        // on fait confiance a la qualité des données.
        // Convertir AddressCreateDto en Address (entité)
        // En création pas l'id, l'id est attribué par la bdd
        Address address = convertCreateDtoToEntity(dto);
        addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO get(Long id) {
        Address address = addressRepository.findById(id).get();
        AddressDTO addressDTO = convertEntityToDto(address);
        return addressDTO;
    }

    @Override
    public List<AddressDTO> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private AddressDTO convertEntityToDto(Address address){
        AddressDTO dto = new AddressDTO();
        dto.setIdFromDb(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setCountry(address.getCountry());
        return dto;
    }

    private Address convertCreateDtoToEntity(AddressCreateDTO AddressCreateDTO){
        Address address = new Address();
        address.setStreet(AddressCreateDTO.getStreet()); // Copy street du dto vers l'entité
        address.setCity(AddressCreateDTO.getCity());
        address.setZipCode(AddressCreateDTO.getZipCode());
        address.setCountry(AddressCreateDTO.getCountry());
        return address;
    }

    @Override
    public List<AddressDTO> getAllSearchCity(String city) {
        List<Address> addressByCityList = addressRepository.findByCityContainsIgnoreCase(city);
        return addressByCityList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
}
