package com.concretepage.v8.fi;


import java.util.function.Function;


 class AddThree implements Function<Long, Long> {


     @Override
     public Long apply(Long aLong) {
         return null;
     }


 }


public class FunctionMain  {

    public static void main(String args[]){

        Function<Long, Long> adder = new AddThree();
        Long result = adder.apply((long) 4);
        System.out.println("result = " + result);
    }
}



