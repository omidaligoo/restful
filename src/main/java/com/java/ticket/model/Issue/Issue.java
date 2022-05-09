package com.java.ticket.model.Issue;

import com.java.ticket.model.Generaluser.Generaluser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Generaluser generaluser;

}
