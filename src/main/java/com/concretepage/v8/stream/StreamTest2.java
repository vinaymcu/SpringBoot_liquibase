package com.concretepage.v8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("one", "two");
        Stream<String> b = Stream.of("three", "four");
        Stream<String> c = Stream.of("five", "six");

       // Stream<String> out= Stream.concat(Stream.concat(a, b), c);
       // out.forEach(System.out::println);

        Stream<String> out1 = Stream.of(a, b, c).flatMap(s -> s);
        //out1.forEach(System.out::println);
        Optional<String> any = out1.findFirst(); // infinite loop
        System.out.println(any); // ne

        //final List<Triple<a,b,c>>>>  feeParameters = new ArrayList<>();

        //final List<Triple<AA, AA, Map<String, List<AA>>>> feeParameters = new ArrayList<>();



    }

}

class AA{

}