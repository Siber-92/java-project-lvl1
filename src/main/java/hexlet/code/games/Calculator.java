package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static int indexOfOperator;
    private static int firstOperand;
    private static int secondOperand;

    public static void generateGameQuest(int firstNumber, int secondNumber) {
        firstOperand = firstNumber;
        secondOperand = secondNumber;
        indexOfOperator = (int) (Math.random() * OPERATORS.length);
    }

    public static String getRulesOfGame() {
        return "What is the result of the expression?";
    }

    public static String getCorrectAnswer() {
        int[] expressions = {firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};

        return String.valueOf(expressions[indexOfOperator]);
    }

    public static String getGameQuest() {
        return firstOperand + " " + (OPERATORS[indexOfOperator]) + " " + secondOperand;
    }

    public static void generateGameVariable() {
        Engine.setVariable(getRulesOfGame(), getGameQuest(), getCorrectAnswer());
    }

    public static void startGame(int firstNumber, int secondNumber) {
        Engine.generateGamesVariable();
        generateGameQuest(firstNumber, secondNumber);
        generateGameVariable();
    }
}
