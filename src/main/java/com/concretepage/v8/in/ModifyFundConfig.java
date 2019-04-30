package com.concretepage.v8.in;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ModifyFundConfig {
 
	boolean ignoreLockedFundConfig() default false;

 // boolean notUpdateFundConfigUpdatedDate() default false;
}


