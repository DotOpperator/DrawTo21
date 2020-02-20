/**
@author manoharchitoda
 */
package game;

import java.util.HashSet;
import java.util.Random;

public class DeckOfCards
{
	private Card deck[];
	private final int NUMBER_OF_CARDS = 56;
	private int currentCard;
	private Random rand;

	public DeckOfCards()
	{
		//Instantiate necessary vars
		String faces[] = {"2","3","4","5","6",
				"7","8","9","10","11","12",
				"13","14"};

		String suit[] = {"4","3","2","1"};
		this.deck = new Card[NUMBER_OF_CARDS];
		this.rand = new Random();
		this.currentCard = 0;

		//Fill the deck with cards
		for (int i = 0; i < 52; i++) {
			this.deck[i] = new Card(faces[i%13],suit[i/13]);
		}

		//Fill the deck with penalty cards
		for (int i = 52; i < 56; i++) {
			this.deck[i] = new Card("-1","-1");
		}
	}

	/**
	 *@param c is the index of the card to move the current card to
	 */
	public void setCurrentCard(int c){
		this.currentCard = c;
	}

	//Shuffle the deck by swapping cards
	public void shuffle()
	{
		HashSet<Integer> usedRandoms = new HashSet<Integer>();
		this.currentCard = 0;
		int i= 0;
		while (i < deck.length)
		{
			int another = this.rand.nextInt(NUMBER_OF_CARDS);
			if(!usedRandoms.contains(another))
			{
				Card temp = this.deck[i];
				this.deck[i] = this.deck[another];
				this.deck[another] = temp;
				i++;
				usedRandoms.add(another);
			}
		}
	}

	//Deal a card
	public Card deal()
	{
		if(this.currentCard < deck.length){
			System.out.println(this.deck[this.currentCard]);
			return this.deck[this.currentCard++];
		}
		else
			return null;
	}
}
