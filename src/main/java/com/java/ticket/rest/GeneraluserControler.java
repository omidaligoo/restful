package com.java.ticket.rest;

import com.java.ticket.jwt.JwtAuth;
import com.java.ticket.jwt.JwtUtils;
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
public class GeneraluserControler {
    private final GeneralUserService generalUserService;
    private final AuthenticationManager manager;
    private final JwtUtils jwtUtils;

    @Autowired
    public GeneraluserControler(GeneralUserService generalUserService, AuthenticationManager manager, JwtUtils jwtUtils) {
        this.generalUserService = generalUserService;
        this.manager = manager;
        this.jwtUtils = jwtUtils;
    }
     @RequestMapping(value = "", method = RequestMethod.GET)
    public List<GeneralUser> getUser() {
        return generalUserService.findAlluser();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public GeneralUser RegisterUser(@RequestBody GeneralUser generaluser) {
        return generalUserService.RegisterUser(generaluser);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public GeneralUser UpdateUser(@RequestBody GeneralUser generaluser, String id) {

        return generalUserService.UpdateUser(generaluser, id);
    }
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public GeneralUser DeleteUser(@RequestBody GeneralUser generaluser, String id) {

        return generalUserService.DeleteUser(generaluser, id);
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


