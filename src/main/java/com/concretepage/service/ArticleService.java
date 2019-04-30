package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;
import com.concretepage.repository.ArticleRepository;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	private IArticleDAO articleDAO;
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		
		return obj;
	}

	@Override
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
			return false;
		} else {
			articleDAO.addArticle(article);
			return true;
		}
	}

	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}

	// Repository
	@Override
	public Article saveArticle(Article article) {
		
		Article art=articleRepository.save(article);
		System.out.println("ArticleId:>"+art.getArticleId()+":Category(:"+art.getCategory()+":Title:"+art.getTitle());
		
		return art;

	}
	public String getHello() {
		return "Hello";
	}
}
