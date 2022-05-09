package com.java.ticket.model.Generaluser;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneraluserRepository extends JpaRepository<Generaluser,Long>
{

   Generaluser deleteById(Generaluser generaluser);
}
