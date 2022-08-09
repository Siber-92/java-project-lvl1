package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final int LOWER_BOUND = 5;
    private static int[] numbers;
    private static int indexOfHiddenElement;

    public static void generateGameQuest(int firstProgressionValue, int stepOfProgression) {
        int progressionSize = LOWER_BOUND + (int) (Math.random() * LOWER_BOUND);

        indexOfHiddenElement = (int) (Math.random() * progressionSize);
        numbers = new int[progressionSize];
        numbers[0] = firstProgressionValue;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + stepOfProgression;
        }
    }

    public static String getRulesOfGame() {
        return "What number is missing in the progression?";
    }

    public static String getCorrectAnswer() {
        return String.valueOf(numbers[indexOfHiddenElement]);
    }

    public static String getGameQuest() {
        String[] convertedArray = new String[numbers.length];
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            convertedArray[i] = i != indexOfHiddenElement ? String.valueOf(numbers[i]) : "..";
            question.append(convertedArray[i]).append(" ");
        }
        return question.toString();
    }

    public static void generateGameVariable() {
        Engine.setVariable(getRulesOfGame(), getGameQuest(), getCorrectAnswer());
    }

    public static void startGame(int firstProgressionValue, int stepOfProgression) {
        Engine.generateGamesVariable();
        generateGameQuest(firstProgressionValue, stepOfProgression);
        generateGameVariable();
    }
}
