
package com.java.ticket.repository;


import com.java.ticket.model.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
    Optional<Issue> findById(Long id);
    Optional<Issue> findBySubject(String subject);
    Optional<Issue> findByContext(String context);

  @Query(value = "SELECT * FROM issue  where subject=? and context=?;", nativeQuery = true)
    Integer findBySubjectAndContext(String subject,String context);

 /*   @Query(value = "FROM issue where active = true  and (subject like concat('%',:search,'%') or context like concat('%',:search,'%'))")
    List<Issue> findAllByActiveTrueAndSubjectContainsOrContextContainsOrCreateDateTimeContains(String search);*/

    @Query("from Issue where subject like concat('%',:search,'%') or context like concat('%',:search,'%')")
    List<Issue> findAllBySubjectAndContext(String search);

    Page<Issue> findAllByIssueStatusAndCreateDateTimeLessThanEqual(Issue status, Date CreateDateTime, Pageable pageable);

}

