package com.concretepage.mongodb;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepository extends MongoRepository<Emp, String> {

    Emp findByFirstName(String firstName);

    List<Emp> findByLastName(String lastName);

}

