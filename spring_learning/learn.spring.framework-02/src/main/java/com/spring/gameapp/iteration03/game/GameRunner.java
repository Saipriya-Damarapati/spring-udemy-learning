package com.spring.gameapp.iteration03.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GamingConsole game;

	public GameRunner(@Qualifier("MarioGameQualifier") GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.left();
		game.down();
		game.right();
		game.up();
	}
}
