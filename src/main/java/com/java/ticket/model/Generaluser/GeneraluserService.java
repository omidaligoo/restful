package com.java.ticket.model.Generaluser;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Setter
@Getter
@Service
public class GeneraluserService {
    private GeneraluserRepository generaluserRepository;
    private Generaluser generaluser;

    @Autowired
    public GeneraluserService(GeneraluserRepository generaluserRepository) {
        this.generaluserRepository = generaluserRepository;
    }

    public List<Generaluser> findAlluser() {
        return this.generaluserRepository.findAll();
    }

    public Generaluser RegisterUser(Generaluser generaluser) {
        return this.generaluserRepository.save(generaluser);
    }

    public Generaluser UpdateUser(Generaluser generaluser, String id) {
        return this.generaluserRepository.save(generaluser);
    }


    public Generaluser DeleteUser(Generaluser generaluser, String id) {
        return this.generaluserRepository.deleteById(generaluser);
    }
}