package com.concretepage.v8.stream;

import com.concretepage.v8.util.Customer;
import com.concretepage.v8.util.Util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ST1 {
    public static void main(String[] args) {
        List<Customer> custs= Util.getCustomers();
        custs.stream().forEach(c->{
           // System.out.println("Without Sorted:"+c.toString());
        });

        // sorted data
        List<Customer> slist = custs.stream().sorted(Comparator.comparing(Customer::getFirstName)).collect(Collectors.toList());
        slist.stream().forEach(c->{
           // System.out.println("sorted:"+c.getFirstName());
        });

        //filter data
        List<Customer> flist = custs.stream().filter(p->p.getAge()>20).collect(Collectors.toList());
        flist.stream().forEach(c->{
            //System.out.println("filter:"+c.getFirstName()+":AGE:"+c.getAge());
        });

        // map


        //find any
        Customer cust1=
                custs.stream().filter(c->c.getFirstName()
                        .equalsIgnoreCase("Jon")).
                        findAny().orElse(null);

        System.out.println("COUNT::"+custs.stream().count());
        List<Customer> cList=custs.stream().filter(p->p.getAge()>20).collect(Collectors.toList());

        cList.stream().forEach(a->{
            System.out.println("a:>>"+a.getId()+"------"+a.getAge());
        });

        System.out.println(cust1.toString());
//
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double resultd = list.stream().collect(Collectors.averagingInt(v->v/4));
        //System.out.println("Average: "+result);

        List<String> jlist = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        String result=null;
        LocalDate localDate= LocalDate.of(2008,07,04);
        LocalDate localDate1= LocalDate.of(2008,07,04);
        if(localDate.equals(localDate1)){
            System.out.println("OK");
        }

        // String jresult=  jlist.stream().collect(Collectors.joining());

        System.out.println(localDate);//2008-07-04
      //  result=  jlist.stream().collect(Collectors.joining(","));
      //  System.out.println(result);

    }
}
