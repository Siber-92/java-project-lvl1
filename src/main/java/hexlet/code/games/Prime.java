package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Prime {
    private static String gameQuest;
    private static String correctAnswer;

    public static void printRulesOfGame() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise 'no'");
    }

    public static void generateGameData() {
        int operand = Utilities.getRandomNumber();

        correctAnswer = "yes";
        for (int i = operand / 2; i > 1; i--) {
            if (operand % i == 0) {
                correctAnswer = "no";
                break;
            }
        }
        gameQuest = String.valueOf(operand);
    }

    public static void startGame() {
        Cli.printGreet();
        printRulesOfGame();

        boolean quizResult;
        int countOfRightAnswer = 0;
        do {
            generateGameData();
            quizResult = Engine.checkQuizResult(gameQuest, correctAnswer);
            countOfRightAnswer++;
        } while (quizResult && countOfRightAnswer != Utilities.MAX_NUMBER_OF_ROUND);

        Engine.printGameResult(quizResult);
    }
}
