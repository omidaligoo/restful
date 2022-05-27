package com.java.ticket.repository;

import com.java.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Optional<Ticket> findById(long id);

    //Optional<Ticket> fin

    //find by status

    //find by user

    //find by issue
}
