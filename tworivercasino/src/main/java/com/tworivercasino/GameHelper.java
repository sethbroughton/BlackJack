package com.tworivercasino;

public class GameHelper {
	
	public Deck startGame() {
	Deck theDeck = new Deck();
	theDeck.buildDeck();
	theDeck.shuffle();
	return theDeck;
	}
}
