package com.concretepage.v8.util;

public class Customer {

    private Integer id;
    private Integer age;
    //private String gender;
    private String firstName;
    private String lastName;
    private Gender gender;

    public Customer(){

    }
    public Customer(Integer id, Integer age, String fName, String lName,Gender gender){
        this.setId(id);
        this.setAge(age);
       // this.setGender(gender);
        this.setFirstName(fName);
        this.setLastName(lName);
        this.gender=gender;
    }

    public static enum Gender {
        MALE, FEMALE
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }


    //Please generate Getter and Setters

    //To change body of generated methods, choose Tools | Templates.
    @Override
    public String toString() {

        return this.getId().toString()+" - "+
                this.age+"-"+this.firstName+" - "+this.lastName+"-"+this.gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
