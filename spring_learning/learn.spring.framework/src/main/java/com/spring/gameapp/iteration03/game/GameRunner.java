package com.spring.gameapp.iteration03.game;

public class GameRunner {

	private GamingConsole game;

	public GameRunner(GamingConsole game) {
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
