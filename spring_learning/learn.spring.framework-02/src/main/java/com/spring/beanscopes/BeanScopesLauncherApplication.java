package com.spring.beanscopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	// this returns same instance each time
	// by default, spring returns same instance every time
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	// this returns different instance each time
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
	}
}

/* 
 * in addition to singleton and prototype, we have the below
 * 
 * Scopes applicable only for web-aware spring application context
 * 		Request - one object instance per single http request
 * 		Session - one object instance per single http session
 * 		Application - one object instance per web application runtime
 * 		Web Socket - one object per web socket instance
 */

/*
 * Java Singleton (GOF) vs Spring Singleton
 * -----------------------------------------
 * Spring Singleton - One object instance per Spring IOC container
 * Java Singleton (GOF) - One object instance per JVM
 */