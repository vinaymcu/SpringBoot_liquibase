package com.concretepage.mongodb;

import com.concretepage.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainRepositoryCustomImp implements DomainRepositoryCustom{

   // @Autowired
   // MongoTemplate mongoTemplate;

    @Autowired
    DomainRepository domainRepository;


    @Override
    public int updateDomain(String domain, boolean displayAds) {

//        Query query = new Query(Criteria.where("domain").is(domain));
//        Update update = new Update();
//        update.set("displayAds", displayAds);
//
//        WriteResult result = mongoTemplate.updateFirst(query, update, Domain.class);
//
//        if(result!=null)
//            return result.getN();
//        else
//            return 0;

        return 0;

    }

    public  Domain getDomain(long id){
        System.out.println("getDomain :id:"+id);
         return domainRepository.findOne(id);
    }

    public List<Domain> getDomainList(){
        System.out.println("** getDomainList **");
                return domainRepository.findAll();
    }

    public Domain saveDomain(Domain domain){
        System.out.println("SAVE  Domain :"+domain.getId()+":DOMAIN:"+domain.getName());
       return domainRepository.save(domain);

    }

}
