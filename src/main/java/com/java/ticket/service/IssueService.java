
package com.java.ticket.service;

import com.java.ticket.dao.IssueDao;
import com.java.ticket.helper.exceptions.DataNotFoundException;
import com.java.ticket.model.GeneralUser;
import com.java.ticket.model.Issue;
import com.java.ticket.model.Ticket;
import com.java.ticket.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.java.ticket.model.QIssue.issue;

@Service
public class IssueService {
    private final IssueDao entityDao;
    private final IssueRepository entityRepository;

    public IssueService(IssueDao entityDao, IssueRepository entityRepository) {
        this.entityDao = entityDao;
        this.entityRepository = entityRepository;
    }

    public Issue getById(long id) {
        return entityDao.findById(id);
    }

    public List<Issue> findAll() {
        return this.entityDao.findAll();
    }

    public void register(Issue issue) {
        this.entityDao.save(issue);
    }

  public Issue Update(Issue issue, String id) {
      return this.entityRepository.save(issue);
  }

    public Issue delete( long id) {
        return this.entityRepository.deleteById( id);
    }
/*
    public List<Issue> findAllByCategory(long categoryId) {
        return entityDao.findAllByCategory(categoryId);
    }
*/
    public List<Issue> search(String keyword) {
        return entityDao.findAllByActiveIsTrueAndSubjectContainsOrContextContains(keyword);
    }


}

