package com.concretepage.exception;

public class ArticleNotFoundException extends RuntimeException {

	 private static final long serialVersionUID = 1L;

	 public ArticleNotFoundException(String msg) {
	  super(msg);
	 }
	}