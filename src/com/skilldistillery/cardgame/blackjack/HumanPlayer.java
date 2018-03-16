package com.skilldistillery.cardgame.blackjack;

import com.skilldistillery.cardgame.common.Deck;

public class HumanPlayer implements Player {
	Hand humanHand = new Hand();
	
	public HumanPlayer(Hand humanHand) {
		this.humanHand = humanHand;
	}
	
	@Override
	public void hit(Hand playerHand, Deck gameDeck) {
		playerHand.addCardToHand(gameDeck);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((humanHand == null) ? 0 : humanHand.hashCode());
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
		HumanPlayer other = (HumanPlayer) obj;
		if (humanHand == null) {
			if (other.humanHand != null)
				return false;
		}
		else if (!humanHand.equals(other.humanHand))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HumanPlayer [humanHand=");
		builder.append(humanHand);
		builder.append("]");
		return builder.toString();
	}

}
