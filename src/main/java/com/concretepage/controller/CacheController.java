package com.concretepage.controller;

import com.concretepage.entity.Article;
import com.concretepage.model.Customer;
import com.concretepage.service.IMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cache")
public class CacheController {
    private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    IMapperService iMapperService;

    @GetMapping("gt")
    public ResponseEntity<Customer> getCacheArticles() {

        System.out.println(" getCacheArticles");
        Customer cust = iMapperService.getCustomerDetails();
        return new ResponseEntity<Customer>(cust, HttpStatus.OK);
    }
}
