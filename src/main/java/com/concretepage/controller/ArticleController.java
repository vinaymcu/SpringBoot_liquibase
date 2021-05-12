package com.concretepage.controller;

import java.lang.reflect.Field;
import java.util.List;

import com.concretepage.ldap.Person;
import com.concretepage.ldap.PersonRepository;
import com.concretepage.mongodb.Emp;
import com.concretepage.mongodb.EmpRepository;
import com.concretepage.util.Compress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import com.concretepage.entity.Article;
import com.concretepage.exception.ArticleNotFoundException;
import com.concretepage.model.AppResponse;
import com.concretepage.model.ArticleModel;
import com.concretepage.repository.ArticleRepository;
import com.concretepage.service.IArticleService;
import com.concretepage.service.IMapperService;
import com.concretepage.util.DBConnection;
import com.concretepage.v8.in.ModifyFundConfig;
import com.concretepage.model.Customer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Controller
@RequestMapping("article")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private IArticleService articleService;

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	private IMapperService mapperService;

	@Autowired
	private PersonRepository repository;

	
	@PostMapping("save")
	@ResponseBody
	public ResponseEntity<AppResponse> saveArticle(@RequestBody ArticleModel article) {
		System.out.println("saveArticle Title " + article.getTitle());

		Article article2 = new Article();
		article2.setArticleId(article.getArticleId());
		article2.setCategory(article.getCategory());
		article2.setTitle(article.getTitle());

		Article art = articleService.saveArticle(article2);
		System.out.println("After Successfully save id is " + art.getArticleId());

		AppResponse appResponse = new AppResponse();
		appResponse.setArticleId(art.getArticleId());
		appResponse.setStatusCode(HttpStatus.OK.name());
		appResponse.setMessage("Create/Update Article is " + art.getArticleId());

		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

	}
	
	
	@PostMapping("save1")
	@ResponseBody
	public ResponseEntity<AppResponse> saveArticle1(@RequestBody ArticleModel article) {
		System.out.println("saveArticle Title1 " + article.getTitle());

		Article article2 = new Article();
		article2.setArticleId(article.getArticleId());
		article2.setCategory(article.getCategory());
		article2.setTitle(article.getTitle());

		
		Article art = articleService.saveArticle(article2);
		System.out.println("After Successfully save id is1 " + art.getArticleId());

		AppResponse appResponse = new AppResponse();
		appResponse.setArticleId(art.getArticleId());
		appResponse.setStatusCode(HttpStatus.OK.name());
		appResponse.setMessage("Create/Update Article is " + art.getArticleId());

		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

	}

	// using repository
	@GetMapping("getall")
	public ResponseEntity<List<Article>> getAllArticles1() {

		System.out.println(" getAllArticles11");
		List<Article> list = articleRepository.findAll();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	// Exception
	@GetMapping("get/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {

		logger.info(" Article ID : [{}]", id);

		Article article = articleService.getArticleById(id);

		if (article == null) {
			logger.info("ArticleNotFoundException ");
			throw new ArticleNotFoundException("Article is not found -");
		}
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

//	/@GetMapping("all")
	@RequestMapping(value = "all", produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ResponseEntity<List<Article>> getAllArticles() {

		logger.info(" getAllArticles :");
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	// entity manager
	@PostMapping("add")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {

		boolean flag = articleService.addArticle(article);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("update")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}


	@DeleteMapping("delete/em/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/**
	 * simple database connection
	 * 
	 * @return
	 */
	@GetMapping("tets/test")
	public ResponseEntity<Article> getArticletesttest1() {

		Article article = new Article();
		article.setArticleId(11);
		article.setTitle("TESTTITLE1");
		article.setCategory("TESTCATEROGY1");

		Article article1 = DBConnection.getDBConnection1();

		return new ResponseEntity<Article>(article1, HttpStatus.OK);
	}

	@GetMapping("test/get/{id}")
	public ResponseEntity<Article> getArticletestById(@PathVariable("id") Integer id) {

		Article article = new Article();
		article.setArticleId(1);
		article.setTitle("TESTTITLE");
		article.setCategory("TESTCATEROGY");
		Article article1 = DBConnection.getDBConnection();

		return new ResponseEntity<Article>(article1, HttpStatus.OK);
	}

	/**
	 * Row mapper for
	 * 
	 * @param fname
	 * @return
	 */
	@GetMapping("name/{name}")
	public ResponseEntity<Customer> getCustomerByFName(@PathVariable("name") String fname) {

		logger.info("fname>>>>>>>" + fname);
		Customer cust = mapperService.getCustomerDetails();
		logger.info("Customer >>>>>>>" + cust);

		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@ModifyFundConfig(ignoreLockedFundConfig=true)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
		System.out.println("deleteArticle>>>>>>>" + id);
		return articleRepository.findByArticleId(id).map(article -> {
			articleRepository.delete(article);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ArticleNotFoundException("Article " + id + " not found"));
	}

	@GetMapping("emp")
	public void getPersonDetails(){
		System.out.println("People empRepository:"+empRepository);



		//this.empRepository.deleteAll();

		// save a couple of customers
		this.empRepository.save(new Emp("Alice1", "Smith1","delhi"));
		this.empRepository.save(new Emp("Bob1", "Smith1","mumbai"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Emp emp : this.empRepository.findAll()) {
			System.out.println(emp);
		}
		System.out.println("---------------");
	}

	@GetMapping("compress")
	@Compress
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResponseEntity<List<Article>> getAllArticlesCom() {

		System.out.println(" getAllArticlesCom");
		List<Article> list = articleRepository.findAll();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

}
