package com.java.ticket.dao;

import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Repository;

@Repository
public class IssueDao {
    private final IssueRepository issueRepository;

    public IssueDao(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}
