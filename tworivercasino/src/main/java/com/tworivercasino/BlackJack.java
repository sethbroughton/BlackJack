package com.tworivercasino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {

	public Deck theDeck;
	public Account myAccount;

	public void setUpGame() {
		Deck theDeck = new Deck();
		this.theDeck = theDeck;
		theDeck.buildDeck();
		theDeck.shuffle();
		Account account = new Account();
		this.myAccount = account;
	}

	public void startPlaying() {

		List<Card> myHand = new ArrayList<Card>();
		List<Card> dealerHand = new ArrayList<Card>();
		
		Bet bet = new Bet();
		bet.setBet();
		
		myAccount.placeBet(bet.getBet());

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

		Strategy strat = new Strategy();

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
				String suggestion = strat.basic(myHand, dealerHand);
				System.out.println("H or S ?");
				System.out.println("Recommended: " + suggestion);

				Scanner input = new Scanner(System.in);
				String nextMove = input.nextLine();
				if (nextMove.toUpperCase().equals("H")) {
					Card nextCard = theDeck.deal();
					nextCard.flipCard();
					myHand.add(nextCard);
					if (Hand.getValue(myHand) > 21) {
						for (Card card : myHand) {
							System.out.print(card + " ");
						}
						System.out.println("Busted!!!");
						break;
					}
				} else {
					Hand.flip(dealerHand);
					System.out.print("Dealer's Hand: ");
					for (Card card : dealerHand) {
						System.out.print(card + ", ");
					}
					while (Hand.getValue(dealerHand) < 17) {
						Card dealCard = theDeck.deal();
						dealCard.flipCard();
						System.out.print(dealCard + ", ");
						dealerHand.add(dealCard);
					}
					int dealerTotal = Hand.getValue(dealerHand);
					int myTotal = Hand.getValue(myHand);

					System.out.println("\nDealer's Hand: " + dealerTotal);
					System.out.println("Your Hand: " + myTotal);
					String result = "";

					if (dealerTotal <= 21 && dealerTotal > myTotal) {
						result = "You Lose";
					} else if (dealerTotal <= 21 && dealerTotal == myTotal) {
						result = "Push";
						myAccount.deposit(bet.getBet());
					} else {
						result = "You Win";
						myAccount.winner();
					}
					System.out.println(result);
					System.out.println(String.format("Account Balance: %d", myAccount.getAccountBalance()));
					break;

				}

			}
		}
	}
}
