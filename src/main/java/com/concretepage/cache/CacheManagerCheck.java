//
//package com.concretepage.cache;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.cache.CacheManager;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CacheManagerCheck {
//		//implements CommandLineRunner {
//
//	private static final Log logger = LogFactory.getLog(CacheManagerCheck.class);
//
//	private final CacheManager cacheManager;
//
//	public CacheManagerCheck(CacheManager cacheManager) {
//		this.cacheManager = cacheManager;
//	}
//
//	@Override
//	public void run(String... strings) throws Exception {
//		logger.info("\n\n" + "=========================================================\n"
//				+ "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
//				+ "=========================================================\n\n");
//	}
//
//}
