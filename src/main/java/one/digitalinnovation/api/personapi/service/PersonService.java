package one.digitalinnovation.api.personapi.service;

import one.digitalinnovation.api.personapi.dto.PersonDTO;
import one.digitalinnovation.api.personapi.entity.Person;
import one.digitalinnovation.api.personapi.mapper.PersonMapper;
import one.digitalinnovation.api.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;


    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Transactional(readOnly = true)
    public List<PersonDTO> findAll() {
       List<Person> allPerson = repository.findAll();
       return allPerson.stream()
               .map(personMapper::toDTO)
               .collect(Collectors.toList());
    }


    @Transactional
    public PersonDTO createPerson (PersonDTO dto) {
        Person personToSave = personMapper.toModel(dto);
        repository.save(personToSave);
        return personMapper.toDTO(personToSave);
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    @Transactional
    public PersonDTO update (Long id, PersonDTO dto) {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(dto);
        Person updatePerson = repository.save(personToUpdate);
        return personMapper.toDTO(updatePerson);
    }

    @Transactional
    public void delete(Long id) {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    public Person verifyIfExists(Long id) {
        return repository.findById(id).orElse(null);
    }

}
