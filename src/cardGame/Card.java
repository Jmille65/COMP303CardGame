package cardGame;
import java.util.*;

public class Card {
	
	public static Comparator<Card> createSuitFirstComparator() {
		return new Comparator<Card> () 
		{
			@Override
			public int compare(Card pCard1, Card pCard2) 
			{
				return pCard1.getaSuit().ordinal() - pCard2.getaSuit().ordinal();
			}
		};
	}
	
	public static Comparator<Card> createRankFirstComparator() {
		return new Comparator<Card> () 
		{
			@Override
			public int compare(Card pCard1, Card pCard2) 
			{
				return pCard1.getaRank().ordinal() - pCard2.getaRank().ordinal();
			}
		};
	}
	
	public enum Rank 
	{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING; 
	}
	
	public enum Suit 
	{ 
		HEARTS, DIAMONDS, CLUBS, SPADES;
	}
	
	public enum Colour
	{
		RED, BLACK;
	}
	private Rank aRank;
	private Suit aSuit;
	
	public Card(Rank pRank, Suit pSuit) {
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}

	public Rank getaRank() {
		return aRank;
	}

	public Suit getaSuit() {
		return aSuit;
	}
	
	public Colour getaColour() {
		if (aSuit == Suit.HEARTS || aSuit == Suit.DIAMONDS) {
			return Colour.RED;
		}
		else {
			return Colour.BLACK;
		}
	}
	
	@Override
	public String toString() {
		return aRank + " of " + aSuit;
	}
	
	public Card(Card pCard) {
		aRank = pCard.aRank;
		aSuit = pCard.aSuit;
	}
}
