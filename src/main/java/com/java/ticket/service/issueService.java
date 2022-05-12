
package com.java.ticket.service;

import com.java.ticket.model.Issue;
import com.java.ticket.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class issueService {
    @Autowired
    private IssueRepository repository;

    public Issue getById(long id) {
        Optional<Issue> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }
}

