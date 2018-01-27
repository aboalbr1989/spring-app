package org.elias.springapp.repository;

import org.elias.springapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByFirstNameLike(String firstName);

}
