package com.java.ticket.dao;

import com.java.ticket.model.IssueCategory;
import com.java.ticket.repository.IssueCategoryRepository;
import org.springframework.stereotype.Repository;

import static com.java.ticket.model.QIssueCategory.issueCategory;

@Repository
public class IssueCategoryDao {
    private final IssueCategoryRepository entityRepository;

    public IssueCategoryDao(IssueCategoryRepository entityRepository) {
        this.entityRepository = entityRepository;
    }


}
