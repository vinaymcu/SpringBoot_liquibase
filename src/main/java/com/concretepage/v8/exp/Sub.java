package com.concretepage.v8.exp;


import java.io.IOException;

class Super
{
    void show() throws ArithmeticException {
        System.out.println("parent class");
    }
}

public class Sub extends Super
{
    void show()  throws ArithmeticException  //Compile time error
    {
        System.out.println("parent class");
    }

    public static void main( String[] args )
    {
        Super s=new Sub();
        s.show();
    }
}