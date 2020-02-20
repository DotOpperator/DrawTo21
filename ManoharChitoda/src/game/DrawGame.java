/**
	@author manoharchitoda
	@date February 16, 2020
 */
package game;
import java.io.IOException;
import java.util.Scanner;

public class DrawGame 
{
	public static int totalPlayers;	// total number of players
	static Scanner keyboard = new Scanner(System.in); //Stdio
	public static String players[]; // players

	public static void main(String[] args) throws IOException
	{
		//Greet & number of players
		welcome();
		// Initialize the list of players
		playerInit();
		// Initiate the game
		startGame();
	}

	/**
	 * Handles the whole game
	 * @throws IOException  System.in.read() throws this
	 */
	private static void startGame() throws IOException 
	{
		// A round consists of all the players drawing a card
		ScoreBoard scoreTracker = new ScoreBoard(totalPlayers, players);
		DeckOfCards deckOfCards = new DeckOfCards();
		Card cardsDrawn[] = new Card[totalPlayers]; 

		//Shuffle the deck
		deckOfCards.shuffle();

		int won = -1;
		int round = 1;

		while(won == -1)
		{
			int pen = 0;
			System.out.println("*******Start Round: " + round+"*******");

			//Ask player i to draw a card by pressing any key
			for (int i = 0; i < players.length; i++)
			{
				// Prompt for card to be picked
				System.out.println("Enter ENTER to draw a card "
						+ scoreTracker.playersInGame[i].getName()+": ");
				// Take ENTER as input
				System.in.read();

				// Draw the card
				cardsDrawn[i] = deckOfCards.deal();

				if(cardsDrawn[i] != null)
				{
					// Decrement points right way if penalty card is chosen
					if(Integer.parseInt(cardsDrawn[i].getFaceValue()) == -1){
						scoreTracker.updateScore(i,'d');pen++;}

					// Assign the chosen card to the player for evaluation
					scoreTracker.setCardDrawn(i,cardsDrawn[i]);
					System.out.println();
				}

				//Give a new deck if the deck is over before the game ends
				else {
					System.out.println("The deck has no more cards.");
					System.out.println("You are granted a new deck!");
					deckOfCards.setCurrentCard(0);
					deckOfCards.shuffle();
					i--;
				}
			}
			if(pen != totalPlayers)
			{
				// Grant 2 points to the person with the highest card
				scoreTracker.updateScore(scoreTracker.highestCard(),'i');
			}

			// Print the score board
			scoreTracker.printScore();

			// Check if anyone won at the end of this round
			won = scoreTracker.winCondition();
			System.out.println("*******End Round" + (round++) +"************\n");
		}

		// Congratulate the winner and end of game
		System.out.println("Congratulations " + 
				scoreTracker.playersInGame[won].getName() +
				"! You won!\n Game ended");
	}//end startGame

	/**
	 * Initialize the set with players
	 */
	private static void playerInit()
	{
		for(int i = 0; i < totalPlayers;)
		{
			//Prompt for player name
			System.out.print("ENTER NAME OF PLAYER "+(i+1)+": " );
			String str = keyboard.next();

			// Check for valid input
			if(str.length() > 0)
			{
				// Only accept upon valid input
				if(add(str.toUpperCase(), i))
					i++;
				else
				{
					System.out.println("Player Already Exist!");
					System.out.println("(Hint):Place a number" 
							+"with players of same name\n");
				}
			}
		}
		System.out.println();
	}// end of playerInit

	/**
	 *@param str is the name of the player
	 *@param addHere is the next available position
	 *@return true if added and false otherwise
	 * Add a player to the array upon checking if
	 * another player with the same name exists
	 */
	private static boolean add(String str, int addHere)
	{
		for (int i = 0; i < addHere; i++)
		{
			if(players[i].equals(str))
				return false;
		}

		players[addHere] = str;
		return true;
	}//end of add

	/**
	 *  Greet player and prompt for number of players
	 */
	private static void welcome()
	{
		// Greet the players
		System.out.println("WELCOME TO THE CARD GAME");
		System.out.println("   *** DRAW TO 21 ***");

		// Prompt for the number of players
		System.out.print("How many player?(2,3,or 4): ");
		String s = keyboard.next();

		if (Character.isDigit(s.charAt(0))){
			totalPlayers = Integer.parseInt(s);
		}else
			System.out.println("Invalid input! Please enter a number between 1 and 5");

		System.out.println();

		// Only accept valid inputs
		while(totalPlayers <= 1 || totalPlayers >= 5)
		{
			System.out.print("How many player?(2,3,or 4): ");
			s = keyboard.next();
			if (Character.isDigit(s.charAt(0))){
				totalPlayers = Integer.parseInt(s);
			}

			else
				System.out.println("Invalid input! Please "
						+"enter a number between 1 and 5\n");
		}

		players = new String[totalPlayers];
	}//end of welcome
}