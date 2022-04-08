package com.java.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.java.ticket.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
    
    Optional<Person> findById(Long id);

    Optional<Person> findByLastName(String lastName);

    @Query(value = "SELECT * FROM person  where firstName=? and lastName=?;", nativeQuery = true)
    Integer findByAreaAndCity(String firstName,String lastName);

}
