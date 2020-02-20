
// Author: Manohar Chitoda 
package game;
public class Card 
{
	// Instance variables
	private String faceValue;
	private String suit;

	//Constructor to instantiate
	public Card(String faceValue, String suit)
	{
		this.faceValue = faceValue;
		this.suit = suit;
	}


	/**
	 * @return the faceValue
	 */
	public String getFaceValue() {
		return faceValue;
	}


	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}


	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}


	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}


	@Override
	public String toString()
	{
		String cardToPrint = "";
		switch (this.faceValue) {
		case "11":
			cardToPrint += "Jack";
			break;
		case "12":
			cardToPrint += "Queen";
			break;
		case "13":
			cardToPrint += "King";
			break;
		case "14":
			cardToPrint += "Ace";
			break;
		case "-1":
			cardToPrint += "PENALTY";
			break;
		default:
			cardToPrint += this.faceValue;
			break;
		}
		cardToPrint += " of ";
		switch (this.suit) {
		case "4":
			cardToPrint += "Spades";
			break;
		case "3":
			cardToPrint += "Heart";
			break;
		case "2":
			cardToPrint += "Diamonds";
			break;
		case "1":
			cardToPrint += "Clubs";
			break;
		case "-1":
			cardToPrint += "MINUS ONE";
			break;
		}	

		return cardToPrint;
	}
}