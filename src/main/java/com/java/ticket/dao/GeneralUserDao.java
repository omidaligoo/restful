package com.java.ticket.dao;

import com.java.ticket.repository.GeneralUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralUserDao {
    private final GeneralUserRepository generalUserRepository;

    public GeneralUserDao(GeneralUserRepository generalUserRepository) {
        this.generalUserRepository = generalUserRepository;
    }
}
