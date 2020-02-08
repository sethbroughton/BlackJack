package com.tworivercasino;
import java.util.Scanner;

public class User {
	//private attributes
	private String name;
	private int handValue;
	
	//getters
	public String getName() {
		return name;
	}
	public int getHandValue() {
		return handValue;
	}
	
	//setters;
	public void setName() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your name:");
		String name = input.nextLine();
		this.name = name;
	}
	
	public void setHandValue(int sum) {
		this.handValue = sum;
	}
	
	//Constructor
	public User() {
		
	}
	
	//methods
	
	public void hit() {

	}

}
