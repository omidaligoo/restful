
package com.java.ticket.repository;


import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import com.java.ticket.model.Issue;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends ExtendedQuerydslJpaRepository<Issue,Long> {


}

