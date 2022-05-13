package com.java.ticket.repository;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.metamodel.SingularAttribute;

import com.java.ticket.model.GeneralUser;

import java.io.Serializable;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser,Long>
{

  GeneralUser deleteById(GeneralUser generaluser);
}
