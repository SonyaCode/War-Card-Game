import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner {
        
   /**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"♠", "♥", "♦", "♣"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
      
      
   public static void main(String[] args)
   {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two 
        //Decks for each player 
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        beginningDeck.shuffle();
        System.out.println(beginningDeck);
        beginningDeck.shuffle();
        System.out.println(beginningDeck);

        // divide the deck of cards between the player and the computer
        ArrayList<Card> firstHalf = new ArrayList<Card>();
        ArrayList<Card> secondHalf = new ArrayList<Card>();

        int totalNumOfCards = beginningDeck.size();
        for (int i = 0; i < totalNumOfCards / 2; i++) {
            firstHalf.add(beginningDeck.deal());
            secondHalf.add(beginningDeck.deal());
        }
        Deck player = new Deck(firstHalf);
        Deck computer = new Deck(secondHalf);

        System.out.println("It's a war of cards");
        System.out.println("Deck sizes: " + player.size() + " (yours) v.s. " + computer.size() + " (computer's)");

        ArrayList<Card> cardsOnTable = new ArrayList<Card>();

        int rounds = 0;
        while (player.getLength() > 0 && computer.getLength() > 0) {
            System.out.println("Press 'ENTER' to fight another battle or 'S' to shuffle your deck!");
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            if (userInput.equals("")) {
                rounds++;
                cardsOnTable.clear();
                Card playerDrew = player.getCard();
                Card computerDrew = computer.getCard();
                putCardOnTable(cardsOnTable, player, playerDrew);
                putCardOnTable(cardsOnTable, computer, computerDrew);
                System.out.println("You drew a " + playerDrew);
                System.out.println("The computer drew a " + computerDrew);

                if (playerDrew.pointValue() > computerDrew.pointValue()) {
                    giveCardsToWinner(cardsOnTable, player);
                    System.out.println("You won 2 cards! Deck sizes: " + player.getLength() + " (yours) v.s. " + computer.getLength() + " (computer's)");
                    
                } else if (playerDrew.pointValue() < computerDrew.pointValue()) {
                    giveCardsToWinner(cardsOnTable, computer);
                    System.out.println("The computer won 2 cards! Deck sizes: " + player.getLength() + " (yours) v.s. " + computer.getLength() + " (computer's)");

                } else {
                    boolean notEnoughCard = false;
                    while (playerDrew.pointValue() == computerDrew.pointValue()) {
                        if (player.getLength() < 4 || computer.getLength() < 4) {
                            notEnoughCard = true;
                            break;
                        }

                        for (int i = 1; i <= 4; i++) {
                            playerDrew = player.getCard();
                            computerDrew = computer.getCard();
                            putCardOnTable(cardsOnTable, player, playerDrew);
                            putCardOnTable(cardsOnTable, computer, computerDrew);
                        }

                        System.out.println("Both players put down additional 3 cards.");
                        System.out.println("On the fourth card, you drew a " + playerDrew);
                        System.out.println("On the fourth card, the computer drew a " + computerDrew);

                        if (playerDrew.pointValue() > computerDrew.pointValue()) {
                            giveCardsToWinner(cardsOnTable, player);
                            System.out.println("You won 4 cards! Deck sizes: " + player.getLength() + " (yours) v.s. " + computer.getLength() + " (computer's)");

                        } else if (playerDrew.pointValue() < computerDrew.pointValue()) {
                            giveCardsToWinner(cardsOnTable, computer);
                            System.out.println("The computer won 4 cards! Deck sizes: " + player.getLength() + " (yours) v.s. " + computer.getLength() + " (computer's)");
                        }
                    }

                    if (notEnoughCard && computer.getLength() < 4) {
                        System.out.println("The computer does not have enough cards!");
                        break;
                    } else if (notEnoughCard && player.getLength() < 4) {
                        System.out.println("You don't have enough cards!");
                        break;
                    }
                    
                }
            } else if (userInput.equalsIgnoreCase("S")) {
                player.shuffle();
                System.out.println("You shuffled your cards!");
            }

            if (rounds % 26 == 0) {
                System.out.println("You've played " + rounds + " rounds. Want to quit early? (y/n)");
                String quit = scan.nextLine();
                if (quit.equals("y")) {
                    break;
                }
            }

        }

        if (player.getLength() > computer.getLength()) {
            System.out.println("Congrats! You win!");
        } else if (computer.getLength() > player.getLength()) {
            System.out.println("The computer win!");
        } else {
            System.out.println("It is a tie!");
        }

   }

   public static void putCardOnTable(ArrayList<Card> cardsOnTable, Deck deck, Card card) {
        cardsOnTable.add(card);
        deck.removeCard(card);
   }

   public static void giveCardsToWinner(ArrayList<Card> cardsOnTable, Deck winner) {
        for (Card card : cardsOnTable) {
            winner.addCard(card);
        }
   }
   
}