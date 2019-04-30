package com.concretepage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.concretepage.entity.Article;

public class DBConnection {

	public static Article getDBConnection1() {

		Article article = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://vinaymysql.mysql.database.azure.com:3306/test";
			Connection myDbConn = DriverManager.getConnection(url, "vinayadmin@vinaymysql", "Vinay@2018");

			Statement stmt = myDbConn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from articles");

			while (rs.next())
				article = new Article();
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			article.setArticleId(100);
			article.setTitle("TEST");
			article.setCategory("TEST1222");
			
			myDbConn.close();
		} catch (Exception e) {

			System.out.println(e);
		}

		return article;
	}
	
	public static Article getDBConnection() {

		List<Article> articleList = new ArrayList<>();
		Article article = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://vinaymysql.mysql.database.azure.com:3306/test?useSSL=true&requireSSL=false";
			Connection myDbConn = DriverManager.getConnection(url, "vinayadmin@vinaymysql", "Vinay@2018");

			Statement stmt = myDbConn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from articles");

			while (rs.next())
				article = new Article();
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			article.setArticleId(rs.getInt(1));
			article.setTitle(rs.getString(2));
			article.setCategory(rs.getString(3));
			articleList.add(article);
			myDbConn.close();
		} catch (Exception e) {

			System.out.println(e);
		}

		return article;
	}

}
