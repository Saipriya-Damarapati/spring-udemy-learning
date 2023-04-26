package com.spring.dependency.inj.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncher {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncher.class)) {
			var dataServiceImpl = context.getBean(DataService.class);
			System.out.println("Business Calculation Service implementing " + dataServiceImpl);
			System.out.println("Max value is " + context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
