
package com.java.ticket.repository;


import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import com.java.ticket.model.GeneralUser;
import com.java.ticket.model.Issue;
import com.java.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.java.ticket.model.QTicket.ticket;

@Repository
public interface IssueRepository extends ExtendedQuerydslJpaRepository<Issue,Long> {
    Optional<Issue> findAllById(long id);
    Issue deleteById(long id);



}

