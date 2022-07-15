package com.java.ticket.repository;

import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import org.springframework.stereotype.Repository;
import com.java.ticket.model.GeneralUser;

@Repository
public interface GeneralUserRepository extends ExtendedQuerydslJpaRepository<GeneralUser,Long>
{

  GeneralUser deleteById(long id);
  GeneralUser findByEmail(String email);
}
