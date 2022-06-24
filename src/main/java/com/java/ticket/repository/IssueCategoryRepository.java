package com.java.ticket.repository;

import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;
import com.java.ticket.model.Issue;
import com.java.ticket.model.IssueCategory;

public interface IssueCategoryRepository  extends ExtendedQuerydslJpaRepository<IssueCategory,Long> {

}
