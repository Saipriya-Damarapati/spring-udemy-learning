package com.spring.gameapp.iteration01.game;

public class GameRunner {

	/*
	private MarioGame game;

	public GameRunner(MarioGame marioGame) {
		this.game = marioGame;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.left();
		game.down();
		game.right();
		game.up();
	}
	*/

	private SuperContraGame game;

	public GameRunner(SuperContraGame superContraGame) {
		this.game = superContraGame;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.left();
		game.down();
		game.right();
		game.up();
	}
}
