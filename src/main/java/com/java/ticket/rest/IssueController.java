package com.java.ticket.rest;

import com.java.ticket.model.GeneralUser;
import com.java.ticket.model.Issue;
import com.java.ticket.service.IssueService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {
    private final IssueService entityService;

    public IssueController(IssueService issueService) {
        this.entityService = issueService;
    }

    @GetMapping("/findAll")
    public List<Issue> findAll() {
        return entityService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Issue getById(@PathVariable long id) {
        return entityService.getById(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody Issue issue) {
        entityService.register(issue);
    }

 @RequestMapping(value = "/Update", method = RequestMethod.PUT)
 public Issue Update(@RequestBody Issue issue, String id) {

     return entityService.Update(issue, id);
 }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        entityService.delete(id);
    }

    @GetMapping("/search")
    public List<Issue> search(@RequestParam String keyword) {

        List<Issue> result = entityService.search(keyword);
       return entityService.search(String.valueOf((result)));

    }
   /* @GetMapping("/find")
    public List<Issue> find(@RequestParam long id) {
                  List<Issue> result = entityService.findAllByCategory(id);
        return entityService.search(String.valueOf((result)));


    }*/

}
