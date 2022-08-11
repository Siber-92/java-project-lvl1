package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    private static final Scanner INPUT = new Scanner(System.in);
    private static String playerName;

    public static void printGreet(String rulesOfGame) {
        out.println("Welcome to the Brain Games!");
        out.print("May I have your name? ");
        playerName = INPUT.next();
        out.println("Hello, " + playerName + "!");
        out.println(rulesOfGame);
    }

    public static boolean checkQuizResult(String question, String correctAnswer) {
        out.println("Question: " + question);
        out.print("Your answer: ");
        String answer = INPUT.next();

        if (answer.equals(correctAnswer)) {
            out.println("Correct!");
            return true;
        }
        out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
        return false;
    }

    public static void printGameResult(boolean gameResult) {
        if (gameResult) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
