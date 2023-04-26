package com.spring.gameapp.iteration03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.gameapp.iteration03.game.GameRunner;

@Configuration
@ComponentScan("com.spring.gameapp.iteration03.game")
public class AppGamingUsingAnnotations {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(AppGamingUsingAnnotations.class)) {
			var gameRunner = context.getBean("gameRunner");
			((GameRunner) gameRunner).run();
		}
	}

}
