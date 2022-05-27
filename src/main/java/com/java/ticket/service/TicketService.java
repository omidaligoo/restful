package com.java.ticket.service;

import com.java.ticket.model.Ticket;
import com.java.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // get all
    public List<Ticket> getAllTickets(){
        return this.ticketRepository.findAll();
    }

    // get by id
    public Optional<Ticket> getTicketById(long id){
        return this.ticketRepository.findById(id);
    }
    
    // add
    public void createTicket(Ticket ticket){
        this.ticketRepository.save(ticket);
    }

    // update
    public void updateTicket(Ticket ticket, long id){
        Ticket existingTicket = this.ticketRepository.findById(id).orElse(null);

        if (existingTicket != null){
            existingTicket.setTicketUser(ticket.getTicketUser());
            existingTicket.setTicketIssue(ticket.getTicketIssue());
            existingTicket.setDescription(ticket.getDescription());
            existingTicket.setStatus(ticket.getStatus());
        }

        ticketRepository.save(existingTicket);
    }

    // delete (could be void or returns something to confirm)
    public void deleteTicket(long id){
        this.ticketRepository.deleteById(id);
    }
}
