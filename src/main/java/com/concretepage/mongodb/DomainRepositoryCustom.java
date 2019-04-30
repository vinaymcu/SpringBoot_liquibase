package com.concretepage.mongodb;

import com.concretepage.entity.Article;
import com.concretepage.model.Domain;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DomainRepositoryCustom {

    Domain getDomain(long id);
    List<Domain> getDomainList();
    Domain saveDomain(Domain article);


    int updateDomain(String domain, boolean displayAds);
}
