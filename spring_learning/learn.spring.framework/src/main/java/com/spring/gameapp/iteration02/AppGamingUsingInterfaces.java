package com.spring.gameapp.iteration02;

import com.spring.gameapp.iteration02.game.GameRunner;
import com.spring.gameapp.iteration02.game.PacManGame;

public class AppGamingUsingInterfaces {

	public static void main(String[] args) {
		var game = new PacManGame();
		//var game = new SuperContraGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
