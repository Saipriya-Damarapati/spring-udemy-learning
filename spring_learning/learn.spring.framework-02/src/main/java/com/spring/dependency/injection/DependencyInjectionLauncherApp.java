package com.spring.dependency.injection;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// Field injection happening using reflection
@Component
class YourBusinessClassFieldInjection {
	
	@Autowired
	Dependency1 dependency1;
	
	@Autowired
	Dependency2 dependency2;

	@Override
	public String toString() {
		return "Using [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
}

//Setter injection happening using reflection
@Component
class YourBusinessClassSetterInjection {
	
	Dependency1 dependency1;
	
	Dependency2 dependency2;
	
	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		this.dependency1 = dependency1;
	}

	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		this.dependency2 = dependency2;
	}

	@Override
	public String toString() {
		return "Using [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
}

// Constructor injection
@Component
class YourBusinessClassConstructorInjection {
	
	Dependency1 dependency1;
	
	Dependency2 dependency2;
	
//	@Autowired is not mandatory for a Constructor injection
	public YourBusinessClassConstructorInjection(Dependency1 dependency1, Dependency2 dependency2) {
		// Spring team recommends using constructor based injection as dependencies are automatically set when an object is created
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	@Override
	public String toString() {
		return "Using [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApp {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApp.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Field injection: " + context.getBean(YourBusinessClassFieldInjection.class));
			System.out.println("Setter injection: " + context.getBean(YourBusinessClassSetterInjection.class));
			System.out.println("Constructor injection: " + context.getBean(YourBusinessClassConstructorInjection.class));
		}
	}
}
