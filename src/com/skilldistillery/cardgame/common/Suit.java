package com.skilldistillery.cardgame.common;

public enum Suit {
	HEARTS("HEARTS"), SPADES("SPADES"), CLUBS("CLUBS"), DIAMONDS("DIAMONDS");

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
