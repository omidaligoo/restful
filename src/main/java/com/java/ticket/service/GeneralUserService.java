package com.java.ticket.service;

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
    private final GeneralUserRepository generaluserRepository;

    @Autowired
    public GeneralUserService(GeneralUserRepository generaluserRepository) {
        this.generaluserRepository = generaluserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return generaluserRepository.findByEmail(email);
    }

    public List<GeneralUser> findAll() {
        return generaluserRepository.findAll();
    }

 /*   public GeneralUser findById(Long id) {
        return generaluserRepository.getOne(id);
    }*/

    @PreAuthorize("#generaluser.email != authentication.name")
    public void deleteById(GeneralUser generaluser) {
        generaluserRepository.deleteById(generaluser.getId());
    }


    public List<GeneralUser> findAlluser() {
        return this.generaluserRepository.findAll();
    }

    public GeneralUser RegisterUser(GeneralUser generaluser) {
        return this.generaluserRepository.save(generaluser);
    }

    public GeneralUser UpdateUser(GeneralUser generaluser, String id) {
        return this.generaluserRepository.save(generaluser);
    }


    public GeneralUser DeleteUser(GeneralUser generaluser, String id) {
        return this.generaluserRepository.deleteById(generaluser);
    }
}
