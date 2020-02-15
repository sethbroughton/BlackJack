package com.tworivercasino;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HandTest {

	// Happy Case
	@Test
	public void handTest() {
		Hand testHand = new Hand();
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new Card("C", "5");
		Card cardTwo = new Card("D", "5");
		cardOne.flipCard();
		cardTwo.flipCard();
		cards.add(cardOne);
		cards.add(cardTwo);

		assertEquals(10, testHand.getValue(cards));
	}

	@Test
	public void manyCards() {
		Hand testHand = new Hand();
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new Card("C", "5");
		Card cardTwo = new Card("D", "8");
		Card cardThree = new Card("D", "10");
		Card cardFour = new Card("D", "10");
		cardOne.flipCard();
		cardTwo.flipCard();
		cardThree.flipCard();
		cardFour.flipCard();
		cards.add(cardOne);
		cards.add(cardTwo);
		cards.add(cardThree);
		cards.add(cardFour);

		assertEquals(33, testHand.getValue(cards));
	}
	
	@Test
	public void withAceover21() {
		Hand testHand = new Hand();
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new Card("C", "5");
		Card cardTwo = new Card("D", "8");
		Card cardThree = new Card("D", "10");
		Card cardFour = new Card("D", "A");
		cardOne.flipCard();
		cardTwo.flipCard();
		cardThree.flipCard();
		cardFour.flipCard();
		cards.add(cardOne);
		cards.add(cardTwo);
		cards.add(cardThree);
		cards.add(cardFour);

		assertEquals(24, testHand.getValue(cards));
	}	
	
	@Test
	public void withAceUnder21() {
		Hand testHand = new Hand();
		List<Card> cards = new ArrayList<Card>();
		Card cardOne = new Card("C", "A");
		Card cardTwo = new Card("D", "8");
		Card cardThree = new Card("D", "10");
		Card cardFour = new Card("D", "A");
		cardOne.flipCard();
		cardTwo.flipCard();
		cardThree.flipCard();
		cardFour.flipCard();
		cards.add(cardOne);
		cards.add(cardTwo);
		cards.add(cardThree);
		cards.add(cardFour);

		assertEquals(20, testHand.getValue(cards));
	}
	
}
