package com.java.ticket.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.java.ticket.dao.GeneralUserDao;
import com.java.ticket.model.GeneralUser;
import com.java.ticket.repository.GeneralUserRepository;


@Service
public class GeneralUserService {
    
    private final GeneralUserDao entityDao;

    public GeneralUserService (GeneralUserDao entityDao){
        this.entityDao=entityDao;
    }
    


    public List<GeneralUser> findAlluser() {
        return this.entityDao.findAll();
    }

    public GeneralUser RegisterUser(GeneralUser generaluser) {
        return this.entityDao.save(generaluser);
    }

    public GeneralUser UpdateUser(GeneralUser generaluser, String id) {
        return this.entityDao.save(generaluser);
    }


    public GeneralUser DeleteUser(GeneralUser generaluser, String id) {
        return this.entityDao.deleteById(generaluser);
    }
}