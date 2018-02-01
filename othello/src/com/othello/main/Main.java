package com.othello.main;

import com.othello.service.GameService;

public class Main {

	public static void main(String[] args) throws Exception {
		
		GameService gameService = new GameService();
		gameService.start();
	}
}
