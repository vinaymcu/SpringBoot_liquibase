package com.concretepage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.concretepage.model.Customer;

@Service
public class MapperService2 implements IMapperService{

	private static final Logger logger = LoggerFactory.getLogger(MapperService2.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Customer getCustomerDetails() {
		System.out.println(" ** getCustomerDetails **");
		Customer customer	=new Customer();
		customer.setFirstName("aa");
		return customer;
		}
}	
	

