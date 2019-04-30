package com.concretepage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
//@EnableSwagger2
//@EnableCaching
//@EnableScheduling
public class MyApplication {  
	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);
	public static void main(String[] args) {
	    logger.info("*************************Test-MyApplication Started-info**********");

	    SpringApplication.run(MyApplication.class, args);
 // caching implenetation
	    //		new SpringApplicationBuilder().sources(MyApplication.class)
//				.profiles("app").run(args);
    }       
}            