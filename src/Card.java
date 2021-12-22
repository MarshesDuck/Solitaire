/**
 * This class models a card
 *
 */

public class Card {
    private final int number; // the number on the card
    private final String numDisplay; // number on card formatted for printing.
    private final int sign; // 1 = clubs, 2 = spades, 3 = diamonds, 4 = hearts
    private final boolean colour; // true = black, false = red
    private boolean faceUp;// whether card is facing up or down.


    public Card (int number, int sign){
        this.number = number;
        if (this.number == 1){
            numDisplay = String.valueOf('A');
        }
        else if (this.number == 11){
            numDisplay = String.valueOf('J');
        }
        else if (this.number == 12){
            numDisplay = String.valueOf('Q');
        }
        else if (this.number == 13){
            numDisplay = String.valueOf('K');
        }

        else {
            numDisplay = String.valueOf(number);
        }

        this.sign = sign;
        this.faceUp = false;

        colour = sign == 1 || sign == 2;
    }

    // returns properly formatted card number
    public String getNumDisplay(){
        return numDisplay;
    }

    public int getNumber() {
        return number;
    }

    public int getSign() {
        return sign;
    }

    public boolean getColour() {
        return colour;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public String toString(){
        if (!faceUp){
            return "Hidden Card";
        }

        else if (sign == 1){ // clubs
            return getNumDisplay() + " of clubs";
        }
        else if (sign == 2) { // spades
            return getNumDisplay() + " of spades";
        }

        else if (sign == 3){ // diamonds
            return getNumDisplay() + " of diamonds";
        }
        else{ // hearts
            return getNumDisplay() + " of hearts";
        }
    }
}
