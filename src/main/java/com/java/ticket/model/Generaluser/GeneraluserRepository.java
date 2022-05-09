package com.java.ticket.model.Generaluser;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;

@Repository
public interface GeneraluserRepository extends JpaRepository<Generaluser,Long>
{

 }
