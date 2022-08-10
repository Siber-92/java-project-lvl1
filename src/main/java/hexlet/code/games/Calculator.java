package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Calculator {
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static String gameQuest;
    private static String correctAnswer;

    public static void printRulesOfGame() {
        System.out.println("What is the result of the expression?");
    }

    public static void generateGameData() {
        int firstOperand = Utilities.getRandomNumber();
        int secondOperand = Utilities.getRandomNumber();
        int[] expressions = {firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};
        int indexOfOperator = (int) (Math.random() * OPERATORS.length);

        correctAnswer = String.valueOf(expressions[indexOfOperator]);
        gameQuest = firstOperand + " " + (OPERATORS[indexOfOperator]) + " " + secondOperand;
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
