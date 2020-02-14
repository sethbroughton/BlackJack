package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private int value;

	// setters

	// Constructor
	public Hand() {
		this.value = 0;
	}

	// methods

	public static boolean isBusted(List<Card> hand) {
		return getValue(hand) > 21; 
	}

	public static int getValue(List<Card> hand) {
		int sum = 0;
		boolean containsA = false;
		for (Card item : hand) {
			String rank = item.getRank();
			if (rank.equals("A")) {
				sum = sum + 11;
				containsA = true;
			} else {
				int value = Integer.parseInt(rank);
				sum = sum + value;
			}
			if (sum > 21 && containsA) {
				sum = sum - 10;
			}
		}
		return sum;
	}

	public User split(List<Card> hand) {
		// if(hand.get(0).equals(hand.get(1)) && hand.size() == 2) {
		User player2 = new User();
		Card secondCard = hand.get(1);
		hand.remove(secondCard);
		List<Card> newHand = new ArrayList<Card>();
		newHand.add(secondCard);
		return player2;
	}

	public static boolean isSoft(List<Card> hand) {
		for (Card item : hand) {
			if (item.isFaceUp() && item.getRank().equals("A")) {
				return true;
			}
		}
		return false;
	}

	public static void flip(List<Card> hand) {
		for (Card item : hand) {
			if (!item.isFaceUp()) {
				item.flipCard();
			}
		}

	}
}
