package com.java.ticket.dao;

import com.java.ticket.repository.GeneralUserRepository;
import org.springframework.stereotype.Repository;

import static com.java.ticket.model.QGeneralUser.generalUser;

import java.util.List;

import com.java.ticket.model.GeneralUser;

@Repository
public class GeneralUserDao {
    private final GeneralUserRepository entityRepository;

    public GeneralUserDao(GeneralUserRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<GeneralUser> findAll() {
        return entityRepository.query(query -> query
        .select(generalUser)
        .from(generalUser)
        .fetch());
    }

    public GeneralUser save(GeneralUser entity) {
        return entityRepository.save(entity);
    }

    public GeneralUser deleteById(GeneralUser entity) {
        return entityRepository.save(entity);
    }
}
