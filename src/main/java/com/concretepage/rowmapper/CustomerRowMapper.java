package com.concretepage.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.concretepage.model.Customer;

public class CustomerRowMapper implements RowMapper < Customer > {
	private static final Logger logger = LoggerFactory.getLogger(CustomerRowMapper.class);
	 @Override
	 public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Customer cust = new Customer();
		 cust.setId(rs.getLong("id"));
		 cust.setFirstName(rs.getString("first_name"));
		 cust.setLastName(rs.getString("last_name"));
		
		 logger.info("Customer >>>>>>>"+cust); 
	  return cust;
	 }
	}