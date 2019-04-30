package com.concretepage.v8.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    Util(){

    }
    public static List<Customer> getCustomers(){

        Customer e1 = new Customer(1,23,"Rick","Beethovan", Customer.Gender.MALE);
        Customer e2 = new Customer(2,13,"Martina","Hengis",Customer.Gender.MALE);
        Customer e3 = new Customer(3,43,"Ricky","Martin",Customer.Gender.MALE);
        Customer e4 = new Customer(4,26,"Jon","Lowman",Customer.Gender.MALE);
        Customer e5 = new Customer(5,19,"Cristine","Maria",Customer.Gender.MALE);
        Customer e6 = new Customer(6,15,"David","Feezor",Customer.Gender.MALE);
        Customer e7 = new Customer(7,68,"Melissa","Roy",Customer.Gender.MALE);
        Customer e8 = new Customer(8,79,"Alex","Gussin",Customer.Gender.MALE);
        Customer e9 = new Customer(9,15,"Neetu","Singh",Customer.Gender.MALE);
        Customer e10 = new Customer(10,45,"Naveen","Jain",Customer.Gender.MALE);

        List<Customer> custs = new ArrayList<>();
        custs.addAll(Arrays.asList(new Customer[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));

        return custs;
    }
}
