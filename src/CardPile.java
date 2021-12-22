import java.util.ArrayList;

/**
 * This class represents the revolving stock of cards in Solitaire.
 *
 */

public class CardPile {
    // colours for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private int size = 0;
    private ArrayList<Card> queue1; // pile 1
    private ArrayList<Card> queue2; // pile 2 for cards already visited


    public CardPile(){
        queue1 = new ArrayList<Card>(); // initialize the queue.
        queue2 = new ArrayList<Card>(); // initialize queue 2.
    }

    public void addCard(Card theCard){
        queue1.add(theCard); // add the card to the queue.
        size++; // increment size
    }

    public void traverse() throws CardException{ // show the next card. if end of the pile, show nothing and reset the pile.
        if (queue1.isEmpty()){ // if queue 1 is empty
            if (queue2.isEmpty()){ // if queue 2 is empty
                throw new CardException("There are no more cards in the pile.");
            }
            queue1 = queue2; // reset queue 1;
            queue2 = new ArrayList<>(); // queue 2 is empty

            // set all cards in queue1 to face down.
            for (int i = 0; i < queue1.size(); i++) {
                queue1.get(i).setFaceUp(false);
            }
            throw new CardException("Reset the pile");
        }
        else {
            Card cardToReturn = queue1.remove(0); // remove the topmost item in the queue.
            cardToReturn.setFaceUp(true); // set card's face up
            queue2.add(cardToReturn); // add the element to the second pile.
        }
    }

    // peeks at the current card.
    public Card peek() {
        try {
            return queue2.get(queue2.size() - 1);
        } catch (IndexOutOfBoundsException e){
            return null; // returns null if the queue is currently empty
        }
    }

    // removes the current card.
    public Card remove(){
        try {
            return queue2.remove(queue2.size() - 1); // removes the last item on the second queue.
        } catch (IndexOutOfBoundsException e){
            return null; // returns null if there is nothing to remove from the pile.
        }
    }

    // returns queue1
    public ArrayList<Card> getQueue1(){
        return queue1;
    }

    // returns queue2
    public ArrayList<Card> getQueue2(){
        return queue2;
    }

    public String toString(){
        String str = "";
        if (queue1.isEmpty()){
            str += "x ";
        }
        else {
            str += "⌺";
        }

        str += " | ";

        if (queue2.isEmpty()){
            str += "x";
        }
        else {
            if (peek().getSign() == 1){
                str += peek().getNumDisplay() + "♣";
            }
            else if (peek().getSign() == 2){
                str += peek().getNumDisplay() + "♠";
            }
            else if (peek().getSign() == 3){
                str += ANSI_RED + peek().getNumDisplay() + "♦" + ANSI_RESET;
            }
            else {
                str += ANSI_RED + peek().getNumDisplay() + "♥" + ANSI_RESET;
            }
        }
        return str;
    }
}