package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Menu {
    private static final HashMap<String, String> GAMES = new HashMap<>();

    public static void generateGameList() {
        GAMES.put("1", "Greet");
        GAMES.put("2", "Even");
        GAMES.put("3", "Calculator");
        GAMES.put("4", "GCD");
        GAMES.put("5", "Progression");
        GAMES.put("6", "Prime");
    }

    public static void printGamesList() {
        generateGameList();
        out.println("Please enter the game number and press Enter");
        GAMES.forEach((numberOfGame, gameName) -> out.println(numberOfGame + " - " + gameName));
        out.println("0 - Exit");
        out.print("Your choice: ");
    }

    public static void selectGame() {
        printGamesList();
        String selectedGame = String.valueOf(new Scanner(System.in).next());
        out.println();

        switch (selectedGame) {
            case "1" -> Cli.printGreet();
            case "2" -> Even.startGame();
            case "3" -> Calculator.startGame();
            case "4" -> Gcd.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            default -> {
            }
        }
    }
}


