package com.java.ticket.model.Generaluser;

import javax.persistence.*;


import com.java.ticket.model.Issue.Issue;
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
public class Generaluser {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

   @ManyToMany
   private List<Issue> isuue;

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

}
