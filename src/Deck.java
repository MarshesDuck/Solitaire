import java.util.ArrayList;
import java.util.Collections;

/***
 * This class creates a deck of cards and shuffles it.
 *
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        // add cards to the deck.
        for (int sign = 1; sign <= 4 ; sign++) {
            for (int number = 1; number <= 13; number++) {
                deck.add(new Card(number,sign));
            }
        }
        Collections.shuffle(deck); // shuffle the deck of cards.
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card popCard(){
        return deck.remove(0);
    }
}
