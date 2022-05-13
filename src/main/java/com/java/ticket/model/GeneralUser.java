package com.java.ticket.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralUser {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;



    private String firstName;

    private String lastName;

    @Column(name = "ff",columnDefinition = "varchar(255)")
    private String email;

    private String username;

    private String password;

    private Role role;

    public enum Role {
        USER,SUPPORT,ADMIN,TESTER
    }


    @ManyToMany
    private List<Issue> isuue;

}
