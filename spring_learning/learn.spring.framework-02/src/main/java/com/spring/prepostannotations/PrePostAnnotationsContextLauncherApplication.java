package com.spring.prepostannotations;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("I am in constructor injection");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanUp() {
		this.someDependency = null;
		System.out.println("Cleanup is completed in someClass");
	}
}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("Initialization with dependency is done");
	}

	public void performCleanUp() {
		System.out.println("Cleanup is completed in someDependency");
		
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
