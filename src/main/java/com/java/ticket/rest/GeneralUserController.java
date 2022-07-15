package com.java.ticket.rest;

import com.java.ticket.jwt.JwtAuth;
import com.java.ticket.jwt.JwtUtils;
import com.java.ticket.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import com.java.ticket.service.GeneralUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import com.java.ticket.model.GeneralUser;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
public class GeneralUserController {
    private final GeneralUserService entityService;
    private final AuthenticationManager manager;
    private final JwtUtils jwtUtils;

    @Autowired
    public GeneralUserController(GeneralUserService generalUserService, AuthenticationManager manager, JwtUtils jwtUtils) {
        this.entityService = generalUserService;
        this.manager = manager;
        this.jwtUtils = jwtUtils;
    }
     @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<GeneralUser> get() {
        return entityService.findAll();
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public GeneralUser Register(@RequestBody GeneralUser generaluser) {
        return entityService.Register(generaluser);
    }

    @RequestMapping(value = "/Update", method = RequestMethod.PUT)
    public GeneralUser Update(@RequestBody GeneralUser generaluser, String id) {

        return entityService.Update(generaluser, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        entityService.delete(id);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/jwt/login")
    public @ResponseBody
    ResponseEntity<?> jwtLogin(@RequestBody JwtAuth jwtAuth, HttpServletResponse response) {

        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuth.getUsername(), jwtAuth.getPassword()));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        response.addHeader("Authorization", jwtUtils.generateToken(jwtAuth.getUsername()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/jwt/hello")
    public @ResponseBody
    String jwtHello() {
        return "Hello Jwt";
    }

    @GetMapping("/info")
    public @ResponseBody
    Principal getCookie(Principal principal) {
        return principal;
    }


}


