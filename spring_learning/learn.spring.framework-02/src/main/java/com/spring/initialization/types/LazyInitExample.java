package com.spring.initialization.types;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// this component is initialized eagerly
class ClassA {
	
}

@Component
@Lazy // to make the initialization of this bean lazy, instead of eager
class ClassB {
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		// assume this has so much of initialization logic
		super();
		System.out.println("Some initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("doSomething");
	}
}

@Configuration
@ComponentScan
public class LazyInitExample {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LazyInitExample.class)) {
			System.out.println("Initialization of context is completed");
			System.out.println(context.getBean(ClassB.class));
			System.out.println("ClassB bean loading is completed");
		}
	}
}
