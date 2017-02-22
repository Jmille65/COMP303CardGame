package cardGame;
import java.util.*;

import cardGame.Card.Rank;
import cardGame.Card.Suit;

public class Deck implements Iterable<Card>{
	
	private final Stack<Card> aCards = new Stack<>();
	
	public Iterator<Card> iterator() {
		return aCards.iterator();
	}
	
	public Deck() {
	}
	
	public void addToDeck(Card pCard) {
		aCards.push(pCard);
	}
	
	public Card takeFromDeck() {
		assert !(aCards.empty());
		return aCards.pop();
	}
	
	public static Deck createFullDeck() {
		Deck pDeck =  new Deck();
		for  (Rank rank : Rank.values() ) {
			for (Suit suit : Suit.values() ) {
				pDeck.addToDeck(new Card(rank, suit));
			}
		}
		return pDeck;
	}
	
	@Override
	public String toString() {
		String pAggregate = "";
		
		for(Card pCard : aCards) {
			pAggregate = pAggregate + pCard.toString() + "\n";
		}
		
		return pAggregate;
	}
	
	public void shuffle() {
		Collections.shuffle(aCards);
	}
	
	public void sortByRank() {
		Collections.sort(aCards, Card.createRankFirstComparator());
	}
	
	public void sortBySuit() {
		Collections.sort(aCards, Card.createSuitFirstComparator());
	}
	
}
