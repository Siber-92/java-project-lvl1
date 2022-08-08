package hexlet.code.games;

public class Calculator {
    private static final String[] operators = {"+", "-", "*"};
    private static int indexOfOperator;

    public static void printRulesOfGames() {
        System.out.println("What is the result of the expression?");
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand) {
        indexOfOperator = (int) (Math.random() * operators.length);
        int[] expressions = {firstOperand + secondOperand, firstOperand - secondOperand, firstOperand * secondOperand};

        return String.valueOf(expressions[indexOfOperator]);
    }

    public static String generateGameQuest(int firstOperand, int secondOperand) {
        return firstOperand + " " + (operators[indexOfOperator]) + " " + secondOperand;
    }
}
