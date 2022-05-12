package com.java.ticket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Issue")
@Table(name = "t_Issue")
@Getter
@Setter
public class Issue extends com.java.ticket.model.generalDomain {
    // @Column(name = "c_context", columnDefinition = "VARCHAR(255)")
    private String context;
    // @Column(name = "c_subject", columnDefinition = "VARCHAR(255)")
    private String subject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_issueType")
    private CategoryElement issueType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_issueStatuse")
    private CategoryElement issueStatus;
    /* @OneToMany()
 @JoinTable(name = "mm_GeneralUserIssue",
         joinColumns = {@JoinColumn(name = "c_receiveIssueId")},
         inverseJoinColumns = {@JoinColumn(name = "c_receiverId")})
 private List<GeneralUser> receiverGeneralUser;*/
    //@ManyToMany()
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "mm_GeneraluserIssue",
            joinColumns = {@JoinColumn(name = "c_receiveIssueId")},
            inverseJoinColumns = {@JoinColumn(name = "c_receiverId")})
    private List<GeneralUser> receiverGeneralUser;
}