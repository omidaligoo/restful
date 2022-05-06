package com.java.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.java.ticket.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
    

}
