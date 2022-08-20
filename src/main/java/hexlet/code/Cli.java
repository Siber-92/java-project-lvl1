package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Cli {
    public static void printGreet() {
        out.println("Welcome to the Brain Games!");
        out.print("May I have your name? ");
        String playerName = new Scanner(System.in).next();
        out.println("Hello, " + playerName + "!");
    }
}
