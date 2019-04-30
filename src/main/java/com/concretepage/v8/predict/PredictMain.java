package com.concretepage.v8.predict;

import com.concretepage.v8.util.Customer;
import com.concretepage.v8.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredictMain {
    public static void main(String args[]){

        List<Customer> custs=Util.getCustomers();
        //System.out.println("****** Data for process*********** ");

        List<String> collect1 = Util.getCustomers().stream().map(Customer::getFirstName)
                .collect(Collectors.toList());
        //collect1.forEach(System.out::println);

        List<Customer> collect2 = custs.stream()
                .filter(p -> p.getAge() > 18)
                  .collect(Collectors.toList());

        //collect2.forEach(System.out::println);

        List<Customer> listP = custs.stream()
                .parallel()
                .filter(p -> p.getAge() > 18)  // filtering will be performed concurrently
                .sequential()
                .collect(Collectors.toCollection(ArrayList::new));
       // System.out.println("*****parallel*****");
       // listP.forEach(System.out::println);

        List<Customer> listS = custs.stream()
                .sequential()
                .filter(p -> p.getAge() > 18)  // filtering will be performed concurrently
                .sequential()
                .collect(Collectors.toCollection(ArrayList::new));
       // System.out.println("*****sequential*****");
       // listS.forEach(System.out::println);

      //  System.out.println(getCustomerAges());

    }


    public static Predicate<Customer> isAdultMale() {
        return p -> p.isMale();
                //> 18 && p.isMale().equalsIgnoreCase("M");
    }

    public static List<Customer> filterEmployees (List<Customer> employees,
                                                  Predicate<Customer> predicate){
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Customer>toList());
    }
}

