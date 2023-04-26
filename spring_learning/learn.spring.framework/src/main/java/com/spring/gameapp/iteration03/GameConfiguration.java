package com.spring.gameapp.iteration03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.gameapp.iteration03.game.GameRunner;
import com.spring.gameapp.iteration03.game.GamingConsole;
import com.spring.gameapp.iteration03.game.SuperContraGame;

@Configuration
public class GameConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new SuperContraGame();
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}

}
