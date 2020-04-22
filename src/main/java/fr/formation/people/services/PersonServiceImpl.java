package fr.formation.people.services;


import fr.formation.people.dtos.PersonCreateDTO;
import fr.formation.people.dtos.PersonDTO;
import fr.formation.people.entities.Address;
import fr.formation.people.entities.Person;
import fr.formation.people.repositories.AddressRepository;
import fr.formation.people.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public void create(PersonCreateDTO dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setBirthdate(dto.getBirthdate());
        if (null != dto.getAddressId()) {
        person.setAddress( addressRepository.getOne(dto.getAddressId()));
        }
        personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO get(Long id) {
        Person person = personRepository.findById(id).get();
        return convertFrom(person);
    }


    @Override
    public List<PersonDTO> getAll() {
        List<Person> persons = personRepository.findAll();
        //List<PersonDTO> dtos = persons.stream().map(this::convertFrom).collect(Collectors.toList());
        return persons.stream().map(this::convertFrom).collect(Collectors.toList());
    }


    private PersonDTO convertFrom(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        return dto;
    }
}
