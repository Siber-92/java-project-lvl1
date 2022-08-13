package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Calculator {
    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][Engine.ROUND_DATA_INDEX];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int firstNumber = Utilities.getRandomNumber();
            int secondNumber = Utilities.getRandomNumber();
            int indexOfOperator = (int) (Math.random() * OPERATORS.length);

            int[] expressions = {firstNumber + secondNumber, firstNumber - secondNumber, firstNumber * secondNumber};

            questionAndAnswer[i][Engine.QUESTION_INDEX] =
                    firstNumber + " " + (OPERATORS[indexOfOperator]) + " " + secondNumber;
            questionAndAnswer[i][Engine.CORRECT_ANSWER_INDEX] = String.valueOf(expressions[indexOfOperator]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
