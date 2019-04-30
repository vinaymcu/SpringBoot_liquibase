package com.concretepage.mongodb;

import org.springframework.data.annotation.Id;


public class Emp {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;


    public Emp() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }




    public Emp(String firstName, String lastName,String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city=city;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s',city='%s']", this.id,
                this.firstName, this.lastName,this.city);
    }
}
