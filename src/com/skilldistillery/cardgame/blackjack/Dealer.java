package com.skilldistillery.cardgame.blackjack;

import com.skilldistillery.cardgame.common.Deck;

public class Dealer implements Player {
	Hand dealerHand = new Hand();
	Deck gameDeck = new Deck();
	
	public Dealer(Hand dealerHand, Deck gameDeck) {
		super();
		this.dealerHand = dealerHand;
		this.gameDeck = gameDeck;
	}

	@Override
	public void hit(Hand playerHand, Deck gameDeck) {
		playerHand.addCardToHand(gameDeck);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dealerHand == null) ? 0 : dealerHand.hashCode());
		result = prime * result + ((gameDeck == null) ? 0 : gameDeck.hashCode());
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
		Dealer other = (Dealer) obj;
		if (dealerHand == null) {
			if (other.dealerHand != null)
				return false;
		}
		else if (!dealerHand.equals(other.dealerHand))
			return false;
		if (gameDeck == null) {
			if (other.gameDeck != null)
				return false;
		}
		else if (!gameDeck.equals(other.gameDeck))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer [dealerHand=");
		builder.append(dealerHand);
		builder.append(", gameDeck=");
		builder.append(gameDeck);
		builder.append("]");
		return builder.toString();
	}

}
