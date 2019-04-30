package com.concretepage.spring.javaconfig;


public class HelloWorld {
    public String getMessage() {
        System.out.println("Your Message : " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
