package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int HIGHER_BOUND = 15;

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][Engine.ROUND_DATA_INDEX];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int firstProgressionValue = Utilities.getRandomNumber();
            int stepOfProgression = Utilities.getRandomNumber();
            int progressionSize = Utilities.getRandomNumber(HIGHER_BOUND);
            int indexOfHiddenElement = (int) (Math.random() * progressionSize);

            int[] numbers = new int[progressionSize];
            StringBuilder question = new StringBuilder();

            for (int indexOfProgression = 0; indexOfProgression < numbers.length; indexOfProgression++) {
                if (indexOfProgression == 0) {
                    numbers[indexOfProgression] = firstProgressionValue;
                } else {
                    numbers[indexOfProgression] = numbers[indexOfProgression - 1] + stepOfProgression;
                }

                if (indexOfProgression == indexOfHiddenElement) {
                    question.append("..").append(" ");
                } else {
                    question.append(numbers[indexOfProgression]).append(" ");
                }
            }
            questionAndAnswer[i][Engine.QUESTION_INDEX] = question.toString();
            questionAndAnswer[i][Engine.CORRECT_ANSWER_INDEX] = String.valueOf(numbers[indexOfHiddenElement]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
