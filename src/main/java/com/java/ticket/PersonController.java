package com.java.ticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository=personRepository;
    }


    @GetMapping("/get-one-person/ver1")
    public Person getOnePerson()  {
        // Person person=new Person();

        // person.setFirstName("ali");
        // person.setLastName("alavi");
        // person.setMobile("0912");

        Person personAAC=new Person("hossein","alavi","0936");

    //    System.out.println(person.getLastName());

        return personAAC;
    }


    @GetMapping("/get-one-person-jpa/ver1")
    public Person getOnePerson(@RequestParam(name = "id", defaultValue = "") Long id)  {

       
        Person person=personRepository.findById(id).get();

        return person;
    }

    @GetMapping("/get-person-list/ver1")
    public List<Person> getPersonList()  {

        List<Person> personList= new ArrayList<>();

        Person person1=new Person("sajjad", "ahmadi", "0911");
        Person person2=new Person("esmaiel","mohammadzade","0902");
        Person person3=new Person("omid","aligoo","0902");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        return personList;

    }

    @GetMapping("/get-person-list-jpa/ver1")
    public List<Person> getPersonListWithJpa()  {

        List<Person> personList= personRepository.findAll();

        return personList;

    }

    @GetMapping("/set-person/ver1")
    public Person setPerson(@RequestParam(name = "firstName", defaultValue = "") String firstName,
                            @RequestParam(name = "lastName", defaultValue = "") String lastName,
                            @RequestParam(name = "mobile", defaultValue = "") String mobile)  {

   

        Person person=new Person(firstName, lastName, mobile);

        System.out.println("firstName is :");
        System.out.println(firstName);
        System.out.println("lastName is :");
        System.out.println(lastName);
        System.out.println("mobile is :");
        System.out.println(mobile);

        return person;

    }

    @PostMapping("/create-person")
    public Person create( @RequestBody Person person )  {
        
        System.out.println("firstName is :");
        System.out.println(person.getFirstName());
        System.out.println("lastName is :");
        System.out.println(person.getLastName());
        System.out.println("mobile is :");
        System.out.println(person.getMobile());

        return person;
    }

    @PostMapping("/create-person-jpa")
    public Person createWithJpa( @RequestBody Person person )  {
        
        System.out.println("firstName is :");
        System.out.println(person.getFirstName());
        System.out.println("lastName is :");
        System.out.println(person.getLastName());
        System.out.println("mobile is :");
        System.out.println(person.getMobile());

        return personRepository.save(person);
    }
    
}
