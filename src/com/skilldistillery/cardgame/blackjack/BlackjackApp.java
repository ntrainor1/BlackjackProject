package com.skilldistillery.cardgame.blackjack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	private String humanName = "";
	private int humanScore = 0;

	public static void main(String[] args) {
		BlackjackApp cga = new BlackjackApp();
		cga.playAgain();
	}

	private void playAgain() {
		System.out.print("Input your name:\t");
		humanName = kb.nextLine();
		dealer.gameDeck.shuffle();

		newRound();

		while (true) {
			System.out.println();
			System.out.println("Do you want to play again? (Y/N)");
			char playAgain = kb.next().toUpperCase().charAt(0);

			if (playAgain == 'Y') {
				gameDeck.resetDeck(gameDeck);
				dealerHand.emptyHand(dealerHand);
				humanHand.emptyHand(humanHand);
				setUp();
			}
			else if (playAgain == 'N') {
				System.out.println("Thanks for playing!");
				humanScore = playerWins;
				highScore(humanName, humanScore);
				break;
			}
			else {
				System.out.println("Input a correct answer.");
			}
		}
	}

	private void highScore(String playerName, int score) {
		int highScore = 0;

		FileReader fr;
		try {
			fr = new FileReader("blackjackhighscore.txt");
			BufferedReader br = new BufferedReader(fr);
			String[] readingHighScore = br.readLine().split(", ");

			highScore = Integer.parseInt(readingHighScore[1]);

			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (score > highScore) {
			try {
				PrintWriter fileout = new PrintWriter("blackjackhighscore.txt");
				fileout.println(playerName + ", " + score);
				fileout.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	private void setUp() {
		if (dealer.gameDeck.checkDeckSize() == 0) {
			evaluateDeck();
		}

		humanPlayer.hit(humanHand, gameDeck);
		if (dealer.gameDeck.checkDeckSize() == 0) {
			evaluateDeck();
		}

		humanPlayer.hit(humanHand, gameDeck);
		if (dealer.gameDeck.checkDeckSize() == 0) {
			evaluateDeck();
		}

		dealer.hit(dealerHand, gameDeck);
		if (dealer.gameDeck.checkDeckSize() == 0) {
			evaluateDeck();
		}

		showHands();

		if (humanPlayer.humanHand.getValueHand() == 21) {
			System.out.println("BLACKJACK!");
			System.out.println("The player's hand hits 21 points and wins!");

			playerWins++;
			dealerHand.emptyHand(dealerHand);
			humanHand.emptyHand(humanHand);
		}

	}

	private void newRound() {
		while (true) {
			setUp();

			if (dealer.gameDeck.checkDeckSize() == 0) {
				evaluateDeck();
				break;
			}

			System.out.println("DO YOU WANT TO HIT OR STAY? (H/S)");
			char userAnswer = kb.next().toUpperCase().charAt(0);
			System.out.println();

			if (userAnswer == 'H') {
				humanPlayer.hit(humanHand, gameDeck);
				showHands();

				if (humanPlayer.humanHand.getValueHand() > 21) {
					System.out.println(
							"The player's hand exceeds 21 points, but the dealer must draw until reaching 17 points.");

					while (true) {
						if (dealer.gameDeck.checkDeckSize() == 0) {
							evaluateDeck();
							break;
						}

						dealer.hit(dealerHand, gameDeck);
						showHands();

						if (dealer.dealerHand.getValueHand() > 21) {
							System.out.println("The dealer's hand also exceeds 21 points and no one wins.");
							dealerHand.emptyHand(dealerHand);
							humanHand.emptyHand(humanHand);
							break;
						}

						if (dealer.dealerHand.cardList.size() == 2 && dealer.dealerHand.getValueHand() == 21) {
							System.out.println("BLACKJACK!");
							System.out.println("The dealer's hand hits 21 points and wins!");
							dealerWins++;
							dealerHand.emptyHand(dealerHand);
							humanHand.emptyHand(humanHand);
							break;
						}

						if (dealer.dealerHand.getValueHand() >= 17
								&& dealer.dealerHand.getValueHand() > humanPlayer.humanHand.getValueHand()) {
							System.out.println("The dealer's hand exceeds the player's but does not exceed 21 points.");
							System.out.println("The dealer wins.");
							dealerWins++;
							dealerHand.emptyHand(dealerHand);
							humanHand.emptyHand(humanHand);
							break;
						}

						if (dealer.dealerHand.getValueHand() >= 17
								&& dealer.dealerHand.getValueHand() == humanPlayer.humanHand.getValueHand()) {
							System.out.println("The player and the dealer tie but do not exceed 21 points.");
							System.out.println("No one wins.");
							dealerHand.emptyHand(dealerHand);
							humanHand.emptyHand(humanHand);
							break;
						}

					}

				}

			}
			else if (userAnswer == 'S') {
				while (true) {
					if (dealer.gameDeck.checkDeckSize() == 0) {
						evaluateDeck();
						break;
					}

					dealer.hit(dealerHand, gameDeck);
					showHands();

					if (dealer.dealerHand.getValueHand() > 21) {
						System.out.println("The dealer's hand exceeds 21 points and the player wins.");
						playerWins++;
						dealerHand.emptyHand(dealerHand);
						humanHand.emptyHand(humanHand);
						break;
					}

					if (dealer.dealerHand.cardList.size() == 2 && dealer.dealerHand.getValueHand() == 21) {
						System.out.println("BLACKJACK!");
						System.out.println("The dealer's hand hits 21 points and wins!");
						dealerWins++;
						dealerHand.emptyHand(dealerHand);
						humanHand.emptyHand(humanHand);
						break;
					}

					if (dealer.dealerHand.getValueHand() > humanPlayer.humanHand.getValueHand()) {
						System.out.println("The dealer's hand exceeds the player's but does not exceed 21 points.");
						System.out.println("The dealer wins.");
						dealerWins++;
						dealerHand.emptyHand(dealerHand);
						humanHand.emptyHand(humanHand);
						break;
					}

					if (dealer.dealerHand.getValueHand() >= 17
							&& dealer.dealerHand.getValueHand() < humanPlayer.humanHand.getValueHand()) {
						System.out.println("The player's hand exceeds the dealer's but does not exceed 21 points.");
						System.out.println("The player wins.");
						playerWins++;
						dealerHand.emptyHand(dealerHand);
						humanHand.emptyHand(humanHand);
						break;
					}

				}

				break;

			}

		}

		System.out.println();
		System.out.println(" ~~~ NEW ROUND ~~~");
		System.out.println();
	}

	private void showHands() {
		System.out.println("========================================");
		System.out.println("HUMAN" + humanPlayer.humanHand.toString());
		System.out.println("HUMAN VALUE:\t" + humanPlayer.humanHand.getValueHand());
		System.out.println("----------------------------------------");
		System.out.println("DEALER" + dealer.dealerHand.toString());
		System.out.println("DEALER VALUE:\t" + dealer.dealerHand.getValueHand());
		System.out.println("========================================");
		System.out.println();
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
