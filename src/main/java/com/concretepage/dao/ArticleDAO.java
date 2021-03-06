package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.concretepage.entity.Article;
import com.concretepage.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ArticleRepository articleRepository;
	

	@Override
	public Article getArticleById(long articleId) {
		//Long.parseLong(articleId);
		//long l=articleId;
		Article art=articleRepository.findOne(articleId);
		
		String query="select art.title,art.category from articles art where art.id = ?";
		
		
		
		return entityManager.find(Article.class, articleId);

	}

	@Override
	public Article getArticleById1(long articleId) {
		System.out.println("articleId **********************************");
		
			
		return articleRepository.findOne(articleId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList()
				.size();
		return count > 0 ? true : false;
	}

	
}
