package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static int operand;

    public static void generateGameQuest(int number) {
        operand = number;
    }

    public static String getRulesOfGame() {
        return "Answer 'yes' if number even otherwise 'no'";
    }

    public static String getCorrectAnswer() {
        return operand % 2 == 0 ? "yes" : "no";
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
