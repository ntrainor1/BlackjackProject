package com.skilldistillery.cardgame.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgame.common.Deck;

public class BlackjackApp {
	private int playerWins = 0;
	private int dealerWins = 0;
	private Deck gameDeck = new Deck();
	private Hand dealerHand = new Hand();
	private Hand humanHand = new Hand();
	private Dealer dealer = new Dealer(dealerHand, gameDeck);
	private HumanPlayer humanPlayer = new HumanPlayer(humanHand);
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp cga = new BlackjackApp();
		cga.run();

		System.out.println("Do you want to play again?");
	}

	private void run() {
		System.out.println("========================================");
		humanPlayer.hit(humanHand, gameDeck);
		humanPlayer.hit(humanHand, gameDeck);
		System.out.println("HUMAN STARTING" + humanPlayer.humanHand.toString());
		System.out.println("HUMAN STARTING VALUE:\t" + humanPlayer.humanHand.getValueHand());
		System.out.println("----------------------------------------");
		dealer.hit(dealerHand, gameDeck);
		System.out.println("DEALER STARTING" + dealer.dealerHand.toString());
		System.out.println("DEALER STARTING VALUE:\t" + dealer.dealerHand.getValueHand());
		System.out.println("========================================");
		System.out.println();

		while (true) {
			System.out.println("DO YOU WANT TO HIT OR STAY? (H/S)");
			char userAnswer = kb.next().toUpperCase().charAt(0);
			System.out.println();

			if (userAnswer == 'H') {
				if (dealer.gameDeck.checkDeckSize() == 0) {
					evaluateDeck();
					break;
				}

				System.out.println("========================================");
				humanPlayer.hit(humanHand, gameDeck);
				System.out.println("HUMAN" + humanPlayer.humanHand.toString());
				System.out.println("HUMAN VALUE:\t" + humanPlayer.humanHand.getValueHand());
				System.out.println("----------------------------------------");
				System.out.println("DEALER" + dealer.dealerHand.toString());
				System.out.println("DEALER VALUE:\t" + dealer.dealerHand.getValueHand());
				System.out.println("========================================");
				System.out.println();

				if (humanPlayer.humanHand.getValueHand() > 21) {
					System.out.println("The player's hand exceeds 21 points and the dealer wins.");
					dealerWins++;
					dealerHand.emptyHand();
					humanHand.emptyHand();
				}
			}
			else if (userAnswer == 'S') {
				while (true) {
					if (dealer.gameDeck.checkDeckSize() == 0) {
						evaluateDeck();
						break;
					}

					System.out.println("========================================");
					dealer.hit(dealerHand, gameDeck);
					System.out.println("HUMAN" + humanPlayer.humanHand.toString());
					System.out.println("HUMAN VALUE:\t" + humanPlayer.humanHand.getValueHand());
					System.out.println("----------------------------------------");
					System.out.println("DEALER" + dealer.dealerHand.toString());
					System.out.println("DEALER VALUE:\t" + dealer.dealerHand.getValueHand());
					System.out.println("========================================");
					System.out.println();

					if (dealer.dealerHand.getValueHand() > 21) {
						System.out.println("The dealer's hand exceeds 21 points and the player wins.");
						playerWins++;
						dealerHand.emptyHand();
						humanHand.emptyHand();
						break;
					}

					if (dealer.dealerHand.getValueHand() > humanPlayer.humanHand.getValueHand()) {
						System.out.println("The dealer's hand exceeds the player's but does not exceed 21 points.");
						System.out.println("The dealer wins.");
						dealerWins++;
						dealerHand.emptyHand();
						humanHand.emptyHand();
						break;
					}

				}

			}

		}

	}

	private void evaluateDeck() {
		System.out.println("The deck is empty and the game ends.");
		evaluateWinner();
	}

	private void evaluateWinner() {
		if (dealerWins > playerWins) {
			System.out.println("The dealer beat the player with " + dealerWins + " wins!");
		}
		else if (dealerWins < playerWins) {
			System.out.println("The player beat the dealer with " + playerWins + " wins!");
		}
		else {
			System.out.println("Both the dealer and the player tied at " + dealerWins + " wins!");
		}
	}

}
