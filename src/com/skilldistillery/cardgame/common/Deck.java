package com.skilldistillery.cardgame.common;

import java.util.ArrayList;
import java.util.Collections;

import com.skilldistillery.cardgame.blackjack.Hand;

public class Deck {
	private ArrayList<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		this.setDeckOfCards(deckOfCards);

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards.add(new Card(suit, rank));
			}
		}
	}

	public void resetDeck(Deck deck) {
		while (deck.deckOfCards.size() > 0) {
			deck.deckOfCards.remove(0);
		}

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards.add(new Card(suit, rank));
			}
		}
	}

	public ArrayList<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(ArrayList<Card> deckOfCards) {
		this.deckOfCards = deckOfCards;
	}

	public int checkDeckSize() {
		return deckOfCards.size();
	}

	public Card dealCard() {
		Card c = deckOfCards.remove(0);
		return c;
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
}
