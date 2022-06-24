package com.java.ticket.service;

import com.java.ticket.dao.IssueCategoryDao;
import com.java.ticket.dao.IssueDao;
import com.java.ticket.repository.IssueCategoryRepository;
import com.java.ticket.repository.IssueRepository;

public class IssueCategoryService {
    private final IssueCategoryDao entityDao;
    private final IssueCategoryRepository entityRepository;

    public IssueCategoryService(IssueCategoryDao entityDao, IssueCategoryRepository entityRepository) {
        this.entityDao = entityDao;
        this.entityRepository = entityRepository;
    }
}
