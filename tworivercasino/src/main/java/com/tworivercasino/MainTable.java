package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User player1 = new User();
		player1.setName();
		System.out.println("Let's start the Game! \n ");

		Deck theDeck = new Deck();
		theDeck.buildDeck();
		theDeck.shuffle();

		List<Card> myHand = new ArrayList<Card>();
		List<Card> dealerHand = new ArrayList<Card>();

		// Deal hands;
		Card playerCard1 = theDeck.deal();
		playerCard1.flipCard();
		myHand.add(playerCard1);

		Card dealerCard1 = theDeck.deal();
		dealerHand.add(dealerCard1);

		Card playerCard2 = theDeck.deal();
		playerCard2.flipCard();
		myHand.add(playerCard2);

		Card dealerCard2 = theDeck.deal();
		dealerCard2.flipCard();
		dealerHand.add(dealerCard2);

		System.out.print("Dealer Hand: ");
		for (Card card : dealerHand) {
			System.out.print(card + " ");
		}
		System.out.println();
		while (true) {
			System.out.print(player1.getName() + "'s hand: ");
			for (Card card : myHand) {
				System.out.print(card + " ");
			}
			System.out.println();
			System.out.println("H or S ?");
			Scanner input = new Scanner(System.in);
			String nextMove = input.nextLine();
			if (nextMove.toUpperCase().equals("H")) {
				Card nextCard = theDeck.deal();
				nextCard.flipCard();
				myHand.add(nextCard);
				if (isBusted(myHand)) {
					for (Card card : myHand) {
						System.out.print(card + " ");
					}
					System.out.println("Busted!!!");
					break;
				}	
			} 
			else {
				dealerCard1.flipCard();
				System.out.print("Dealer's Hand: ");
				for (Card card : dealerHand) {
					System.out.print(card + ", ");
				}
				while (getValue(dealerHand) < 17) {
					Card dealCard = theDeck.deal();
					dealCard.flipCard();
					System.out.print(dealCard + ", ");
					dealerHand.add(dealCard);
				}
				int dealerTotal = getValue(dealerHand);
				int myTotal = getValue(myHand);
				
				System.out.println("\nDealer's Hand: " + dealerTotal);
				System.out.println("Your Hand: " + myTotal);
				String result = (dealerTotal<=21 && dealerTotal>=myTotal) ? "You Lose" : "You Win";
				System.out.println(result);
				break;
			}
		}
	}

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

}
