/**
 * @author manoharchitoda
 */

package game;

public class ScoreBoard 
{
	public Player playersInGame[]; // information  of players
	public boolean reached_21 = false; //Flag for score of 21

	/**
	 * 
	 * @param totalPlayers total number of players
	 * @param plys array of players in the game
	 */
	public ScoreBoard(int totalPlayers, String plys[])
	{
		playersInGame = new Player[totalPlayers];
		for (int i = 0; i < playersInGame.length; i++)
			playersInGame[i] = new Player(plys[i]);
	}

	/**
	 * 
	 * @param i the index of the player to update score
	 * @param c if it equals 'i' then increment, otherwise decrement
	 */
	public void updateScore(int i, char c)
	{
		if(c == 'i')
			this.playersInGame[i].increment();
		else
			this.playersInGame[i].decrement();
	}

	/**
	 * print the score of the players
	 */
	public void printScore()
	{
		System.out.println("*------* Score Board *------*");
		System.out.println("Name\t\tScore");
		System.out.println("_______________________________");
		
		for (int i = 0; i < playersInGame.length; i++)
		{
			System.out.println(playersInGame[i]);
		}
		
	}

	/**
	 * @return Negative 1 if no one won or the index of the winner
	 */
	public int winCondition()
	{
		int max = 0;
		if(!reached_21) 
		{
			for (int i = 0; i < playersInGame.length; i++)
			{
				if(playersInGame[i].getScore() >= 21)
				{
					max = i;
					this.reached_21 = true;
					break;
				}
				else if(playersInGame[i].getScore() > playersInGame[max].getScore())
				{
					max = i;
				}
			}
		}
		
		//Execute when someone reached 21
		if(reached_21)
		{

			for (int i = 0; i < playersInGame.length; i++)
			{
				if(playersInGame[i].getScore() <= (playersInGame[max].getScore() -2))
					return max;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return the index of the player with the highest card
	 */
	public int highestCard()
	{
		int highestIndex = 0;
		Card highest = this.playersInGame[highestIndex].getCardDrawn();
		for (int i = 1; i < this.playersInGame.length; i++)
		{
			int fv = Integer.parseInt(this.playersInGame[i].getCardDrawn().getFaceValue());
			int su = Integer.parseInt(this.playersInGame[i].getCardDrawn().getSuit());
			
			if(su > (Integer.parseInt(highest.getSuit())))
			{
				highestIndex = i;
				highest = this.playersInGame[highestIndex].getCardDrawn();

			}
			
			else if(su == (Integer.parseInt(highest.getSuit())))
			{
				if(fv > (Integer.parseInt(highest.getFaceValue()))){
					highestIndex = i;
					highest = this.playersInGame[highestIndex].getCardDrawn();
				}
			}
		}
		return highestIndex;
	}

	/**
	 * 
	 * @param i the index of the player to assign card
	 * @param cardDrawn the card to assign
	 */
	public void setCardDrawn(int i, Card cardDrawn)
	{
		this.playersInGame[i].setCardDrawn(cardDrawn);
	}
}