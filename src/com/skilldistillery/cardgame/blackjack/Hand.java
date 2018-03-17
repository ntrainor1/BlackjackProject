package com.skilldistillery.cardgame.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cardgame.common.Card;
import com.skilldistillery.cardgame.common.Deck;

public class Hand {
	List<Card> cardList = new ArrayList<Card>();
	
	public Hand() {
	}

	public void addCardToHand(Deck gameDeck) {
		cardList.add(gameDeck.dealCard());
	}
	
	public void emptyHand(Hand hand) {
		while (hand.cardList.size() > 0) {
			hand.cardList.remove(0);
		}
	}
	
	public int getValueHand() {
		int oldValue = 0;
		
		for (int i = 0; i < cardList.size(); i++) {
			oldValue = oldValue + cardList.get(i).getValue();
		}
		
		return oldValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" HAND:\t* ");
		for (Card card : cardList) {
			builder.append(card + " * ");
		}
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardList == null) ? 0 : cardList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cardList == null) {
			if (other.cardList != null)
				return false;
		}
		else if (!cardList.equals(other.cardList))
			return false;
		return true;
	}
}
