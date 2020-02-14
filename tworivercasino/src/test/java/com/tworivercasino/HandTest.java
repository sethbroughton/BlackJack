package com.tworivercasino;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HandTest {
	
	@Test
	public void isBustedTest() {
		Hand myCards = new Hand();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card("C","15"));
		cards.add(new Card("S","5"));
		
		for(Card item : cards) {
			item.flipCard();
		}
		
		assertFalse(myCards.isBusted(cards));
		
		Card newCard = new Card("D","10");
		newCard.flipCard();
		cards.add(newCard);
		assertTrue(myCards.isBusted(cards));
		
	}

}
