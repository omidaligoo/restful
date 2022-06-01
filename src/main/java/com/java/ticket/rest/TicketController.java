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
    /*
    Answer: In a short words yes you should,you must use "final" becuase "autowierd" annotation create a bit confilict
    */
    private final TicketService entityService;

    public TicketController(TicketService entityService) {
        this.entityService = entityService;
    }

    @GetMapping("/ticket")
    public List<Ticket> getAllTicket()
    {
        return entityService.getAllTickets();
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable long id)
    {
        return entityService.getTicketById(id);
    }

    @PostMapping("/ticket/addTicket")
    public void addTicket(@RequestBody Ticket ticket){
        entityService.createTicket(ticket);
    }

    @PutMapping("/ticket/updateTicket")
    public void updateTicket(@RequestBody Ticket ticket, long id){
        entityService.updateTicket(ticket, id);
    }

    @DeleteMapping("/ticket/deleteTicket")
    public void deleteTicket(@PathVariable long id){
        entityService.deleteTicket(id);
    }
}
