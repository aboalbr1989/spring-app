package org.elias.springapp;

import org.elias.springapp.entity.Person;
import org.elias.springapp.repository.PersonRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> findAll() {
        return personRepository.findAll();
    }

    @PostMapping
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert(@RequestBody List<Person> person) {
        personRepository.save(person);
        return 1;

    }

    @GetMapping(value = "find/{username}")
    List<Person> getByFirstName(@PathVariable("username") String username) {
        System.out.println(username);
        return personRepository.findAllByFirstNameLike(username);
    }

    @DeleteMapping("{id}")
    int delete(@PathVariable("id") int id){
        personRepository.delete(id);
        return id;
    }



}
