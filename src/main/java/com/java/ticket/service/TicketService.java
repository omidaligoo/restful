package com.java.ticket.service;

import com.java.ticket.dao.TicketDao;
import com.java.ticket.model.Ticket;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    
    private final TicketDao entityDao;

    public TicketService(TicketDao entityDao){
        this.entityDao=entityDao;
    }

    // get all
    public List<Ticket> getAllTickets(){
        return this.entityDao.findAll();
    }

    // get by id
    public Ticket getTicketById(long id){
        return this.entityDao.findById(id);
    }
    
    // add
    public void createTicket(Ticket ticket){
        this.entityDao.save(ticket);
    }

    // update
    public void updateTicket(Ticket ticket, long id){
        Ticket existingTicket = this.entityDao.findById(id);

        if (existingTicket != null){
            // existingTicket.setTicketUser(ticket.getTicketUser());
            // existingTicket.setTicketIssue(ticket.getTicketIssue());
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setStatus(ticket.getStatus());
        }

        entityDao.save(existingTicket);
    }

    // delete (could be void or returns something to confirm)
    public void deleteTicket(long id){
        this.entityDao.deleteById(id);
    }
}
