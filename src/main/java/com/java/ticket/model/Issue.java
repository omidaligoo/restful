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
public class Issue extends com.java.ticket.basic.model.GeneralDomain {


    private String context;

    private String subject;

    private Long categoryId;

    @OneToOne
    @JoinColumn(name = "ticket_issue_id")
    private Issue ticketIssue;

  /*  @ManyToOne
    @JoinColumn(name = "issue_issueCategory_id")
    private Set<IssueCategory> category=new HashSet<IssueCategory>();*/


}
