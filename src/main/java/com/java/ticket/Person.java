package com.java.ticket;

public class Person {


    public Person(){

    }

    public Person(String firstName,String lastName,String mobile){
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobile=mobile;
    }

    private String firstName;

    private String lastName;

    private String mobile;


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


}
