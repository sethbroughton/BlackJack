package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;

public class MainTable {

	public static void main(String[] args) {

		BlackJack game = new BlackJack();

		game.setUpGame();
		
		while (game.theDeck.getNumOfCards() > 100) {
			game.startPlaying();
		}
		
		System.out.print("Game Over");

	}

}
