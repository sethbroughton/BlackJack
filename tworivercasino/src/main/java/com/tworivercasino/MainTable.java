package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTable {

	public static void main(String[] args) {

		User player1 = new User();

		System.out.println("Let's start the Game! \n ");
		GameHelper game = new GameHelper();
		Deck theShoe = game.startGame();

		// Deal hands;

		GamePlayer singleHand = new GamePlayer();
		singleHand.startHand(theShoe);
		List<Card> myHand = new ArrayList<Card>();
		List<Card> dealerHand = new ArrayList<Card>();

		Card playerCard1 = theShoe.deal();
		playerCard1.flipCard();
		myHand.remove(playerCard1);
		myHand.add(playerCard1);

		Card dealerCard1 = theShoe.deal();
		dealerHand.add(dealerCard1);
		myHand.remove(dealerCard1);

		Card playerCard2 = theShoe.deal();
		playerCard2.flipCard();
		myHand.add(playerCard2);

		Card dealerCard2 = theShoe.deal();
		dealerCard2.flipCard();
		dealerHand.add(dealerCard2);
		myHand.remove(dealerCard2);

		while (true) {
			System.out.print("Dealer Hand: ");
			for (Card card : dealerHand) {
				System.out.print(card + " ");
			}
			System.out.println();
			{
				for (Card card : myHand) {
					System.out.print(card + " ");
				}
				System.out.println();
				System.out.println("H or S ?");
				Scanner input = new Scanner(System.in);
				String nextMove = input.nextLine();
				if (nextMove.toUpperCase().equals("H")) {
					Card nextCard = theShoe.deal();
					nextCard.flipCard();
					myHand.add(nextCard);
					if (Hand.isBusted(myHand)) {
						for (Card card : myHand) {
							System.out.print(card + " ");
						}
						System.out.println("Busted!!!");
						break;
					}
				} else {
					dealerCard1.flipCard();
					System.out.print("Dealer's Hand: ");
					for (Card card : dealerHand) {
						System.out.print(card + ", ");
					}
					while (Hand.getValue(dealerHand) < 17) {
						Card dealCard = theShoe.deal();
						dealCard.flipCard();
						System.out.print(dealCard + ", ");
						dealerHand.add(dealCard);
					}
					int dealerTotal = Hand.getValue(dealerHand);
					int myTotal = Hand.getValue(myHand);

					System.out.println("\nDealer's Hand: " + dealerTotal);
					System.out.println("Your Hand: " + myTotal);
					String result = (dealerTotal <= 21 && dealerTotal >= myTotal) ? "You Lose" : "You Win";
					System.out.println(result);
					break;
				}
			}
		}

	}
}
