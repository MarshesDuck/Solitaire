import java.util.Stack;
import java.util.*;

/***
 * This class represents a stack of cards in Solitaire.
 *
 */

public class CardStack {
    // colours for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private Stack<Card> stack = new Stack();
    private ArrayList<Card> cardList = new ArrayList<>();
    private int numCards = 0;

    public CardStack(int numInitialCards, Deck deck){
        for (int i = 0; i < numInitialCards; i++){
            Card card = deck.popCard();
            stack.push(card);
            cardList.add(card);
            numCards++;
        }
        stack.peek().setFaceUp(true); // set the last card on the stack to face up.
    }

    public Stack<Card> getCardStack() {
        return stack;
    }

    public int getNumCards(){
        return numCards;
    }

    public void addCard(Card theCard){
        Card card = theCard;
        stack.push(card);
        cardList.add(card);
        numCards++;
    }

    public Card removeCard()throws CardException{
        Card cardToRemove;
        try {
            cardToRemove = stack.pop();
        } catch (EmptyStackException e){
            throw new CardException("Stack is empty, cannot remove card");
        }

        cardList.remove(cardList.size() - 1);

        try {
            peekStack().setFaceUp(true); // flip over the next card in the stack.
        } catch (Exception ignored){}

        cardList.get(cardList.size() - 1).setFaceUp(true);
        numCards--;
        return cardToRemove;
    }

    public Card peekStack(){
        return stack.peek();
    }

    public ArrayList<String> stackRepresentation(){
        ArrayList<String> stringArray = new ArrayList<String>();
        for (int i = 0; i < cardList.size(); i++) {
            if (!cardList.get(i).isFaceUp()){
                stringArray.add("⌺");
            }
            else {
                if (cardList.get(i).getSign() == 1){
                    stringArray.add(cardList.get(i).getNumDisplay() + "♣");
                }
                else if (cardList.get(i).getSign() == 2){
                    stringArray.add(cardList.get(i).getNumDisplay() + "♠");
                }
                else if (cardList.get(i).getSign() == 3){
                    stringArray.add(ANSI_RED + cardList.get(i).getNumDisplay() +"♦" + ANSI_RESET);
                }
                else {
                    stringArray.add(ANSI_RED + cardList.get(i).getNumDisplay() + "♥" + ANSI_RESET);
                }
            }
        }
        return stringArray;
    }

    public String toString(){
        ArrayList<Card> listToReturn = cardList;
        Collections.reverse(listToReturn);
        return listToReturn.toString();
    }
}
