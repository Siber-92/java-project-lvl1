package hexlet.code.games;

import static java.lang.System.out;

public class Calculator {
    private static String[] operators = {"+", "-", "*"};

    public static void printRulesOfGames() {
        out.println("What is the result of the expression?");
    }

    public static int getAmountOfOperators() {
        return operators.length;
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand, int index) {
        int[] expressions = {firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};

        return String.valueOf(expressions[index]);
    }

    public static String generateGameQuest(int firstOperand, int secondOperand, int index) {
        return firstOperand + " " + (operators[index]) + " " + secondOperand;
    }
}
