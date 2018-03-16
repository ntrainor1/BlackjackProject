package com.skilldistillery.cardgame.blackjack;

import com.skilldistillery.cardgame.common.Deck;

public interface Player {
	public void hit(Hand playerHand, Deck gameDeck);
}
