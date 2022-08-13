package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int HIGHER_BOUND = 15;

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][2];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int firstProgressionValue = Utilities.getRandomNumber();
            int stepOfProgression = Utilities.getRandomNumber();
            int progressionSize = Utilities.getRandomNumber(HIGHER_BOUND);
            int indexOfHiddenElement = (int) (Math.random() * progressionSize);

            int[] numbers = new int[progressionSize];
            StringBuilder question = new StringBuilder();

            numbers[0] = firstProgressionValue;
            for (int indexOfProgression = 1; indexOfProgression < numbers.length; indexOfProgression++) {
                numbers[indexOfProgression] = numbers[indexOfProgression - 1] + stepOfProgression;

                if (indexOfProgression == indexOfHiddenElement) {
                    question.append("..").append(" ");
                } else {
                    question.append(numbers[indexOfProgression]).append(" ");
                }
            }
            questionAndAnswer[i][0] = question.toString();
            questionAndAnswer[i][1] = String.valueOf(numbers[indexOfHiddenElement]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
