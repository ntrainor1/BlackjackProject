package com.skilldistillery.cardgame.blackjack;

public enum Suit {
	HEARTS("hearts"), SPADES("spades"), CLUBS("clubs"), DIAMONDS("diamonds");

	private String name;

	private Suit(String input) {
		name = input;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
