import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solitaire {

    private CardHome clubsHome = new CardHome(1);
    private CardHome spadesHome = new CardHome(2);
    private CardHome diamondsHome = new CardHome(3);
    private CardHome heartsHome = new CardHome(4);

    private CardPile pile = new CardPile();
    
    // initialize array of cardStacks.
    private CardStack[] cardStacks = new CardStack[7];

    public Solitaire(){
        Deck deck = new Deck(); // generate random new deck of cards.
        dealCards(deck); // deal a solitaire.
    }

    private void dealCards(Deck deck){
        // initialize pile
        for (int i = 0; i < 24; i++) {
            pile.addCard(deck.popCard()); // add 24 cards to the pile.
        }

        // initialize stacks.
        for (int i = 0; i < 7; i++) {
            cardStacks[i] = new CardStack(i + 1, deck);
        }
    }

    public CardPile getPile() {
        return pile;
    }

    // moves a card from a stack to another stack.
    public void moveCardtoStack(int stackSource, int stackDestination){

    }

    // moves a card from the pile to a stack.
    public void moveCardtoStack(int stackDestination){

    }

    // moves a card from the home to a stack
    public void moveCardFromHome(int sign, int stackDestination){

    }

    // check if solitaire is completed
    public boolean done(){
        return clubsHome.completed() && spadesHome.completed() && diamondsHome.completed() && heartsHome.completed();
    }

    // moves a card to a home
    public void moveCardToHome(Card card, int sign){ // 1-clubs 2-spades 3-diamonds 4-hearts
       if (sign == 1){
           clubsHome.add(card);
       }
       else if (sign == 2){
            spadesHome.add(card);
        }
       else if (sign == 3){
           diamondsHome.add(card);
       }
       else if (sign == 4){
           heartsHome.add(card);
       }
       else {
           System.out.println("what do you even think you're doing");
       }
    }

    public String toString(){
        String str = " ";
        str += pile.toString();
        str += "        ";
        str += clubsHome.toString() + " ";
        str += spadesHome.toString() + " ";
        str += diamondsHome.toString() + " ";
        str += heartsHome.toString() + " ";
        str += "\n\n";
        str += stacksToString().toString();


        return str;
    }

    private String stacksToString() {
        String str = "";
        ArrayList<String[]> allStacks = new ArrayList<>(7);

//        //stack1
//        ArrayList<String> stringStack1 = stack1.stackRepresentation();
//        allStacks.add(0, stringStack1.toArray(new String[0]));
//
//
//        //stack2
//        ArrayList<String> stringStack2 = stack2.stackRepresentation();
//        allStacks.add(1, stringStack2.toArray(new String[0]));
//
//        //stack3
//        ArrayList<String> stringStack3 = stack3.stackRepresentation();
//        allStacks.add(2, stringStack3.toArray(new String[0]));
//
//        //stack4
//        ArrayList<String> stringStack4 = stack4.stackRepresentation();
//        allStacks.add(3, stringStack4.toArray(new String[0]));
//
//        //stack5
//        ArrayList<String> stringStack5 = stack5.stackRepresentation();
//        allStacks.add(4, stringStack5.toArray(new String[0]));
//
//        //stack6
//        ArrayList<String> stringStack6 = stack6.stackRepresentation();
//        allStacks.add(5, stringStack6.toArray(new String[0]));
//
//        //stack7
//        ArrayList<String> stringStack7 = stack7.stackRepresentation();
//        allStacks.add(6, stringStack7.toArray(new String[0]));

        for (int i = 0; i < 7; i++) {
            ArrayList<String> stringStack = cardStacks[i].stackRepresentation();
            allStacks.add(i, stringStack.toArray(new String[0]));
        }


        ArrayList<ArrayList<String>> verticalStacks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            verticalStacks.add(i,new ArrayList<>());
            for (int j = 0; j < largestPile(); j++) {
                try {
                    verticalStacks.get(i).add(j, allStacks.get(i)[j]);
                } catch (Exception e){
                    verticalStacks.get(i).add(j, " ");
                }
            }
        }


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < largestPile(); j++) {
                // each number gets 5 padding
                // single digit numbers
                if (!verticalStacks.get(j).get(i).toString().contains("10") && !verticalStacks.get(j).get(i).toString().contains("11") &&
                        !verticalStacks.get(j).get(i).toString().contains("12") && !verticalStacks.get(j).get(i).toString().contains("13")){
                    str += "  " + verticalStacks.get(j).get(i).toString(); // 2 padding
                }
                // hidden card
                else if (verticalStacks.get(j).get(i).equals("⌺") || verticalStacks.get(j).get(i).equals(" ")){
                    str += "   " + verticalStacks.get(j).get(i).toString(); // 3 padding
                }
                // double digit numbers
                else {
                    str += " " + verticalStacks.get(j).get(i).toString(); // 4 padding
                }
            }
            str += "\n";
        }

        return str;
    }

    private int largestPile(){
        ArrayList<Integer> sizeArray = new ArrayList<>();
//        sizeArray.add(stack1.getNumCards());
//        sizeArray.add(stack2.getNumCards());
//        sizeArray.add(stack3.getNumCards());
//        sizeArray.add(stack4.getNumCards());
//        sizeArray.add(stack5.getNumCards());
//        sizeArray.add(stack6.getNumCards());
//        sizeArray.add(stack7.getNumCards());

        for (int i = 0; i < 7; i++) {
            sizeArray.add(cardStacks[i].getNumCards());
        }
        Collections.sort(sizeArray);

        return sizeArray.get(sizeArray.size() - 1);
    }
}
