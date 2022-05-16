
package com.java.ticket.service;

import com.java.ticket.model.Issue;
import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issue getById(long id) {
        Optional<Issue> data = issueRepository.findById(id);
         return null;
    }
}

