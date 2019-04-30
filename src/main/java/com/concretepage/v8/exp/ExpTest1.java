package com.concretepage.v8.exp;


import java.io.IOException;

class Test{
    void method() {//throws IOException {
        try{
            throw new IOException("device error");
        }catch(Exception e){
            System.out.println("Exception eee");
        }

    }
}

public class ExpTest1 {

    public static void main(String args[])
    {
        try{
            Test t=new Test();
            t.method();
        }catch(Exception e){
            System.out.println("exception handled");}

        System.out.println("normal flow...");
//        int a[] = new int[]{2,3,5};
//        try {
//
//            System.out.println("Access element three :");
//            int x = a[2] / 0;
//            System.out.println(x);
//
//        } catch(ArithmeticException e){
//            System.out.println(" ArithmeticException "+e);
//
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("Exception thrown  :" + e);
//        }
//        finally{
//            a[0] = 6;
//            System.out.println("First element value: " +a[0]);
//            System.out.println("The finally statement is executed");
//        }
    }
}



