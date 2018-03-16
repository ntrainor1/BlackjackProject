package com.skilldistillery.cardgame.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cardgame.common.Card;
import com.skilldistillery.cardgame.common.Deck;

public class Hand {
	List<Card> hand = new ArrayList<Card>();
	
	public Hand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void addCardToHand(Deck gameDeck) {
		hand.add(gameDeck.dealCard());
	}
	
	public List<Card> readHand() {
		return hand;
	}
	
	public int getValueHand() {
		int oldValue = 0;
		
		for (int i = 0; i < hand.size(); i++) {
			oldValue = oldValue + hand.get(i).getValue();
		}
		
		return oldValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hand == null) ? 0 : hand.hashCode());
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
		if (hand == null) {
			if (other.hand != null)
				return false;
		}
		else if (!hand.equals(other.hand))
			return false;
		return true;
	}
}
