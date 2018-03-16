package com.skilldistillery.cardgame.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardGameApp {

	public static void main(String[] args) {
		CardGameApp cga = new CardGameApp();
		cga.run();
	}

	private void run() {
		Deck newDeck = new Deck();
		Scanner kb = new Scanner(System.in);

		newDeck.shuffle();

		while (true) {
			System.out.println("How many cards would you like?");
			int userChoice = 0;
			try {
				userChoice = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("That's not a number! Input a real, whole number next time!");
			}

			if (userChoice <= 52) {
				for (int i = 0; i < userChoice; i++) {
					System.out.println(newDeck.dealCard().toString());
				}
				System.out.println("Thanks for playing!");
				break;
			}
			else {
				System.out.println("There are only 52 cards in this deck, not " + userChoice + ".");
				System.out.println("Try again.");
			}
		}

		kb.close();

	}

}
