package com.java.ticket.dao;

import com.java.ticket.model.Issue;
import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.java.ticket.model.QIssue.issue;

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

    public List<Issue> findAll() {
        return entityRepository.query(query -> query
                .select(issue)
                .from(issue)
                .fetch());
    }

    public Issue save(Issue entity) {
        return entityRepository.save(entity);
    }

    public List<Issue> findAllByActiveIsTrueAndSubjectContainsOrContextContains(String search) {
        return entityRepository.query(query -> query
                .select(issue)
                .from(issue)
                .where(issue.active.eq(true).and(issue.subject.like(search, '%')).or
                        (issue.context.like(search, '%'))).fetch());
    }

}

