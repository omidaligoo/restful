
package com.java.ticket.service;

import com.java.ticket.dao.IssueDao;
import com.java.ticket.model.Issue;
import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueService {
    private final IssueDao entityDao;

    public IssueService(IssueDao entityDao) {
        this.entityDao = entityDao;
    }

    public Issue getById(long id) {
        return entityDao.findById(id);
    }
}

