/**
 * @author manoharchitoda
*/
package game;

public class Player
{
	private String name;
	private int score;
	private Card cardDrawn;
	
	/**
	 * 
	 * @param name the name of the player
	 */
	public Player(String name)
	{
		this.name = name;
		this.score = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * increment the score bye one
	 */
	public void increment()
	{
		this.score += 2;
	}
	
	/**
	 * decrement the score by one
	 */
	public void decrement()
	{
		if( this.score - 1 > 0)
			this.score--;
		else
			this.score = 0;
	}
	
	/**
	 * @param cardDrawn card to be assigned to the player 
	 */
	public void setCardDrawn(Card cardDrawn)
	{
		this.cardDrawn = cardDrawn;
	}
	
	/**
	 * 
	 * @return the player's card
	 */
	public Card getCardDrawn() {
		return this.cardDrawn;
	}
	
	@Override
	/**
	 * @return the info of the player
	 */
	public String toString()
	{
		return this.name + " :\t\t " + this.score;
	}
}
