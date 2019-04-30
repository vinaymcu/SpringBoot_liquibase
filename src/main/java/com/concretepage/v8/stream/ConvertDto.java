package com.concretepage.v8.stream;

import com.concretepage.v8.util.Customer;
import com.concretepage.v8.util.CustomerDto;
import com.concretepage.v8.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;

public class ConvertDto {

    @Autowired
    private ModelMapper modelMapper;

    public static void main(String args[]){

       // ModelMapper modelMapper = new ModelMapper();

        List<Customer> custs= Util.getCustomers();

    }



}
