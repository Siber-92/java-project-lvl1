package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static int operand;

    public static void generateGameQuest(int number) {
        operand = number;
    }

    public static String getRulesOfGame() {
        return "Answer 'yes' if given number is prime. Otherwise 'no'";
    }

    public static String getCorrectAnswer() {
        String correctAnswer = "yes";

        for (int i = operand / 2; i > 1; i--) {
            if (operand % i == 0) {
                correctAnswer = "no";
                break;
            }
        }
        return correctAnswer;
    }

    public static String getGameQuest() {
        return String.valueOf(operand);
    }

    public static void generateGameVariable() {
        Engine.setVariable(getRulesOfGame(), getGameQuest(), getCorrectAnswer());
    }

    public static void startGame(int number) {
        Engine.generateGamesVariable();
        generateGameQuest(number);
        generateGameVariable();
    }
}
