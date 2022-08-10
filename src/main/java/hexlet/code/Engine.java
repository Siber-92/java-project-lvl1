package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    public static boolean checkQuizResult(String question, String correctAnswer) {
        out.println("Question: " + question);
        out.print("Your answer: ");
        String answer = String.valueOf(new Scanner(System.in).next());

        if (answer.equals(correctAnswer)) {
            out.println("Correct!");
            return true;
        }
        out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
        return false;
    }

    public static void printGameResult(boolean gameResult) {
        String playerName = Cli.getPlayerName();

        if (gameResult) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
