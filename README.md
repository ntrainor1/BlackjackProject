# Blackjack Project

## Skill Distillery - Week 3

### Project Description

This program is designed to play games of blackjack with the user until the user decides to quit. A highscore .txt file also accompanies the program so that new players can see who is the leading blackjack player.

### Project Operation

This program begins by asking for the user's name before beginning a new game of blackjack. This is the name that will be scored into the blackjackhighscores.txt file if he/she is able to beat the high score.

The game begins in earnest as a new header saying "NEW ROUND" appears for each round of blackjack.

The newRound() method then evaluates and displays the player's and the dealer's hands to find blackjacks as well as who has the better score than the other and below 21. The dealer is also programmed to keep hitting cards until reaching at least 17 points, just as in proper blackjack.

Once the cards run out in the deck, the program runs its evaluateDeck() method and its evaluateWinner() method to see who won the most rounds of blackjack.

The program asks if the player wants to play again. If the player answers yes (the program looks at the first character of the answer for a response, i.e. if the player types in "yes," the program will still treat it as 'Y' or 'N' if the response is "no," an incorrect character will just cause the program to prompt the user again until a correct response is given), then a new game starts with reset scores. If the user answers no, then the program will say goodbye and evaluate whether the player's score beats out the high score, irrespective of whether the player actually beat the dealer. If the player did beat the high score, the player's username and score are displayed, broken off by a comma.

### Lessons Learned

- FileReader only works for files in the src folder, neither outside the src folder nor inside a given package.