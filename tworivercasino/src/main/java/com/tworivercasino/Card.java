package com.tworivercasino;


public class Card {
	private String rank;
	private String suit;
	private boolean faceUp;
	
	//getter
	public String getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	
	//setters
	public void setRank(String rank) {
		this.rank = rank;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	//constructor
	public Card(){
		
	}
	
	//methods - flip card
	
	public void flipCard() {
		if(faceUp) {
			faceUp = false;
		}
		else {
			faceUp = true;
		}
	}
	
	
	
	
}
