package com.concretepage.v8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorIteration {

    public static void main(String[] args)
    {

        List<String> stringList = new ArrayList<String>();

        //stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");


        stringList.stream().forEach(s -> {
            System.out.println(s);
        });

        Optional<String> anyElement = stringList.stream().findAny();

        System.out.println(anyElement.get());
    }
}
