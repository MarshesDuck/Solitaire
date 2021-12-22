

public class Main {
    // colours for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static Solitaire game;

    public static void main(String[] args){
        game = new Solitaire();

        for (int i = 0; i < 51; i++){
            try {
                game.getPile().traverse();
                if (game.getPile().peek().getColour() == false){
                    //System.out.println(ANSI_RED + game.getPile().peek() + ANSI_RESET);
                }
                else {
                    //System.out.println(game.getPile().peek());
                }

            } catch (CardException e){
                //System.out.println(ANSI_CYAN + "reset pile\n" + ANSI_RESET);
            }
            System.out.println(game.toString());
        }
        //System.out.println(ANSI_CYAN + "You can't do that.\n" + ANSI_RESET);
    }
}
