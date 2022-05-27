package com.java.ticket.rest;

import com.java.ticket.model.Ticket;
import com.java.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    //should be final or not? if yes add final keyword and init in constructor
    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> getAllTicket()
    {
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/{id}")
    public Optional<Ticket> getTicketById(@PathVariable long id)
    {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/ticket/addTicket")
    public void addTicket(@RequestBody Ticket ticket){
        ticketService.createTicket(ticket);
    }

    @PutMapping("/ticket/updateTicket")
    public void updateTicket(@RequestBody Ticket ticket, long id){
        ticketService.updateTicket(ticket, id);
    }

    @DeleteMapping("/ticket/deleteTicket")
    public void deleteTicket(@PathVariable long id){
        ticketService.deleteTicket(id);
    }
}
