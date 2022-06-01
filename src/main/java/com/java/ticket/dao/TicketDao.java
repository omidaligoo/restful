package com.java.ticket.dao;

import com.java.ticket.model.Ticket;
import com.java.ticket.repository.TicketRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.java.ticket.model.QTicket.ticket;

@Repository
public class TicketDao {
    private final TicketRepository entityRepository;
    

    public TicketDao(TicketRepository entityRepository) {
        this.entityRepository = entityRepository;
    }


    public List<Ticket> findAll() {
        return entityRepository.query(query -> query
        .select(ticket)
        .from(ticket)
        .fetch());
    }

    public Ticket findById(long id) {
        return entityRepository.query(query -> query
        .select(ticket)
        .from(ticket)
        .where(ticket.id.eq(id))
        .fetchOne());
    }

    public void save(Ticket entity) {
        entityRepository.save(entity);
    }

    public void deleteById(long id) {
        entityRepository.deleteById(id);
    }

}
