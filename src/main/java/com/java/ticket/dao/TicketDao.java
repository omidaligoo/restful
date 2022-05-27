package com.java.ticket.dao;

import com.java.ticket.model.Ticket;
import com.java.ticket.repository.TicketRepository;
import org.springframework.stereotype.Repository;
//import static com.persifund.auth.model.QReturnName.returnName;
import java.util.List;

//import static com.java.ticket.model.QTicket.ticket;
//import static com.infobip.spring.data.jpa.

@Repository
public class TicketDao {
    private final TicketRepository ticketRepository;
    QTicket qTicket;

    public TicketDao(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    void shouldQuery() {

        /*Ticket johnDoe = givenSavedPerson("John", "Doe");
        givenSavedPerson("Johny", "Roe");
        givenSavedPerson("Jane", "Doe");
        givenSavedPerson("John", "Roe");
        givenSavedPerson("Janie", "Doe");*/


        /*List<Ticket> actual = ticketRepository.query(query -> query
                .select(ticket)
                .from(ticket)
                .where(ticket.firstName.in("John", "Jane"))
                .orderBy(ticket.firstName.asc(), ticket.lastName.asc())
                .limit(1)
                .offset(1)
                .fetch());*/

        //then(actual).usingRecursiveFieldByFieldElementComparator().containsOnly(johnDoe);
    }

}
