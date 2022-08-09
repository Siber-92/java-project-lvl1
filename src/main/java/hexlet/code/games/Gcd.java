package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    private static int firstOperand;
    private static int secondOperand;

    public static void generateGameQuest(int firstNumber, int secondNumber) {
        firstOperand = firstNumber;
        secondOperand = secondNumber;
    }

    public static String getRulesOfGame() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String getCorrectAnswer() {
        int leastOperand = Math.min(firstOperand, secondOperand);

        while (leastOperand > 0) {
            if (firstOperand % leastOperand == 0 && secondOperand % leastOperand == 0) {
                break;
            }
            leastOperand--;
        }
        return String.valueOf(leastOperand);
    }

    public static String getGameQuest() {
        return firstOperand + " " + secondOperand;
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
