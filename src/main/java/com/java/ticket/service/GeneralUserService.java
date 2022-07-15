package com.java.ticket.service;

import com.java.ticket.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.java.ticket.model.GeneralUser;
import com.java.ticket.repository.GeneralUserRepository;
import java.util.List;

@Service
public class GeneralUserService implements UserDetailsService {
    private final GeneralUserRepository entityRepository;

    @Autowired
    public GeneralUserService(GeneralUserRepository generaluserRepository) {
        this.entityRepository = generaluserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return entityRepository.findByEmail(email);
    }

    public List<GeneralUser> findAll() {
        return entityRepository.findAll();
    }

 /*   public GeneralUser findById(Long id) {
        return generaluserRepository.getOne(id);
    }*/

    @PreAuthorize("#generaluser.email != authentication.name")
    public void deleteById(GeneralUser generaluser) {
        entityRepository.deleteById(generaluser.getId());
    }

    public GeneralUser Register(GeneralUser generaluser) {
        return this.entityRepository.save(generaluser);
    }

    public GeneralUser Update(GeneralUser generaluser, String id) {
        return this.entityRepository.save(generaluser);
    }
    public GeneralUser delete(long id) {
        return this.entityRepository.deleteById( id);
    }

}
