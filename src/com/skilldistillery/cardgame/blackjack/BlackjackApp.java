package com.skilldistillery.cardgame.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgame.common.Deck;

public class BlackjackApp {
	private int playerWins = 0;
	private int dealerWins = 0;

	public static void main(String[] args) {
		BlackjackApp cga = new BlackjackApp();
		cga.run();
	}

	private void run() {
		Hand dealerHand = new Hand();
		Hand humanHand = new Hand();
		Deck gameDeck = new Deck();
		Dealer dealer = new Dealer(dealerHand, gameDeck);
		HumanPlayer humanPlayer = new HumanPlayer(humanHand);
		Scanner kb = new Scanner(System.in);
		
		System.out.println("========================================");
		humanPlayer.hit(humanHand, gameDeck);
		humanPlayer.hit(humanHand, gameDeck);
		System.out.println("HUMAN STARTING" + humanPlayer.humanHand.toString());
		System.out.println("----------------------------------------");
		dealer.hit(dealerHand, gameDeck);
		System.out.println("DEALER STARTING" + dealer.dealerHand.toString());
		System.out.println("========================================");
		System.out.println();
		
		System.out.println("DO YOU WANT TO HIT OR STAY? (H/S)");
		char userAnswer = kb.next().toUpperCase().charAt(0);
		System.out.println();
		
		if (userAnswer == 'H') {
			System.out.println("========================================");
			humanPlayer.hit(humanHand, gameDeck);
			System.out.println("HUMAN STARTING" + humanPlayer.humanHand.toString());
			System.out.println("----------------------------------------");
			System.out.println("DEALER STARTING" + dealer.dealerHand.toString());
			System.out.println("========================================");
			System.out.println();
		}
		else if (userAnswer == 'S') {
			
			while (true) {
				System.out.println("========================================");
				dealer.hit(dealerHand, gameDeck);
				System.out.println("HUMAN STARTING" + humanPlayer.humanHand.toString());
				System.out.println("----------------------------------------");
				System.out.println("DEALER STARTING" + dealer.dealerHand.toString());
				System.out.println("========================================");
				System.out.println();
				
				if (dealer.dealerHand.getValueHand() > 21) {
					System.out.println("The dealer's hand exceeds 21 points and the player wins.");
					playerWins++;
					break;
				}
				
				if (dealer.dealerHand.getValueHand() > humanPlayer.humanHand.getValueHand()) {
					System.out.println("The dealer's hand exceeds the player's but does not exceed 21 points.");
					System.out.println("The dealer wins.");
					dealerWins++;
					break;
				}
				
				if (dealer.gameDeck.checkDeckSize() == 0) {
					System.out.println("The deck is empty and the game ends.");
					evaluateWinner();
					break;
				}
		}

		}

	}
	
	private void evaluateWinner() {
		if (dealerWins > playerWins) {
			System.out.println("The dealer beat the player with " + dealerWins + "wins!");
		}
		else if (dealerWins < playerWins) {
			System.out.println("The player beat the dealer with " + playerWins + "wins!");
		}
		else {
			System.out.println("Both the dealer and the player tied at " + dealerWins + "wins!");
		}
	}

}
