package com.java.ticket.repository;

import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import com.java.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends ExtendedQuerydslJpaRepository<Ticket, Long> {

    Optional<Ticket> findById(long id);

    //Optional<Ticket> fin

    //find by status

    //find by user

    //find by issue
}
