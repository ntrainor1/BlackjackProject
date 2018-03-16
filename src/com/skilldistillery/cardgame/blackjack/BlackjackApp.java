package com.skilldistillery.cardgame.blackjack;

import com.skilldistillery.cardgame.common.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp cga = new BlackjackApp();
		cga.run();
	}
	
	private void run() {
		Deck newDeck = new Deck();
		Hand newHand = new Hand();
		
		newDeck.shuffle();
		
		System.out.println(newHand.getValueHand());
		System.out.println(newHand.toString());
		System.out.println();
		
		newHand.addCardToHand(newDeck);
		
		System.out.println(newHand.getValueHand());
		System.out.println(newHand.toString());
		
		newHand.addCardToHand(newDeck);
		
		System.out.println(newHand.getValueHand());
		System.out.println(newHand.toString());
	}

}
