package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Cli {
    private static String playerName;

    public static String getPlayerInput() {
        Scanner playerInput = new Scanner(System.in);

        return playerInput.next();
    }

    public static void printGamesList() {
        String[] games = {"Exit", "Greet", "Even"};

        out.println("Please enter the game number and press Enter");
        for (int i = 1; i < games.length; i++) {
            out.println(i + " - " + games[i]);
        }
        out.println("0 - Exit");
        out.print("Your choice: ");
    }

    public static void printGreet() {
        out.println("Welcome to the Brain Games!");
        out.print("May I have your name? ");
        playerName = getPlayerInput();
        out.println("Hello, " + playerName + "!");
    }

    public static void printGameResult(boolean win) {
        if (win) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
