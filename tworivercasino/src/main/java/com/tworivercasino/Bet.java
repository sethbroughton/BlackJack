package com.tworivercasino;

import java.util.Scanner;

public class Bet {

	private static int bet;
	
	public static int getBet() {
		return bet;
	}
	
	public void setBet() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please place a bet");
		String bet = input.nextLine();
		this.bet = Integer.parseInt(bet);
	}
	
	Bet(){
	}
	
	
}
