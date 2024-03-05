/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("A", "diamond", 10);
		Card card2 = new Card("A", "diamond", 10);
		Card card3 = new Card("3", "clover", 1);

		System.out.println("----------------------------");
		System.out.println("Card 1's suit: " + card1.suit());
		System.out.println("Card 1's rank: " + card1.rank());
		System.out.println("Card 1's rank: " + card1.pointValue());
		System.out.println(card1);
		System.out.println("----------------------------");
		System.out.println("Card 3's suit: " + card3.suit());
		System.out.println("Card 3's rank: " + card3.rank());
		System.out.println("Card 3's rank: " + card3.pointValue());
		System.out.println(card3);
		System.out.println("----------------------------");
		System.out.println(card1.matches(card2));
		System.out.println(card1.matches(card3));
	}
}