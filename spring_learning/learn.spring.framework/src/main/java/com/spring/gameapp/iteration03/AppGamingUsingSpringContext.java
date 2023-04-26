package com.spring.gameapp.iteration03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.gameapp.iteration03.game.GameConfiguration;
import com.spring.gameapp.iteration03.game.GameRunner;
import com.spring.gameapp.iteration03.game.GamingConsole;

public class AppGamingUsingSpringContext {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			var gameRunner = context.getBean("gameRunner");
			((GameRunner) gameRunner).run();
		}
	}

}
