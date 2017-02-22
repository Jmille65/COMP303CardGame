
package cardGame;
import java.util.*;

import cardGame.Card.Rank;

public class Client {
	public static void main(String[] pArgs) {
		Deck fullDeck = Deck.createFullDeck();
		fullDeck.shuffle();
		for(Card card : fullDeck) {
			System.out.println(card);
		}
		ArrayList<Hand> hands = new ArrayList<Hand>();
		
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		Hand hand3 = new Hand();
		
		for (int i = 0; i < 10; i++) {
			hand2.add(fullDeck.takeFromDeck());
		}
		
		for (int i = 0; i < 10; i++) {
			hand1.add(fullDeck.takeFromDeck());
		}
		
		for (int i = 0; i < 10; i++) {
			hand3.add(fullDeck.takeFromDeck());
		}
		
		
		
		hands.add(hand1);
		hands.add(hand2);
		hands.add(hand3);
		
		Collections.sort(hands, Hand.createRankBasedComparator(Rank.ACE));
		
		for (Hand aHand : hands) { // I love this, it automatically builds an iterator
			System.out.println(aHand.size() + " " + aHand.toString());
		}
	}
}
