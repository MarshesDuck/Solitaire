import java.util.Scanner;

public class Main {
    // colours for console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static boolean flipPile = true;

    private static Solitaire game;

    private static String help(){
        /*
        Selecting a card:
        ex. 4c, 5s, 6d, Ah (4 of clubs, 5 of spades, 6 of diamonds, A of hearts).
        You can select: the topmost card on the stacks, the homes, or the pile.

        To move a card: enter in the card to be moved, and then enter the card at the destination.
        eg. to move 4c to the stack with topmost card 5d, enter: 4c 5d.

        press enter to flip through the pile.

        write "help" to view this prompt.

        write "quit" to exit the application.
         */

        return ("\nSelecting a card:\n" +
                "ex. 4c, 5s, 6d, Ah (4 of clubs, 5 of spades, 6 of diamonds, A of hearts).\n" +
                "You can select: the topmost card on the stacks, the homes, or the pile.\n" +
                "\n" +
                "To move a card: enter in the card to be moved, and then enter the card at the destination.\n" +
                "eg. to move 4c to the stack with topmost card 5d, enter: 4c 5d.\n" +
                "\n" +
                "press enter to flip through the pile.\n" +
                "\n" +
                "write \"help\" to view this prompt.\n" +
                "\n" +
                "write \"quit\" to exit the application.");
    }

    public static void main(String[] args){
        game = new Solitaire();
        System.out.println("-CONSOLE SOLITAIRE-\n marshes (c) 2021");
        System.out.println(ANSI_CYAN + "Enter 'help' to view game controls\n" + ANSI_RESET);
        System.out.println(game.toString());

        System.out.print("Enter command:");
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        // loop until user enters exit.
        while (!line.equalsIgnoreCase("exit")){

            if (line.equalsIgnoreCase("help")){
                flipPile = false; // do not flip the pile after ENTER is pressed to return to the game.
                System.out.println(flipPile);
                System.out.println(help());
                System.out.println(ANSI_CYAN + "\nPress ENTER to return to game." + ANSI_RESET);
                line = sc.nextLine();
                continue;
            }

            // user pressed ENTER, no arguments. Flip the pile
            if (flipPile && line.isEmpty()){
                try {
                    game.getPile().traverse();
                } catch (Exception ignored){}
            }

            // set flipPile to true, so that the pile can be flipped. Prompt for user command.
            flipPile = true;
            System.out.println("\n" + game.toString());
            System.out.print("Enter command:");
            line = sc.nextLine();
        }
    }
}
