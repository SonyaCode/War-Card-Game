/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("----- TEST 1 -----");
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck deck1 = new Deck(ranks, suits, pointValues);
		System.out.println("Before dealing a card: ");
		System.out.println(deck1);
		System.out.println(deck1.isEmpty());
		System.out.println(deck1.size());
		System.out.println("After dealing all cards: ");
		deck1.deal();
		deck1.deal();
		deck1.deal();
		System.out.println(deck1);
		deck1.deal();
		deck1.deal();
		deck1.deal();
		System.out.println(deck1.size());
		System.out.println(deck1.isEmpty());
		System.out.println(deck1);

		System.out.println("----- TEST 2 -----");
		String[] ranks2 = {"jack", "queen", "king", "ace", "little joker", "big joker"};
		String[] suits2 = {"clubs", "diamonds", "hearts", "spades"};
		int[] pointValues2 = {11, 12, 13, 14, 15, 16};
		Deck deck2 = new Deck(ranks2, suits2, pointValues2);
		System.out.println("Before dealing a card: ");
		System.out.println(deck2);
		System.out.println(deck2.isEmpty());
		System.out.println(deck2.size());
		System.out.println("After dealing a card: ");
		deck2.deal();
		System.out.println(deck2.size());
		System.out.println(deck2);

		System.out.println("----- TEST 3 -----");
		String[] ranks3 = {"A", "B", "C"};
		String[] suits3 = {"Giraffes", "Lions"};
		int[] values3 = {2,1,6};
		Deck deck3 = new Deck(ranks3, suits3, values3);
		System.out.println(deck3);

	}
}