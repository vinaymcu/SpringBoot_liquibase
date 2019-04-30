package com.concretepage.controller;


import com.concretepage.entity.Article;
import com.concretepage.exception.ArticleNotFoundException;
import com.concretepage.model.AppResponse;
import com.concretepage.model.ArticleModel;
import com.concretepage.model.Domain;
import com.concretepage.mongodb.DomainRepositoryCustom;
import com.concretepage.mongodb.Emp;
import com.concretepage.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController


@Controller
@RequestMapping("mongo")
public class MongoDBController {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBController.class);

    @Autowired
    private DomainRepositoryCustom dmRepositoryCustom;

    @PostMapping("save")
    @ResponseBody
    public ResponseEntity<AppResponse> saveDomain(@RequestBody Domain domain) {
        System.out.println("saveDomain Name " + domain.getName());

        Domain dom = new Domain();
        dom.setId(domain.getId());
        dom.setName(domain.getName());
        dom.setLoc(domain.getLoc());

        Domain domain1 = dmRepositoryCustom.saveDomain(dom);
        System.out.println("After Successfully save id is " + domain1.getId());

        AppResponse appResponse = new AppResponse();
        appResponse.setArticleId(domain1.getId());
        appResponse.setStatusCode(HttpStatus.OK.name());
        appResponse.setMessage("Create/Update Doamin is " + domain1.getId());

        return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

    }

    // Exception
    @GetMapping("get/{id}")
    public ResponseEntity<Domain> getDomainById(@PathVariable("id") long id) {
        System.out.println(" ID is "+id);

        Domain domain=dmRepositoryCustom.getDomain(id);

        if (domain == null) {
            logger.info("Doamin NotFoundException ");
            throw new ArticleNotFoundException("Domain is not found -");
        }
        return new ResponseEntity<>(domain, HttpStatus.OK);
    }



    @GetMapping("getall")
    public ResponseEntity<List<Domain>> getDomainAll() {

        System.out.println(" getDomainAll");
        List<Domain> list = dmRepositoryCustom.getDomainList();

        list.stream().forEach(dom->{
            System.out.println(dom.getId()+":>>>Name:"+dom.getName());
        });

        return new ResponseEntity<List<Domain>>(list, HttpStatus.OK);
    }

}
