package com.skilldistillery.cardgame.common;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suits, Rank ranks) {
		this.suit = suits;
		this.rank = ranks;
	}

	public int getValue() {
		return rank.getValue();
	}

	public Suit getSuits() {
		return suit;
	}

	public Rank getRanks() {
		return rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		}
		else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		}
		else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}

}
