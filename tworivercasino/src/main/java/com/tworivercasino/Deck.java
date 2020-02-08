package com.tworivercasino;

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
		String[] ranks = {"1","2","3","4","5","6","7","8","9","10","10","10","10"};
		for(String suit : suits) {
			for(String rank : ranks) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);
			}			
		}
	}
	
	//methods - what do the cards do?
	
	public void shuffle() {
		Collections.shuffle(listOfCards);
	}
	
	public Card deal() {
		if(listOfCards.size()!=0) {
			return listOfCards.remove(0);
		}
		else {
			return null;
		}
	}

}
