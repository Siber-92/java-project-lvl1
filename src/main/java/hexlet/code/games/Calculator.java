package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;
import static hexlet.code.Utilities.getRandomNumber;

public class Calculator {
    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static int getCalculationResult(int firstNum, int secondNum, int indexOfOperator) {
        return switch (OPERATORS[indexOfOperator]) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> {
                try {
                    throw new Exception("Error: Received operator not recognized");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int firstNum = getRandomNumber();
            int secondNum = getRandomNumber();
            int indexOfOperator = getRandomNumber(OPERATORS.length);

            String calculationResult = String.valueOf(getCalculationResult(firstNum, secondNum, indexOfOperator));

            questionAndAnswer[i][QUESTION_INDEX] = firstNum + " " + (OPERATORS[indexOfOperator]) + " " + secondNum;
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = calculationResult;
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.startGameLoop(RULES, generateGameData());
    }
}
