package com.skilldistillery.cardgame.blackjack;

import com.skilldistillery.cardgame.common.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp cga = new BlackjackApp();
		cga.run();
	}
	
	private void run() {
		Hand dealerHand = new Hand();
		Deck gameDeck = new Deck();
		Dealer dealer = new Dealer(dealerHand, gameDeck);
		
		while (true) {
			System.out.println("The dealer hits.");
			dealer.hit(dealerHand, gameDeck);
			System.out.println("DEALER" + dealer.dealerHand.toString());
			System.out.println("DEALER VALUE:\t* " + dealer.dealerHand.getValueHand() + " *");
			System.out.println();
			
			if (dealer.dealerHand.getValueHand() > 21) {
				System.out.println("The dealer's hand exceeds 21 points and the player wins.");
				break;
			}
			
			if (dealer.gameDeck.checkDeckSize() == 0) {
				System.out.println("The deck is empty and the game ends.");
				break;
			}
		}
		
	}

}
