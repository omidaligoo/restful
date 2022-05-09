package com.java.ticket.model.Generaluser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GeneraluserControler {
    private final GeneraluserService generaluserService;

    @Autowired
    public GeneraluserControler(GeneraluserService generaluserService)
    {
        this.generaluserService = generaluserService;
    }

     @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Generaluser> getUser()
     {
        return generaluserService.findAllGeneraluser();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Generaluser RegisterUser(@RequestBody Generaluser generaluser)
    {
        return generaluserService.RegisterUser(generaluser);
    }

     @RequestMapping (value = "/",method =  RequestMethod.PUT)
    public Generaluser UpdateUser(@RequestBody Generaluser generaluser,String id)
    {

        return generaluserService.UpdateUser(generaluser,id);
    }

    @RequestMapping (value = "/{id}",method =  RequestMethod.DELETE)
    public ResponseEntity<String> DeleteUser(@RequestBody Generaluser generaluser, String id)
    {

        return generaluserService.DeleteUser(generaluser,id);
    }

}