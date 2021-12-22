import java.util.ArrayList;

/**
 * This class models a card home
 *
 */
public class CardHome {
    // colours for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private int sign;
    private int size;
    private ArrayList<Card> home;

    public CardHome(int sign){
        this.sign = sign;
        size = 0;
        home = new ArrayList<>();
    }

    public boolean completed(){
        return size == 13;
    }

    public boolean add(Card theCard){
        if (theCard.getNumber() == size + 1 && theCard.getSign() == sign){
            home.add(theCard);
            return true;
        }
        return false;
    }

    public String toString(){
        if (home.isEmpty()){
            return "x";
        }
        else {
            if (sign == 1){
                return home.get(size).getNumDisplay() + "♣";
            }
            else if (sign == 2){
                return home.get(size).getNumDisplay() + "♠";
            }
            else if (sign == 3){
                return ANSI_RED + home.get(size).getNumDisplay() + "♦" + ANSI_RESET;
            }
            else {
                return ANSI_RED + home.get(size).getNumDisplay() + "♥" + ANSI_RESET;
            }
        }
    }
}
