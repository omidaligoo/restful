package com.java.ticket.dao;

import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Repository;

import static com.java.ticket.model.QIssue.issue;

import java.util.Optional;

import com.java.ticket.model.Issue;

@Repository
public class IssueDao {
    private final IssueRepository entityRepository;

    public IssueDao(IssueRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Issue findById(long id) {
        return entityRepository.query(query -> query
        .select(issue)
        .from(issue)
        .where(issue.id.eq(id))
        .fetchOne());
    }
}
