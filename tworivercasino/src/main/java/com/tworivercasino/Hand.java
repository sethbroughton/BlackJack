package com.tworivercasino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	private int value;

	// setters

	// Constructor
	public Hand() {
		this.value = 0;
	}

	// methods

	public static int getValue(List<Card> hand) {
		//return max <= 21;
		int sum = 0;
		for (Card item : hand) {
			if (!item.getRank().equals("A")) {
				int value = Integer.parseInt(item.getRank());
				sum += value;
			}
		}
		for (Card item : hand) {
			if (item.getRank().equals("A")) {
				if((sum+11)>21) {
					sum++;
				} else {
					sum += 11;
				}
			}
		}
		return sum;
	}

	/*public void split(List<Card> hand) {
		// if(hand.get(0).equals(hand.get(1)) && hand.size() == 2) {
		User player2 = new User();
		Card secondCard = hand.get(1);
		hand.remove(secondCard);
		List<Card> newHand = new ArrayList<Card>();
		newHand.add(secondCard);
		return player2;
	}*/

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
