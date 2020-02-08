package com.tworiverscasino;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public static final int CARDS_IN_DECK = 52;
	private List<Card> listOfCards = new ArrayList<Card>();
	
	//constructor
	public Deck(){
	}
	
	//methods

	public void buildDeck() {

		String[] suits = {"H","D","S","C"};
		String[] ranks = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
		for(String suit : suits) {
			for(String rank : ranks) {
				Card currentCard = new Card();
				currentCard.setSuit(suit);
				currentCard.setRank(rank);
				listOfCards.add(currentCard);
			}			
		}
	}
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	

	
}
