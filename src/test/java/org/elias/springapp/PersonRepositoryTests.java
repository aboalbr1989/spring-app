package org.elias.springapp;

import org.elias.springapp.entity.Person;
import org.elias.springapp.repository.PersonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void shouldAddPerson() {
        Person p = new Person();
        p.setFirstName("Ebrahim");
        p = personRepository.save(p);
        assertNotNull(p);
        assertEquals(p.getFirstName(), "Ebrahim");
    }

}
