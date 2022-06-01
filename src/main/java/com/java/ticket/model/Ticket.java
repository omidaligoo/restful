package com.java.ticket.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    public enum ticketStatus{
        NEW,
        ONHOLD,
        INPROGRESS,
        CLOSED
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    //private long ticketNumber;

    private String description;

    private ticketStatus status;

    @OneToOne
    @JoinColumn(name = "ticket_issue_id")
    private Issue ticketIssue;



    @OneToOne
    @JoinColumn(name = "ticket_user_id")
    private GeneralUser ticketUser;

    // //you only need asked user Id;
    // private Long generalUserId;


}
