package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Gcd {
    private static String gameQuest;
    private static String correctAnswer;

    public static void printRulesOfGame() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static void generateGameData() {
        int firstOperand = Utilities.getRandomNumber();
        int secondOperand = Utilities.getRandomNumber();
        int leastOperand = Math.min(firstOperand, secondOperand);

        while (leastOperand > 0) {
            if (firstOperand % leastOperand == 0 && secondOperand % leastOperand == 0) {
                break;
            }
            leastOperand--;
        }
        correctAnswer = String.valueOf(leastOperand);
        gameQuest = firstOperand + " " + secondOperand;
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
