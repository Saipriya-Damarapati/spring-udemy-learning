package com.spring.gameapp.iteration03;

import com.spring.gameapp.iteration03.game.GameRunner;
import com.spring.gameapp.iteration03.game.PacManGame;

public class AppGamingUsingInterfaces {

	public static void main(String[] args) {
		// Step 1: object creation
		var game = new PacManGame();
		// Step 2: object creation + wiring of dependencies
		// game is a dependency to create gameRunner
		// game object is created and then it is injected into GameRunner
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
