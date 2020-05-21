# “Draw to 21”

Author: Manohar Chtioda

Language: Java 8
IDE used: Code Runner & Eclipse

This game allows 2 to 4 people to play the game where each player draws out a card from a
shuffled deck. The player with the highest card wins the round and earns 2 points. To win the
whole game, the first person to score 21 and win by 2 compared to other players. There are
also 4 penalty cards that decrease the points of the player who draws the penalty card by 1.

First the players are greeted to the game and then prompted to choose the number players
participating in the game: 2 to 4.

Upon choosing a valid number of players, then the players are asked to enter their name.

```
If a duplicate name is entered, the game will notify
the player and prompt again until a valid name is
entered.
```
```
(In the case of same name, the game hints to
associate numbers with names.)
```
After enter the names of the participants, the game begins with round 1 and prompts the first
player to enter any key to tell the game to draw a card from the deck.

```
(Player ALICE can enter any key and press the
enter key to initiate the drawing of the top card
from the deck.)
```

```
Once both players initiate a
draw from the deck, their cards
are displayed and the score of
the winner’s is incremented by
2.
```
```
Soon after the next round
begins and the game repeats.
```
If a player draws a penalty card their score is
decremented by one and the other winner’s
score is incremented.


```
The first person to reach 21 or
more and win by di ff erence of
2, is declared winner.
```
## THE GAME ENDS HERE.....

**_*Special case: When the deck of cards run out in the middle of the game, the deck is
renewed so the game can continue._**

Project structure:

  DrawToTwentyOne
  -bin
    -game
    -BINARIES OF .java Files
  -docs
    -Javadoc files/folders
  -README(This file)
  -src
    -game
      -Card.java
      -DeckOfCards.java
      -DrawGame.java
      -Player.java
      -ScoreBoard.java
