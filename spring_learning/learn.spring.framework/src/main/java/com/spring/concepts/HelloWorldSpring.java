package com.spring.concepts;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpring {

	public static void main(String[] args) {
		// Step 1 : Launch a Spring context
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
		
			// Step 2 : Configure the things that we want spring to manage - @Configuration
			// HelloWorldConfiguration - @Configuration
			// name - @Bean
			
			// Step 3 : Retrieving beans managed by Spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("person4Parameters"));
			System.out.println(context.getBean("person5Parameters"));
			System.out.println(context.getBean("address2"));
			//Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
			//No qualifying bean of type 'com.spring.concepts.Address' available: expected single matching bean
			//but found 2: address2,address3
			System.out.println(context.getBean(Address.class));
			//Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
			//No qualifying bean of type 'com.spring.concepts.Person' available: expected single matching bean 
			//but found 4: person,person2MethodCall,person3Parameters,person4Parameters
			System.out.println(context.getBean(Person.class));
			
			// List all the beans that are managed by spring context
			System.out.println("Number of beans in context : " + context.getBeanDefinitionCount());
			System.out.println("String array of beans in the context : " + context.getBeanDefinitionNames());
			// using functional programming
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
