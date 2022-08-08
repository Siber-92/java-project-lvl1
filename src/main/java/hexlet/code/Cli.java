package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Cli {
    private static String playerName;

    public static String getPlayerInput() {
        Scanner playerInput = new Scanner(System.in);

        return playerInput.next();
    }

    public static void printGreet() {
        out.println("Welcome to the Brain Games!");
        out.print("May I have your name? ");
        playerName = getPlayerInput();
        out.println("Hello, " + playerName + "!");
    }

    public static String getPlayerName() {
        return playerName;
    }
}
