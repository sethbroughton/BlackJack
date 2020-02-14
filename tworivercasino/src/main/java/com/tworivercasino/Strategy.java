package com.tworivercasino;

import java.util.List;

public class Strategy {
	
	public String basic(List<Card> player, List<Card> dealer) {
		
		//Always hit hard 11 or less.
		if (!Hand.isSoft(player) && Hand.getValue(player)<12) {
			return "Hit";
		}
	
		//Stand on hard 12 against a dealer 4-6, otherwise hit.
		if(!Hand.isSoft(player) && Hand.getValue(player) == 12 && (Hand.getValue(dealer)>=4 && Hand.getValue(dealer)<=6)) {
			return "Stand";
		}
		
		//Stand on hard 13-16 against a dealer 2-6, otherwise hit.
		if(!Hand.isSoft(player) && Hand.getValue(player) >=13 && Hand.getValue(player) <=16 && (Hand.getValue(dealer)>=2 && Hand.getValue(dealer)<=6)) {
			return "Stand";
		} 
		
		//Always stand on hard 17 or more
		if(!Hand.isSoft(player) && Hand.getValue(player)>=17) {
			return "Stand";
		}
		
		//Always hit soft 17 or less.
		if(Hand.isSoft(player) && Hand.getValue(player)<=17) {
			return "Hit";
		}
		
		//Stand on soft 18 except hit against a dealer 9, 10, or A.
		
		if(Hand.isSoft(player) && Hand.getValue(player)==18 && (Hand.getValue(dealer)==9 || Hand.getValue(dealer)==10|| Hand.isSoft(dealer))) {
			return "Hit";
		}
		if(Hand.isSoft(player) && Hand.getValue(player)==18) {
			return "Stand";
		}
		
		//Always stand on soft 19 or more.
		if(Hand.isSoft(player) && Hand.getValue(player)>=19) {
			return "Stand";
		} else {
		return "Hit";
		}
		
	}

}