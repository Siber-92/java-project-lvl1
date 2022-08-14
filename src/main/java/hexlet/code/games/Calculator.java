package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;

public class Calculator {
    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int firstNum = Utilities.getRandomNumber();
            int secondNum = Utilities.getRandomNumber();
            int indexOfOperator = Utilities.getRandomNumber(OPERATORS.length);

            int[] expressions = {firstNum + secondNum, firstNum - secondNum, firstNum * secondNum};

            questionAndAnswer[i][QUESTION_INDEX] = firstNum + " " + (OPERATORS[indexOfOperator]) + " " + secondNum;
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = String.valueOf(expressions[indexOfOperator]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
