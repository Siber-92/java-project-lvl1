package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Calculator {
    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][2];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int firstNumber = Utilities.getRandomNumber();
            int secondNumber = Utilities.getRandomNumber();
            int indexOfOperator = (int) (Math.random() * OPERATORS.length);

            int[] expressions = {firstNumber + secondNumber, firstNumber - secondNumber, firstNumber * secondNumber};

            questionAndAnswer[i][0] = firstNumber + " " + (OPERATORS[indexOfOperator]) + " " + secondNumber;
            questionAndAnswer[i][1] = String.valueOf(expressions[indexOfOperator]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
