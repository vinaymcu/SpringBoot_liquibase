package com.concretepage.v8.in;

import com.concretepage.exception.ArticleNotFoundException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.service.IArticleService;
import javax.inject.Inject;

@Aspect
@Component
public class ModifyFundConfigAspect {

	 @Before(value = "@annotation(modifyFundConfig)")
	  public void checkFundConfigStatus(ModifyFundConfig modifyFundConfig) {
	    
		 System.out.println("modifyFundConfig:"+modifyFundConfig.ignoreLockedFundConfig());

		 if(modifyFundConfig.ignoreLockedFundConfig()){
			 throw new ArticleNotFoundException(" Delete opration can not done  ");//System.out.println("Hello >> True");
		 }else{
			 System.out.println("Hello >>");
		 }
	  }
}

