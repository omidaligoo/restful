package com.java.ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {


    public Person(){

    }

    public Person(String firstName,String lastName,String mobile){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobile=mobile;
    }
    @Id
      private Long id;

    private String firstName;

    private String lastName;

    private String mobile;

    public Long  getId(){
        return this.id;
    }

    public String  getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }

    public String getMobile(){
        return this.mobile;
    }

    public void  setFirstName(String firstName){
         this.firstName=firstName;
    }
    
    public void setLastName(String lastName){
         this.lastName=lastName;
    }

    public void setMobile(String mobile){
         this.mobile=mobile;
    }

    public void setId(Long id){
        this.id=id;
   }


}
