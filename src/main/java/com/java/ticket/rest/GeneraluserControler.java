package com.java.ticket.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.java.ticket.model.GeneralUser;
import com.java.ticket.service.GeneralUserService;


@RestController
    @RequestMapping("/users")
    public class GeneraluserControler {
    private final GeneralUserService generalUserService;

    @Autowired
    public GeneraluserControler(GeneralUserService generalUserService) {
        this.generalUserService = generalUserService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<GeneralUser> getUser() {
        return generalUserService.findAlluser();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public GeneralUser RegisterUser(@RequestBody GeneralUser generaluser) {
        return generalUserService.RegisterUser(generaluser);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public GeneralUser UpdateUser(@RequestBody GeneralUser generaluser, String id) {

        return generalUserService.UpdateUser(generaluser, id);
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public GeneralUser DeleteUser(@RequestBody GeneralUser generaluser, String id) {

        return generalUserService.DeleteUser(generaluser, id);
    }
    }



