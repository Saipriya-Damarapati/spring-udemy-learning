package com.spring.gameapp.iteration03.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacManGameQualifier")
public class PacManGame implements GamingConsole {

	public void up() {
		System.out.println("PacMan is going up");
	}

	public void down() {
		System.out.println("PacMan is going down");
	}

	public void left() {
		System.out.println("PacMan is going left");
	}

	public void right() {
		System.out.println("PacMan is going right");
	}
	
}
