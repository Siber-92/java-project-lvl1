package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    private static String playerName;
    private static final int MAX_NUMBER_OF_ROUND = 3;
    private static int countOfRightAnswer = 0;

    public static void printGreet(String rulesOfGame) {
        out.println("Welcome to the Brain Games!");
        out.print("May I have your name? ");
        playerName = new Scanner(System.in).next();
        out.println("Hello, " + playerName + "!");
        out.println(rulesOfGame);
    }

    public static boolean checkQuizResult(String question, String correctAnswer) {
        out.println("Question: " + question);
        out.print("Your answer: ");
        String answer = new Scanner(System.in).next();

        if (answer.equals(correctAnswer)) {
            out.println("Correct!");
            return true;
        }
        out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
        return false;
    }

    public static void gameLoop() {
        HashMap<String, String> gameData = new HashMap<>();
        String selectedGame = Menu.getSelectedGame();
        String question;
        String correctAnswer;
        boolean quizResult;
        do {
            switch (selectedGame) {
                case "2" -> gameData.putAll(Even.getGameData());
                case "3" -> gameData.putAll(Calculator.getGameData());
                case "4" -> gameData.putAll(Gcd.getGameData());
                case "5" -> gameData.putAll(Progression.getGameData());
                case "6" -> gameData.putAll(Prime.getGameData());
                default -> {
                }
            }
            question = gameData.get("question");
            correctAnswer = gameData.get("correctAnswer");
            quizResult = Engine.checkQuizResult(question, correctAnswer);
            countOfRightAnswer++;
        } while (quizResult && countOfRightAnswer != MAX_NUMBER_OF_ROUND);

        printGameResult(quizResult);
    }

    private static void printGameResult(boolean gameResult) {
        if (gameResult) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
