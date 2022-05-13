package com.java.ticket.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.java.ticket.model.GeneralUser;
import com.java.ticket.repository.GeneralUserRepository;


@Service
public class GeneralUserService {
    private GeneralUserRepository generalUserRepository;
    private GeneralUser generaluser;

    @Autowired
    public GeneralUserService(GeneralUserRepository generalUserRepository) {
        this.generalUserRepository = generalUserRepository;
    }

    public List<GeneralUser> findAlluser() {
        return this.generalUserRepository.findAll();
    }

    public GeneralUser RegisterUser(GeneralUser generaluser) {
        return this.generalUserRepository.save(generaluser);
    }

    public GeneralUser UpdateUser(GeneralUser generaluser, String id) {
        return this.generalUserRepository.save(generaluser);
    }


    public GeneralUser DeleteUser(GeneralUser generaluser, String id) {
        return this.generalUserRepository.deleteById(generaluser);
    }
}