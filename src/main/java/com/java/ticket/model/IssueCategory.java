package com.java.ticket.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IssueCategory extends com.java.ticket.basic.model.GeneralDomain {


    private String name;

    private String description;

   /* @ManyToMany(mappedBy = "category")
    private Set<Issue> issue=new HashSet<Issue>();
*/
}
