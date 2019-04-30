package com.concretepage.v8.in;

import java.lang.reflect.Method;

public class MyTest {

	public static void main(String[] args) {

        AnnotationRunner runner = new AnnotationRunner();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
        	System.out.println("method >>"+method.getName());
            CanRun annos = method.getAnnotation(CanRun.class);
            System.out.println("annos >>"+annos);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
