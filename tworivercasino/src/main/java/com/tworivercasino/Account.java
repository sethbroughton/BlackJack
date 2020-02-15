package com.tworivercasino;
import java.util.Scanner;

public class Account {
	//private attributes

	private int accountBalance;
	
	//Constructor
	public Account() {
		accountBalance = 100;
	}
	
	public int getAccountBalance() {
		return accountBalance;
	}
	
	//method
	public void placeBet(int betAmount) {
		withdraw(betAmount);
	}
	
	public void winner() {
		deposit(Bet.getBet()*2);
	}
	
	public void withdraw(int amount) {
		accountBalance = getAccountBalance() - amount;
	}

	public void deposit(int amount) {
		accountBalance = getAccountBalance() + amount;
	}

}
