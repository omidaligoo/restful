
package com.java.ticket.repository;


import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import com.java.ticket.model.Issue;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends ExtendedQuerydslJpaRepository<Issue,Long> {


}

