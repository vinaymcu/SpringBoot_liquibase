package com.concretepage.mongodb;

import com.concretepage.model.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainRepository  extends MongoRepository<Domain, Long> {


}
