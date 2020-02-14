package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private int value; 
	
	//getters
	public int getValue() {
		return this.value;
	}

	//setters
	
	//Constructor
	public Hand() {
		this.value = 0;
	}
	
	//methods
	//private List<Card> myHand = new ArrayList<Card>();
	
	public static boolean isBusted(List<Card> hand) {
		int sum = 0;
		for (Card item : hand) {
			int value = Integer.parseInt(item.getRank());
			sum += value;
		}
		return sum > 21;
	}
	
	public static int getValue(List<Card> hand) {
		int sum = 0;
		for (Card item : hand) {
			String rank = item.getRank();
			if(rank.equals("A")) {
				rank = "11"; 
			}
			int value = Integer.parseInt(rank);
			sum += value;
		}
		if(sum>21 && hand.contains("A")){
			sum -= 10;
		}
		return sum;
	}
	
	public User split(List<Card> hand) {
		//if(hand.get(0).equals(hand.get(1)) && hand.size() == 2) {
			User player2 = new User();
			Card secondCard = hand.get(1);
			hand.remove(secondCard);
			List<Card> newHand = new ArrayList<Card>();
			newHand.add(secondCard);
			return player2;
		}

	}
	


