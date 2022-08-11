package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import java.util.HashMap;

public class Calculator {
    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static HashMap<String, String> getGameData() {
        HashMap<String, String> gameData = new HashMap<>();

        int firstOperand = Utilities.getRandomNumber();
        int secondOperand = Utilities.getRandomNumber();
        int indexOfOperator = (int) (Math.random() * OPERATORS.length);

        int[] expressions = {firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};

        gameData.put("question", firstOperand + " " + (OPERATORS[indexOfOperator]) + " " + secondOperand);
        gameData.put("correctAnswer", String.valueOf(expressions[indexOfOperator]));

        return gameData;
    }

    public static void startGame() {
        Engine.printGreet(RULES);
        Engine.gameLoop();
    }
}
