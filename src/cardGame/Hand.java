package cardGame;

import java.util.*;

/**
 * @author jordanmiller
 * Simulates a hand of Cards. 
 */
public class Hand {
	private final List<Card> pHand = new LinkedList<Card>();
	private int maxSize = 10;
	
	public Hand(int s) {
		assert s > 0;
		maxSize = s;
	}
	
	public Hand() {
		maxSize = 10;
	}
	
	public void add(Card aCard) {
		if (pHand.size() < maxSize) {
			pHand.add(aCard);
		}
	}
	
	public void remove(Card aCard) {
		pHand.remove(aCard);
	}
	
	public boolean contains(Card aCard) {
		return pHand.contains(aCard);
	}
	
	public boolean isEmpty() {
		return pHand.isEmpty();
	}
	
	public boolean isFull() {
		if (pHand.size() == maxSize) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return pHand.size();
	}
	
	/**
	 * Factory method for comparing hands based on number of cards in hand
	 * @return Comparator<Hand>
	 */
	public static Comparator<Hand> createSizeTotalComparator() {
		return new Comparator<Hand> ()
		{
			@Override
			public int compare(Hand hand1, Hand hand2) {
				return hand1.size() - hand2.size();
			}
		};
	}
	
	/**
	 * Factory method for comparing hands based on number of cards in hand of rank
	 * @pre rank != null
	 * @return Comparator<Hand>
	 */
	public static Comparator<Hand> createRankBasedComparator(Card.Rank rank) {
		assert rank != null;
		return new Comparator<Hand> ()
		{
			@Override
			public int compare(Hand hand1, Hand hand2) {
				int sumRank1 = 0;
				int sumRank2 = 0;
				for (Card pCard : hand1.pHand) {
					if (pCard.getaRank() == rank) sumRank1++;
				}
				for (Card pCard : hand2.pHand) {
					if (pCard.getaRank() == rank) sumRank2++;
				}
				return sumRank1 - sumRank2;
			}
		};
	}
	
	/**
	 * Factory method for comparing hands based on sum of all rank ordinals
	 * @return Comparator<Hand>
	 */
	public static Comparator<Hand> createRankTotalComparator() {
		return new Comparator<Hand> () 
		{
			@Override
			public int compare(Hand hand1, Hand hand2) {
				int sumHand1 = 0;				
				for (Card pCard : hand1.pHand) {
					sumHand1 += pCard.getaRank().ordinal();
				}
				int sumHand2 = 0;
				for (Card pCard : hand2.pHand) {
					sumHand2 += pCard.getaRank().ordinal();
				}
				return sumHand1 - sumHand2;
			}
		};
	}
	
	@Override
	public String toString() {
		String pAgg = "";
		for (Card pCard : pHand) {
			pAgg += (pCard.toString() + "\n");
		}
		return pAgg;
	}
}
