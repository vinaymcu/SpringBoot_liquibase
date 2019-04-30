package com.concretepage.v8.stream;

import com.concretepage.v8.util.Customer;
import com.concretepage.v8.util.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class StreamTest {
    public static void main(String[] args) {

        List<Customer> custs= Util.getCustomers();
       // System.out.println("Original List");
       // printList(custs);

        long start = System.currentTimeMillis();
        List<Customer> sortedItems = custs.stream()
                .sorted(Comparator.comparing(Customer::getFirstName))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();

        System.out.println("sorted using sequential stream");
       // printList(sortedItems);
      //  System.out.println("Total the time taken process :"
            //    + (end - start) + " milisec.");

        // Using parallel stream
        start = System.currentTimeMillis();
        List<Customer> anotherSortedItems = custs
                .parallelStream().sorted(Comparator
                        .comparing(Customer::getFirstName))
                .collect(Collectors.toList());
        end = System.currentTimeMillis();

        System.out.println("sorted using parallel stream");
       // printList(anotherSortedItems);
       // System.out.println("Total the time taken process :"
             //   + (end - start) + " milisec.");

        IntStream stream = IntStream.of(1, 2);
       // stream.forEach(System.out::println);

       // That was fun! Let's do it again! give exception
        //IllegalStateException: stream has already been operated upon or closed
       // stream.forEach(System.out::println);

        List<Integer> list =
                IntStream.range(0, 10)
                        .boxed()
                        .collect(toCollection(ArrayList::new));
       // System.out.println("list>>"+list);

        Stream<String> se = Stream.empty();
        se.limit(10).forEach(System.out::println);

        Stream<String> stream1  = Stream.of("XML", "Java",  "CSS", "SQL");
       // stream1.forEach(System.out::println);
//        stream1.forEach(str->{
//            System.out.println(str);
//        });
        Stream<String> stream2  = Stream.<String>builder()
                .add("XML")
                .add("Java")
                .add("CSS")
                .add("SQL")
                .build();
        stream2.forEach(System.out::println);

        IntStream oneToFive  = IntStream.range(0, 6);
        //IntStream oneToFive  = IntStream.rangeClosed(1, 5);
        oneToFive.forEach(System.out::println);

//        Stream.generate(Math::random)
//                .limit(1)
//                .forEach(System.out::println);


        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).reduce(Integer::min);

        if (max.isPresent()) {
           // System.out.println("max = " + max.get());
        } else {
            //System.out.println("max is not  defined.");
        }

        Optional<Customer> anyMale = Util.getCustomers().stream().filter(Customer::isMale).findAny();
        //System.out.println(anyMale.toString());

       // Stream.of(10,20,22,12,14).reduce(Integer::sum).ifPresent(System.out::println);
        //Stream.of(10,20,22,12,14).reduce((x,y)->x+y).ifPresent(System.out::println);


        Integer arrSum = Stream.of(10,20,22,12,14,23,21,13,17,18).parallel().
                reduce(100, (x,y)->x+y, (p,q)->{
            System.out.println("combiner called:"+(p+q));
            return p+q;
        });
        System.out.println(arrSum);



    }

    private static int getCustomerAge(){

        return 1;
    }





    public static void printList(List<Customer> list) {
        for (Customer e : list)
            System.out.println(e.toString());
    }
}

